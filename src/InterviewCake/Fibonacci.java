package InterviewCake;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int fibRecursive(int n) {
        // O(2^n) HORRIBLE
        if (n == 0 || n == 1) {
            return n;
        }

        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    // Memoize solution
    public static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int fibMemoize(int n) {
        // O(n) time, O(n) space, O(n) call stack
        // negative index
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative!");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        // calculated already?
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fibMemoize(n - 1) + fibMemoize(n - 2);

        // memoize
        memo.put(n, result);

        return result;
    }

    public static int fibIterative(int n) {
        // O(n) time, O(1) space
        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 0;
        int prevPrev = 1;
        int current = 0;

        for (int i = 0; i < n; i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

    public static void main(String[] args) {
        //System.out.println(fibRecursive(20));
        System.out.println(fibIterative(3));
    }
}
