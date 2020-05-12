import java.io.*;

/*
 * Write a method to read from a file a character-oriented data and return these data as String object.
 * For example, next fragment:
 * "This is text fragment
 * that contains some text data
 * and can be read!"
 * after reading will be transform to the next String object:
 * "This is text fragment\nthat contains some text data\nand can be read!"
 */

/**
 * @author Bogdan Kurchak
 */
public static String readFile(String filename) {
    StringBuilder result = new StringBuilder();
        
    try (FileReader fileReader = new FileReader(filename)) {
        while (fileReader.ready()) {
            result.append((char) fileReader.read());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
        
    return result.toString();
}
