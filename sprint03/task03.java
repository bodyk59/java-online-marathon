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
        boolean flag = true;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.contains(entry.getValue())) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
