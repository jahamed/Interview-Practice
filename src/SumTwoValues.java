import java.util.HashSet;
import java.util.Set;

public class SumTwoValues {


    public static boolean sumOfTwo(int[] array, int val) {
        //runtime O(n), memory O(n)
        Set<Integer> found = new HashSet<Integer>();

        for(int a : array) {
            if (found.contains(val - a)) {
                return true;
            }

            found.add(a);
        }

        return false;
    }

    public static boolean sumOfTwo2(int[] array, int val) {
        //runtime O(nlogn) memory O(1)
        //array has to be sorted

        for(int i = 0, j = array.length - 1; i < j;) {
            int sum = array[i] + array[j];
            if (sum == val) {
                return true;
            }else if (sum < val) {
                i++;
            }else{
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int test[] = {3, 4, 5, 6};
        System.out.println(sumOfTwo(test, 10));
        System.out.println(sumOfTwo(test, 10));
    }
}
