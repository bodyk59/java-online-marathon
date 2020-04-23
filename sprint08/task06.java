import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

/*
 * Please, implement a static method findMaxByCondition of MyUtils
 * class that takes List of integers as a first
 * parameter and predicate as a second and returns the max value from
 * the list that satisfies the condition of the predicate.
 * Also, implement getFilterdValue method of User class.
 * getFilteredValue should be able to take MyUtils::findMaxByCondition as a first parameter and Predicate as a second.
 * This method should return an integer value, evaluated from User's field values using
 * the first and second parameters of getFilterdValue.
 * One more method that needs to be implemented in User class - getMaxValueByCondition.
 * This method has one parameter - Predicate. The implementation should call getFilterdValue method with
 * MyUtils.findMaxByCondition as a first parameter and passed along Predicate as a second.
 */

/**
 * @author Bogdan Kurchak
 */
class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        int result = Integer.MIN_VALUE;

        for (Integer number : numbers) {
            result = predicate.test(number) && number > result
                    ? number
                    : result;
        }

        return result;
    }
}

class User{
    public final List<Integer> values = new ArrayList<>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction,
                        Predicate<Integer> predicate){
        return biFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}
