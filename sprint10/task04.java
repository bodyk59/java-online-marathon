/*
 * In the class ArrayUtil write static method named "averageValue(...)"
 * that takes an object of Array type as input, and returns the average value its elements.
 * The given method should returns value of double type and take any array, whose elements extends Number type.
 */

/**
 * @author Bogdan Kurchak
 */
class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

class ArrayUtil {
    public static double averageValue(Array<? extends Number> array) {
        double result = 0.0;
        for (int i = 0; i < array.length(); i++) {
            result += array.get(i).doubleValue();
        }
        return result / array.length();
    }
}
