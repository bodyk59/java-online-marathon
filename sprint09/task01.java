/*
 * Create a String intToRoman(int number) method of the MyUtils class to convert integer to Roman numerals.
 * The "number" must be positive and do not exceed 3999. Otherwise, throw an IllegalArgumentException.
 * For example, for a given sequence of integer numbers:
 * 5 9 19 91 3999
 * you should get:
 * V IX XIX XCI MMMCMXCIX
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public String intToRoman(int number) {
        if (number > 0 && number <= 3999) {
            int[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < arabicNumbers.length; i++) {
                while (number >= arabicNumbers[i]) {
                    number -= arabicNumbers[i];
                    result.append(romanNumbers[i]);
                }
            }

            return result.toString();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println(new MyUtils().intToRoman(3999));
    }
}
