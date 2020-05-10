
/**
 * * XOR - bitwise operator
 * * takes two operands, evaluates to true only when both are different
 *
 * Write a function findMissing that takes two arrays and returns missing element from the second array.
 * findMissing(
 * [3,1,9,2,6] , [1,2,6,9]
 * ) => 3
 *
 * Assumptions -
 * 1. array of non negative unique integers
 * 2. exactly one element missing
 *
 *
* */
public class XOR
{

    /**
     * Time complexity - O(n) [Linear]
     * Space complexity -
     * Concept - 1^3^1 = 1
     * */
    static int findMissing(int[] arrOne, int[] arrTwo)
    {
        int xor_all = 0;

        for (int num : arrOne)
            xor_all ^= num;

        for (int num : arrTwo)
            xor_all ^= num;

        return xor_all;
    }

    public static void main(String[] args)
    {
        int missingElement = XOR.findMissing(new int[]{3,1,9,2,6}, new int[]{1,2,6,9});
        System.out.println("Missing Element is = " + missingElement);
    }
}
