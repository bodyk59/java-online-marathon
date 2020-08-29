import java.util.*;

/*
 * Create a listMapCompare() method of the MyUtils class to compare the contents
 *  of a list of strings and the values of a map.
 * For example, for a given list [aa, bb, aa, cc]
 * and map {1=cc, 2=bb, 3=cc, 4=aa, 5=cc} you should get true.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!list.contains(entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
