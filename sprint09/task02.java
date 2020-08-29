import java.util.ArrayDeque;

/*
 * Given a text containing brackets  '(', ')', '{', '}', '[' and ']'.
 * Sequences "\\(", "\\)", "\\[", "\\]", "\\{" and "\\}" are not brackets.
 * Write a boolean verifyBrackets(String text) method of the MyUtils class to check a input text.
 * The brackets must close in the correct order, for example "()", "()[]{}", "{(())}"
 * and "(\\()" are all valid but "(]", ")(" and "([)]" are not.
 */

/**
 * @author Bogdan Kurchak
 */
public class MyUtils {
    public boolean verifyBrackets(String text) {
        text = text.replaceAll("[^{}()\\[\\]]", "");
        ArrayDeque<Character> stack  = new ArrayDeque<>();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
