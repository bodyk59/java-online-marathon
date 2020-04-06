/* Link: 
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Task:
 * Given two integers dividend and divisor, 
 * divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 */

/**
 * @author Bogdan Kurchak
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Calculate sign of divisor, sign will be "-" if only one of parameters is "-"
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        //Make numbers positive if they are negative,
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;

        int quotient = 0;

        while (dividend - divisor >= 0) {
            dividend -= divisor;
            quotient++;
        }
        
        return (sign == -1) ? -quotient : quotient;
    }
}
