import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Please, create a static Consumer implementation cons that takes an array of doubles as a parameter
 * and changes it using the next rule: all values that are greater than 2 should be multiplied by 0.8,
 * and other values should be multiplied by 0.9.
 * Also, please implement a static method getChanged that takes an array of doubles as a first parameter
 * and  Consumer as a second. The method should return an array changed by the second parameter.
 * getChanged method should not change initial array.
 */

/**
 * @author Bogdan Kurchak
 */
class App {
    static Consumer<double[]> cons = arrays -> {
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = (arrays[i] > 2) ? (arrays[i] * 0.8) : (arrays[i] * 0.9);
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] copy = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(copy);
        return copy;
    }
}
