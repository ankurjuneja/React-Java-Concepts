package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array and number k, output all unique pairs that sum up to k.
 * Example: for input [1, 3, 2, 5, 46, 6, 7, 4] and k = 4, output (1, 3).
 * */
public class TwoSum
{
    private static void printTwoSum(int[] array, int k)
    {
        Set<Integer> set = new HashSet<>(); // O(n) -space
        for (int num : array) // O(n) - time
        {
            if (set.contains(k-num)) // O(1)
            {
                System.out.println("(" + (k-num) + "," + num + ")");
                // remove duplicate
                set.remove(k-num); // O(1)
            }
            else
            {
                set.add(num); // O(1)
            }
        }
    }

    public static void main(String[] args)
    {
        TwoSum.printTwoSum(new int[]{1, 1, 3, 2, 5, 46, 6, 7, 4}, 9);
    }
}
