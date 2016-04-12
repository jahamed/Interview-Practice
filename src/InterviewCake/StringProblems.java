package InterviewCake;

import java.util.HashSet;
import java.util.Set;

public class StringProblems {
    public String reverseInPlace(String str) {
        // O(n) time and O(1) space
        char[] strChars = str.toCharArray();

        int startIndex = 0;
        int endIndex = strChars.length - 1;

        while (startIndex < endIndex) {

            // swap characters
            char temp = strChars[startIndex];
            strChars[startIndex] = strChars[endIndex];
            strChars[endIndex] = temp;

            // move towards middle
            startIndex++;
            endIndex--;
        }

        return new String(strChars);
    }

    public boolean hasPalindromePermutation(String theString) {
        // O(n) time, O(k) space, ASCII & Unicode have set char limits

        // track characters we've seen an odd number of times
        Set<Character> unpairedCharacters = new HashSet<Character>();

        for (char c : theString.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        // the string has a palindrome permutation if it
        // has one or zero characters without a pair
        return unpairedCharacters.size() <= 1;
    }
}
