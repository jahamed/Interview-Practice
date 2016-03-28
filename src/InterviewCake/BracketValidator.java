package InterviewCake;

//#28

import java.util.*;

public class BracketValidator {

    public static boolean isValid(String input) {

        Map<Character, Character> openersToClosers = new HashMap<Character, Character>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<Character>(openersToClosers.values());

        Stack<Character> openerStack = new Stack<Character>();
        for (char c : input.toCharArray()) {
            if (openers.contains(c)) {
                openerStack.push(c);
            } else if (closers.contains(c)) {
                if (openerStack.isEmpty()) {
                    return false;
                }else {
                    char lastOpener = openerStack.pop();
                    if (openersToClosers.get(lastOpener) != c) {
                        return false;
                    }
                }
            }
        }

        return openerStack.empty();
    }

    public static void main(String[] args) {
        String test = "{ [ ] ( ) }";
        System.out.println(isValid(test));
    }
}
