package InterviewCake;

public class NumberProblems {

    public static int numAppearsTwice(int[] nums) {
        int maxNum = nums[nums.length - 1];
        int trueSum = (int) (Math.pow(maxNum, 2) + maxNum) / 2;
        int actualSum = 0;

        for (int n : nums) {
            actualSum += n;
        }

        return actualSum - trueSum;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 3, 4, 5};
        System.out.println(numAppearsTwice(test));
    }
}
