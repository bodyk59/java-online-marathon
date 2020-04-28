import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Write a String reformatLines(String text) method of the MyUtils class
 * to replacing all spaces with one and reformat lines of input text.
 * Length of every lines should not exceed 60 characters.
 * For example, for a given text
 * Java    was      originally developed
 * by    James   Gosling at Sun Microsystems (which
 * has since been
 * acquired by Oracle) and released in 1995
 * as a core component of Sun Microsystems' Java platform.
 * You should get:
 * Java was originally developed by James Gosling at Sun
 * Microsystems (which has since been acquired by Oracle) and
 * released in 1995 as a core component of Sun Microsystems'
 * Java platform.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public String reformatLines(String text) {
        StringBuilder trimmedLine = new StringBuilder();
        String[] array = text.split("\\s+");

        for (String word : array) {
            trimmedLine.append(word).append(" ");
        }

        Pattern p = Pattern.compile("\\b.{1," + (59) + "}\\b\\W?");
        Matcher m = p.matcher(trimmedLine);
        StringBuilder result = new StringBuilder();

        while(m.find()) {
            result.append(m.group().trim());
            result.append("\n");
        }

        return result.toString().trim();
    }
}
