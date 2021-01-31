package ArraysAndStrings;

public class Kthlargest
{
    public static int findKthLargest(int[] nums, int k)
    {
       if (null == nums || nums.length == 0)
       {
           return Integer.MIN_VALUE;
       }

       return qSort(nums, 0, nums.length-1, k);
    }

    private static int qSort(int[] nums, int left, int right, int k)
    {
        if (nums[left] >= nums[right])
        {
            return nums[right];
        }

        int i = left;
        for (int j = left + 1; j <=  right; j++)
        {
            if (nums[j] > nums[i]) {
                i++;
                swap(nums, i, j);
            }
        }
            swap(nums, i, left);

            if (k == i + 1)
            {
                return nums[i];
            }
            else if (k > i + 1)
            {
                return qSort(nums, i+1, right, k);
            }
            else
            {
                return qSort(nums, left, i-1, k);
            }
    }

    private static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args)
    {
        int  secondlargest = findKthLargest(new int[]{3,2,5,1,6,4}, 2);
    }
}
