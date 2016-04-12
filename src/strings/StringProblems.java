package strings;

import java.util.HashMap;

public class StringProblems {
    // http://blog.codingforinterviews.com/
    public static String reverseWrong(String x) {
        /*  Strings are immutable. The "ans" variable is recreated everytime something is added to it.
            A new array is allocated to hold it + extra chars everytime. O(n^2) time.
         */
        // convert x into an array
        char[] string = x.toCharArray();
        // create variable to hold answer
        String ans = "";
        // iterate from the back of the array, each time adding a character to ans
        for (int i = string.length - 1; i >= 0; i--) {
            ans += string[i];
        }
        // return as a String
        return ans;
    }

    public static String reverseCorrect(String x) {
        // convert x into an array
        char[] string = x.toCharArray();
        // create the StringBuffer object
        StringBuffer buffer = new StringBuffer();
        // iterate from the back of the array, each time adding a character to buffer
        for(int i = string.length - 1; i >= 0; i--) {
            buffer.append(string[i]);
        }
        return buffer.toString();
    }

    public static Character firstNonRepeatedChar(String str) {
        HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();

        // populate hashmap with character counts
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (numMap.containsKey(c)) {
                numMap.put(c, numMap.get(c) + 1);
            }else {
                numMap.put(c, 1);
            }
        }

        // find first char in hashmap that has count of 1
        // could use linkedHashMap to prevent second iteration through string?
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (numMap.containsKey(c) && numMap.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    public static boolean isAnagram(String s, String t) {
        // This solution sorts both strings O(nlogn) and then compares them.
        // Another solution is to have an array of 256 chars for ASCII and check that both string have the same char counts
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] string = s.toCharArray();
        java.util.Arrays.sort(string);
        return new String(string);
    }

    // String permutations
    public static void permute(String s) {
        permutationHelper("", s);
    }

    private static void permutationHelper(String ans, String remain) {
        int n = remain.length();
        // ans serves as an accumulator variable
        // base case: we print out ans since there are no more letters to be added
        if (n == 0) {
            System.out.println(ans);
        }
        // recursive case
        else {
            for (int i = 0; i < n; i++) {
                // we call permutation, each time combining prefix with the individual letters in str
                // we also remove these letters from str
                permutationHelper(ans + remain.charAt(i), remain.substring(0,i) + remain.substring(i+1, n));
            }
        }
    }
    //

    public static boolean isRotated(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }


    public static void main(String[] args) {
        String test = "ssrreess";
        System.out.println(firstNonRepeatedChar(test));
        permute("abc");

        //isRotated
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotated(s1, s2));
    }
}
