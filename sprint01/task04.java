/**
 * @author Bogdan Kurchak
 */
class SumOfDigits {
    public static int sumOfDigits(int number) {
        int thirdDigit = number / 100;
        int secondDigit = (number - (thirdDigit * 100)) / 10;
        int firstDigit = number - (thirdDigit * 100) - (secondDigit * 10);

        return firstDigit + secondDigit + thirdDigit;
    }
}
