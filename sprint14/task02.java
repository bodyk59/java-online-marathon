import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list)
 * method of the MyUtils class to build a Map of all phone numbers.
 * The key of Map is code of network and value contains sorted list of phones.
 * Remove all spaces, brakets and dashes from phone numbers.
 * For example, for a given
 * [["093 987 65 43", "(050)1234567", "12-345"],
 * ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
 * ["(093)-11-22-334", "044 435-62-18", "721-73-45"]]
 * you should get
 * {"050"=["1234567", "2345678"],
 * "067"=["2143657"],
 * "093"=["9876543", "9182736", "1122334"], "044"=["4356218"],
 * "loc"=["7217345", "2241928"],
 * "err"=["12345"]}
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
   public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
       Map<String, List<String>> maps = list.stream()
                .flatMap(s -> s)
                .filter(Objects::nonNull)
                .map(s -> s.replaceAll("\\W", ""))
                .filter(s -> !"".equals(s))
                .distinct().map(s -> {
                    if (s.length() < 7) {
                        s = "err" + s;
                    } else if (s.length() < 10) {
                        s = "loc" + s;
                    }
                    return s;
                })
                .collect(Collectors.groupingBy(s -> s.substring(0, 3)));

        Map<String, Stream<String>> result = new HashMap<>();

        for (Map.Entry<String, List<String>> element : maps.entrySet()) {
            result.put(element.getKey(), element.getValue().stream().map(s -> s.substring(3)));
        }

        return result;
    }
}
