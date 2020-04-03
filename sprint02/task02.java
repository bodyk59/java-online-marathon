/* Link: 
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Task:
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Function returns 0 when the reversed integer overflows.
 */

/**
 * @author Bogdan Kurchak
 */
class Solution {
    public int reverse(int x) {
        int digit = 0;
        long reversed = 0;
        boolean flag = false;

        //Checks if x is negative, if "yes" - return positive equivalent for this x
        //Make this flag true for future returning value
        if (x < 0) {
            x = -x;
            flag = true;
        }

        //This loop for creating reversed copy of x
        while (x > 0) {
            digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE) {
            reversed = 0;
        }

        //If flag was true - return negative equivalent for reversed
        return (int)(flag ? -reversed : reversed);
    }
}
