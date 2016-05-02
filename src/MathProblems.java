public class MathProblems {
    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.floor(Math.sqrt(n)); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Find the largest power of 2 less than or equal to n
    // https://www.reddit.com/r/learnprogramming/comments/3acny8/compute_the_greatest_power_of_2_less_than_or/
    protected static int largestPowerOf2(int n) {
        // bitwise trick to do it
//        return Integer.highestOneBit(n);

//        int v = 1;
//        while (v <= n) {
//            v *= 2;
//        }
//
//        v /= 2;
//        return v;

        // Solution that stops overflow:
        int v = 1;
        while (v <= n/2) {
            v *= 2;
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(16));

        System.out.println(largestPowerOf2(64)); // 32
    }
}
