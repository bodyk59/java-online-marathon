import java.util.*;

/*
 * Create a createNotebook() method of the MyUtils class
 * to create a new map with name as key and phone list as value.
 * The method receives a map  with phone as key and name as value.
 * For example, for a given map
 * {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
 * you should get
 * {Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> names = new HashMap<>();
        List<String> numbersList = new ArrayList<>();

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            for (Map.Entry<String, String> entry2 : phones.entrySet()) {
                if (entry.getValue() == entry2.getValue()) {
                    numbersList.add(entry2.getKey());
                }
            }

            names.put(entry.getValue(), new ArrayList<>(numbersList));
            phones.remove(entry.getValue());
            numbersList.clear();
        }

        return names;
    }
}
