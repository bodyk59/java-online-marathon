import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Create a int countNumbers(IntStream intNum, Stream<String> strNum) method of the MyUtils class
 * to count of numbers that is divisible by 3 or contains the digit 3.
 * The parameters of the method are two Streams with integers and Strings with one number.
 * For example, for a given
 * [[3, 2, 1, 13, 21, 15], ["9", "4", "23", "0", "32", "5"]]
 * you should get 7
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public long countNumbers(IntStream intNum, Stream<String> strNum) {
        List<Integer> listOfInt = intNum.boxed().collect(Collectors.toList());
        List<Integer> intFromString = strNum.filter(Objects::nonNull)
                .filter(i -> !"".equals(i))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return Stream.concat(listOfInt.stream(), intFromString.stream())
                .filter(i -> i != 0)
                .filter(i -> i % 3 == 0 || String.valueOf(i).contains("3"))
                .count();
    }
}
