package strings;

import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicates {

    public static void removeDuplicates1(char[] str) {
        Set<Character> set = new LinkedHashSet<Character>();

        int writeIndex = 0;
        int readIndex = 0;

        while(str[readIndex] != '\0') {
            if(!set.contains(str[readIndex])) {
                set.add(str[readIndex]);
                str[writeIndex] = str[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        str[writeIndex] = '\0';
    }

    public static void main(String[] args){
        char testStr[] = {'a', 'b', 'a', 'd', '\0'};
        System.out.println("Duplicate Function 1");
        removeDuplicates1(testStr);
        System.out.println(testStr);
    }
}
