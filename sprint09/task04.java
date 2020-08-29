/*
 * Write a String differentWords(String originalText, String modifyText) method
 * of the MyUtils class to compare originalText and modifyText.
 * The differentWords() method return the modified text with uppercase of additional words.
 * For example, for a given originalText:
 * Java is a programming language that is class-based and
 * designed to have as few implementation dependencies as possible.
 * and modifyText:
 * Java is a   general-purpose programming   language that is class-based object-oriented and
 * designed to have as few implementation dependencies as possible.
 * you should get:
 * Java is a   GENERAL-PURPOSE programming   language that is class-based OBJECT-ORIENTED and
 * designed to have as few implementation dependencies as possible.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public String differentWords(String originalText, String modifyText) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] array = modifyText.split(" ");

        for (String word : array) {
            if (!originalText.contains(word) || stringBuilder.toString().contains(" " + word + " ")) {
                stringBuilder.append(word.toUpperCase()).append(" ");
                continue;
            }
            stringBuilder.append(word).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
