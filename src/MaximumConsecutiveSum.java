//http://www.wikiwand.com/en/Maximum_subarray_problem
//https://www.youtube.com/watch?v=jb0yd_ZcfgI

public class MaximumConsecutiveSum {
    public static void main(String[] args) {
        int[] a = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {5, -6, 4, 8};
        int[] c = {};
       System.out.println(maximumConsecutiveSum(c));
    }

    //returns the maximum consecutive sum from a given array
    public static int maximumConsecutiveSum(int[] array) {
        int current = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (current < 0) {
                current = 0;
            }
            current += array[i];
            if(current > max) {
                max = current;
            }
        }
        return max;
    }
}
