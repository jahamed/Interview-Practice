public class LeftPad {
    public static String leftPad(String inputStr, int padLength, char ch) {
        if (padLength <= inputStr.length()) {
            return inputStr;
        }
        StringBuilder builder = new StringBuilder();
        padLength = padLength - inputStr.length();

        for (int i = 0; i < padLength; i++) {
            builder.append(ch);
        }

        builder.append(inputStr);
        return builder.toString();
    }

    public static String leftPad(String inputStr, int paddedLength) {
        return leftPad(inputStr, paddedLength, '.');
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        System.out.println(leftPad("1", 1));
        System.out.println(leftPad("2", 2));
        System.out.println(leftPad("3", 3));
        System.out.println(leftPad("4", 4));
        System.out.println(leftPad("5", 5));
        System.out.println(leftPad("hello", 7));
        System.out.println(leftPad("foo",  6));
        System.out.println(leftPad("foo", 3));
        System.out.println(leftPad("foobar", 3));
        System.out.println(leftPad("foo", 6, '?'));
    }
}
