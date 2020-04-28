import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

/*
 * Pig Latin is a spoken "secret code" that many English-speaking children learn.
 * The rules for written Pig Latin are:
 * If a word begins with a consonant cluster, move it to the end and add "ay";
 * If a word begins with a vowel, add "hay" to the end;
 * Write a String pigLatinConverter(String text) method of the MyUtils class to convert input text.
 * For example, for a given text
 * Pig Latin is simply a form of jargon unrelated to Latin.
 * you should get
 * igPay atinLay ishay implysay ahay ormfay ofhay argonjay unrelatedhay otay atinLay.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
   public String pigLatinConverter(String text) {
        if (!text.isEmpty()) {
            Pattern vowel = Pattern.compile("^([aeiouAEIOU])");
            Pattern consonant = Pattern.compile("^([^aeiouAEIOU])*");
            String splitCondition = "((?<= )|(?<=[,!?.\\-:;`/\\\\])|(?=[,!?.\\-:;`/\\\\]))";
            String punctuation = "([,!?.\\-:;`/ \\\\])";

            StringBuilder result = new StringBuilder();

            for (String word: text.split(splitCondition)) {
                if (word.matches(punctuation)) {
                    result.deleteCharAt(result.length() - 1);
                    result.append(word);
                    continue;
                }

                if (vowel.matcher(word).find()){
                    result.append(word.trim()).append("hay");
                } else {
                    Matcher consonantMather = consonant.matcher(word);

                    if (consonantMather.find()){
                        result.append(word.trim().substring(consonantMather.end()))
                                .append(consonantMather.group())
                                .append("ay");
                    }
                }
                
                result.append(" ");
            }

            return result.toString().trim();
        } else {
            return "";
        }
    }
}
