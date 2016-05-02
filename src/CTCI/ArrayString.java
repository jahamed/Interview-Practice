package CTCI;

import java.util.HashMap;

public class ArrayString {

    // 1.1 Check if a string has all unique characters
    public static boolean isUniqueChars(String str) {
        // standard ASCII has chars from 0 - 127
        // string length cannot be more than the # of unique chars
        if (str.length() > 128) {
            return false;
        }
        boolean[] charArr = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charArr[val]) {
                return false;
            }
            charArr[val] = true;
        }
        return true;
    }

    // 1.2 - Check if two strings are permutations of each other
    public static boolean permutation(String s, String t) {
        // sort strings and compare, same permutation state
        // have to be same lengths short-circuit
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    public static boolean permutation2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letterCount = new int[128]; // ASCII assumption

        // populate count arr with first string
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            letterCount[c]++;
        }

        // count off letters from second string
        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            if (--letterCount[c] < 0) {
                return false;
            }
        }

        return true;
    }

    // 1.3 - URLify a string, replace all spaces with %20
    public static void replaceSpaces(char[] str, int trueLength) {
        // start at the end of the string and work forward
        int spaceCount = 0, index = 0;

        // count # of spaces
        for (char c : str) {
            if (c == ' ') spaceCount++;
        }

        index = trueLength + spaceCount * 2;

        if (trueLength < str.length) str[trueLength] = '\0'; // end array
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    // 1.4 - Check if given string is a permutation from a palindromic word
    public static boolean isPermutationOfPalindrome(String str) {
        // Check to make sure character counts are even, with room for one odd character count
        HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
        boolean foundOdd = false;

        for (char c : str.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            }
            charCounts.putIfAbsent(c, 1);
        }

        for (int x : charCounts.values()) {
            System.out.println(x);
            if (x % 2 != 0 && foundOdd) {
                return false;
            } else if (x % 2 != 0){
                foundOdd = true;
            }
        }

        return true;
    }

    // 1.6 - Compress string aabbbcaaa to a2b3c1a3
    public static String compressString(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                builder.append(str.charAt(i));
                builder.append(count);
                count = 0;
            }
        }

        // return original string if the compressed version isn't shorter
        return builder.length() < str.length() ? builder.toString() : str;
    }

    // 1.9 - Is str2 a rotation of str1? Using only one call to isSubstring()
    public static boolean isRotation(String str1, String str2) {
        // str2 will always be a substring of s1s1 if it is rotated
        if (str1.length() == str2.length()) {
            String str1str1 = str1 + str1;
            return isSubstring(str1str1, str2);
        }
        return false;
    }

    // Helper Functions
    public static String sort(String s) {
        char[] sArr = s.toCharArray();
        java.util.Arrays.sort(sArr);
        return new String(sArr);
    }

    public static boolean isSubstring(String big, String small) {
        return big.indexOf(small) != -1;
    }

    public static void main(String args[]) {
//        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
//
//        for (String word : words) {
//            boolean isUnique = isUniqueChars(word);
//            if (isUnique) {
//                System.out.println("Unique: " + word);
//            }
//        }

//        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
//        for (String[] pair : pairs) {
//            String word1 = pair[0];
//            String word2 = pair[1];
//            boolean anagram = permutation(word1, word2);
//            System.out.println(word1 + ", " + word2 + ": " + anagram);
//            anagram = permutation2(word1, word2);
//            System.out.println(word1 + ", " + word2 + ": " + anagram);
//        }

//        String[] strings = {"Rats live on no evil star",
//                "A man, a plan, a canal, panama",
//                "Lleve",
//                "tacotac",
//                "asda"};
//        for (String s : strings) {
//            boolean a = isPermutationOfPalindrome(s);
//            System.out.println(s);
//            if (a) {
//                System.out.println("Agree: " + a);
//            } else {
//                System.out.println("Disagree: " + a);
//            }
//            System.out.println();
//        }

//        String str = "aaaaabbbbaaaabbddc";
//        System.out.println(compressString(str));

        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
