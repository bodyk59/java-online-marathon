/* Link: 
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Task:
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 */

/**
 * @author Bogdan Kurchak
 */
class Solution {
    public boolean isPalindrome(int x) {
        int copy = x;
        int digit = 0;
        int reversed = 0;

        //This loop for creating reversed copy of x
        while (copy > 0) {
            digit = copy % 10;
            reversed = reversed * 10 + digit;
            copy /= 10;
        }

        return x == reversed;
    }
}
