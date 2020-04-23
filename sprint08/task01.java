import java.util.function.Predicate;

/*
 * Please, implement a static method getCount that takes an array of integers as the first parameter.
 * The second parameter - a functional interface that works with integers and defines a condition.
 * The method should return the count of elements in the array
 * that satisfy the condition defined by the second argument.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public static int getCount(int[] array, Predicate<Integer> predicate) {
        int count = 0;
        
        for (int number : array) {
            if (predicate.test(number)) {
                count++;
            }
        }

        return count;
    }
}
