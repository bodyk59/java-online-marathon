import java.util.Arrays;
import java.util.Comparator;

/*
 * Create a arrSort() method of the MyUtils class to sort a two-dimensional integer array 
 * by descending the elements of the first column.  
 * In the case of equality of elements in the first column, 
 * the elements of the second column must be sorted in ascending order.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public static class ArraysElementsComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] firstArray, int[] secondArray) {
            return (firstArray[0] == secondArray[0]) ? (firstArray[1] - secondArray[1]) : (secondArray[0] - firstArray[0]);
        }
    }

    public int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, new ArraysElementsComparator());
        return arr;
    }
}
