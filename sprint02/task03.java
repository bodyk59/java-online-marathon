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
        // Calculate sign of divisor, sign will be "-" if only one of parameters is "-"
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        //Create long copy of input parameters
        long dividendLong = dividend;
        long divisorLong = divisor;

        //Make numbers positive if they are negative,
        dividendLong = dividendLong < 0 ? -dividendLong : dividendLong;
        divisorLong = divisorLong < 0 ? -divisorLong : divisorLong;

        long quotient = 0;
        //This variables are for keeping track of the increased/decreased divisor and base
        long currentQuotientBase = 1;
        long currentDivisor = divisorLong;

        //In this loop I use "*", "/" operators only for speeding up subtraction, not for division
        while (dividendLong >= divisorLong) {
            if (dividendLong >= currentDivisor) {
                dividendLong -= currentDivisor;
                quotient += currentQuotientBase;

                //Doubled currentDivisor for speeding up
                currentDivisor *= 2;
                currentQuotientBase *= 2;
            //If current divisor is to large - halve it
            } else {
                currentDivisor /= 2;
                currentQuotientBase /= 2;
            }
        }

        //If sign was "-" return to it
        quotient *= sign;

        //If quotient bigger than 2^31-1 return 2^31-1
        if (quotient > Integer.MAX_VALUE) {
            quotient = Integer.MAX_VALUE;
        }

        return (int)quotient;
    }
}
