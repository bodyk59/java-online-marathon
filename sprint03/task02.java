import java.util.*;

/*
 * Create the strSort() method of the MyUtils class to sort a list of stirngs
 * first by length and alphabetically within the same length. The original list must be unchanged. 
 * For example, for a given list [zz, abc, aa, aaa] you should get [aa, zz, aaa, abc].
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public static class StringLengthComparator implements Comparator<String>{
        @Override
        public int compare(String firstString, String secondString) {
            return Integer.compare(firstString.length(), secondString.length());
        }
    }

    public static class StringAlphabeticalComparator implements Comparator<String>{
        @Override
        public int compare(String firstString, String secondString) {
            return firstString.compareTo(secondString);
        }
    }

    public List<String> strSort(List<String> originList) {
        List<String> copyOriginList = new ArrayList<>(originList);
        Collections.sort(copyOriginList, new StringAlphabeticalComparator());
        Collections.sort(copyOriginList, new StringLengthComparator());

        return copyOriginList;
    }
}
