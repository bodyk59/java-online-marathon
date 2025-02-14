/* Link: 
 * https://leetcode.com/problems/sqrtx/
 * 
 * Task:
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated 
 * and only the integer part of the result is returned.
 */

/**
 * @author Bogdan Kurchak
 */
class Solution {
    public int mySqrt(int x) {
        long product = 0;
        int i;

        for (i = 0; i <= x; i++) {
            product = (long)i * i;

            if (product >= x) {
                break;
            }
        }

        return (product > x) ? (i - 1) : i;
    }
}
