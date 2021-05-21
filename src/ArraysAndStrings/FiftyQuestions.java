package ArraysAndStrings;

import java.util.*;

// Byte-by-byte and cracking the coding interview
public class FiftyQuestions {

    /** 1. Find median of two sorted arrays
     * arr1 = [1, 3, 5]
     * arr2 = [2, 4, 6]
     * median(arr1, arr2) = 3.5
     * */
    static double median(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int medianIndex;
        boolean even = totalLength % 2 == 0;
        if (even) {
            medianIndex = totalLength / 2;
        }
        else {
            medianIndex = (totalLength - 1) / 2;
        }

        int i = 0, j = 0;
        int[] nums3 = new int[medianIndex + 1];
        for (int k = 0; k <= medianIndex; k++) {
            if (i >= nums1.length)
                nums3[k] = nums2[j++];
            else if (j >= nums2.length)
                nums3[k] = nums1[i++];
            else if (nums1[i] <= nums2[j])
                nums3[k] = nums1[i++];
            else {
                nums3[k] = nums2[j++];
            }
        }

        if (even)
            return (nums3[medianIndex] + nums3[medianIndex-1]) / 2.0;
        else
            return nums3[medianIndex];
    }

    /** 2. Given a list of items with values and weights, as well as a max weight, find the
     maximum value you can generate from items where the sum of the weights is less than
     the max.
     */
    // Item class
    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int knapsack(Item[] items, int W) {
        // cache[i][j] = max value for the first i items with a max weight of j
        int[][] cache = new int[items.length + 1][W + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= W; j++) {
                // If including item[i-1] would exceed max weight j, don't
                // include the item. Otherwise take the max value of including
                // or excluding the item
                if (items[i-1].weight > j) cache[i][j] = cache[i-1][j];
                else cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-items[i-1].weight] + items[i-1].value);
            }
        }

        return cache[items.length][W];
    }

    /**
     * 4. Find Duplicates
     *
     * Given an array of integers where each value 1 <= x <= len(array), write a
     * function that finds all the duplicates in the array.
     * */
    static int[] findDuplicates(int[] arr) {
        Set<Integer> uniqueNums = new HashSet<>();
        int[] dups = new int[arr.length];
        int j = 0;
        for (int num : arr) {
            if (!uniqueNums.add(num)) {
                dups[j++] = num;
            }
        }
        return dups;
    }

    static int consecutiveArray(int[] arr) {
        Set<Integer> values = new HashSet<>();
        for (int i : arr) {
            values.add(i);
        }

        // For each value, check if its the first in a sequence of consecutive
        // numbers and iterate through to find the length of the consecutive
        // sequence
        int maxLength = 0;
        for (int i : values) {
            // If it is not the leftmost value in the sequence, don't bother
            if (values.contains(i - 1))
                continue;
            int length = 0;

            // Iterate through sequence
            while (values.contains(i++)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    /**
     * ctci 17.6
     * write a method to find indices m and n s.t. if you sorted elements m through n,
     * the entire array would be sorted. Minimize n-m
     * Input : 1,2,4,7,10,7,12,6,7,16,18,19
     * Output: 3,9
     * */
    static void findIndices(int[] arr) {  //not correct
        int firstIndex = 0;
        int lastIndex = 0;
        int j = 0;
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i] > arr[i+1]) {
                firstIndex = i + 1;
                break;
            }
        }
        for (int i = arr.length-1; i > 2; i-- ) {
            if (arr[i] > arr[i-1]) {
                lastIndex = i;
                break;
            }
        }
        for (int i = 0; i <= firstIndex; i++) {
            if (arr[i] == arr[firstIndex]) {
                System.out.println("first index is " + i);
                break;
            }
        }
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (arr[i] == arr[firstIndex]) {
               j = i;
            }
        }
            System.out.println("last index is = " + j );
    }

    /** ctci 17.7 given 1284 print "One Thousand Two Hundred Eighty Four*/
    static void printIntegerInWords(int num) {

    }

    /** ctci 17.8 contiguous sequence with largest sum*/
    static int cSum(int[] arr) {
        int maxSum = 0;
        int currSum = 0;
        for (int j : arr) {
            currSum += j;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    static void allPairs(int[] arr, int k) {
        // 1,2,2,3 and k = 4 => (1,3) and (2,2)
        Map<Integer, Integer> nums = new HashMap<>();
        for (int num : arr)
            nums.merge(num, 1 , Integer::sum);
        for (int num : arr) {
            if (num == k - num && nums.get(num) > 1)
                System.out.printf("Pair - (%d:%d)%n", num, num);
            if (nums.containsKey(k-num))
                System.out.printf("Pair - (%d:%d)%n", num, k-num);

        }
    }

    static int search(int[] nums, int target, int left, int right) {
        // 50, 60, 70, 80, 0, 10, 20, 30, 40
        //  0   1   2   3  4   5   6   7   8
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        else if (right < left)
            return -1;

        if (nums[left] < nums[mid]) { // left of mid is sorted
            if (target <= nums[mid] && target >= nums[left]) { // element is in left array
                return search(nums, target, left, mid-1);
            }
            else {
                return search(nums, target, mid+1, right);
            }
        }
        else if (nums[mid] < nums[right]) { // right of mid is sorted
            if (target >= nums[mid] && target <= nums[right]) { //
                return search(nums, target, mid+1, right);
            }
            else {
                return search(nums, target, left, mid-1);
            }
        }
        else if (target <= nums[right]) {
            return search(nums, target, mid+1, right);
        }
        else {
            return search(nums, target, left, mid-1);
        }
    }

    /**
     * longest substring without repeating characters
     * */

    public static int lengthOfLongestSubstring(String s) {
        // a b c a b c b b
        // 0 1 2 3 4 5 6 7
        if (s.length() <= 1)
            return s.length();
        Map<Character, Integer> seenCharacters = new HashMap<>();
        int left = 0, longest = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (null != seenCharacters.get(currentChar) && seenCharacters.get(currentChar) >= left) {
                left = seenCharacters.get(currentChar) + 1;
            }
            longest = Math.max(longest, right-left+1);
            seenCharacters.put(currentChar, right);
        }

        return longest;

    }

    /**
     * Container with largest amount of water
     * concept - 2 shifting pointers
     */
    public static int maxArea(int[] height) {

        if (height.length <= 1) return 0;

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left <= right) {
            int leftNum = height[left];
            int rightNum = height[right];

            maxArea = Math.max(maxArea, Math.min(leftNum, rightNum) * (right-left));
            if (leftNum < rightNum) left++;
            else right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int index = search(new int[]{2,2,2,3,4,2}, 3, 0, 5);
        System.out.println("index of 3 is " + index);
    }
}
