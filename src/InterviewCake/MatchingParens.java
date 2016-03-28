package InterviewCake;

//#28

public class MatchingParens {

    public static int getClosingParen(String input, int firstParenPos) {

        int openParenCount = 0;

        for (int i=firstParenPos + 1; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == ')') {
                if (openParenCount == 0) {
                    return i;
                } else {
                    openParenCount -= 1;
                }
            }else if (current == '(') {
                openParenCount += 1;
            }
        }

        throw new IllegalArgumentException("No closing parenthesis!");
    }

    public static void main(String[] args) {
        String test = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        String test2 = "((oh no)";
        System.out.println(getClosingParen(test, 10));
        System.out.println(getClosingParen(test2, 0));
    }
}
