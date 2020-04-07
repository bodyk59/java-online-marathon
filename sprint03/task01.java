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
            //Checks if firstArray have 0 length, if yes secondArray will go first
            if (firstArray.length == 0) {
                //Checks if either of arrays have 0 length, if yes they are equal
                if (secondArray.length == 0) {
                    return 0;
                }
                return 1;
            }

            //Checks if secondArray have 0 length, if yes firstArray will go first
            if (secondArray.length == 0) {
                return -1;
            }

            //Checks firstArray length, if it is 1, firstArray will go first
            if (firstArray.length == 1) {
                //Checks secondArray length, if it is 1, firstArray and secondArray will be compared
                if (secondArray.length == 1) {
                    return Integer.compare(secondArray[0], firstArray[0]);
                }

                return Integer.compare(0, firstArray[0]);
            }

            //Checks secondArray length, if it is 1, firstArray and secondArray will be compared
            if (secondArray.length == 1) {
                return Integer.compare(secondArray[0], firstArray[0]);
            }

            //If firstArray[0] bigger, this array will go first
            if (firstArray[0] > secondArray[0]) {
                return -1;
            //If firstArray[0] smaller, this array will go second
            } else if (firstArray[0] < secondArray[0]) {
                return 1;
            } else {
                //If firstArray[0] and secondArray[0] is equal, compare firstArray[1] and secondArray[1]
                //If firstArray[1] bigger, this array will go second
                if (firstArray[1] > secondArray[1]) {
                    return 1;
                //If firstArray[1] smaller, this array will go first
                } else if (firstArray[1] < secondArray[1]) {
                    return -1;
                }

                //Else they are equal
                return 0;
            }
        }
    }

    public int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, new ArraysElementsComparator());
        return arr;
    }
}
