import java.util.Arrays;

public class ArrayProblems {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] input) {
        int[] productsOfAllIntsExceptAtIndex = new int[input.length];

        int productSoFar = 1;
        for (int i=0; i < input.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= input[i];
        }

        productSoFar = 1;
        for (int i = input.length - 1; i >= 0; i--){
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= input[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }

    /*
    Adds two arrays that represent numbers together.
    Ex: [1, 0, 0, 1] + [3, 4, 5] = [1, 3, 4, 6]
     */
    public static int[] addArrays(int[] arr1, int[] arr2) {
        int carry = 0;
        int[] retArr = new int[Math.max(arr1.length, arr2.length) + 1];
        int arr1Index = arr1.length - 1;
        int arr2Index = arr2.length - 1;
        int retArrIndex = retArr.length - 1;

        while (retArrIndex >= 0) {
            int arr1Digit = arr1Index >= 0 ? arr1[arr1Index] : 0;
            int arr2Digit = arr2Index >= 0 ? arr2[arr2Index] : 0;

            int sum = (arr1Digit + arr2Digit + carry) % 10;
            carry = (arr1Digit + arr2Digit + carry) / 10;
            retArr[retArrIndex] = sum;

            arr1Index--;
            arr2Index--;
            retArrIndex--;
        }
        return retArr[0] == 0 ? Arrays.copyOfRange(retArr, 1, retArr.length) : retArr;
    }

    /*
    Adds one to the number representation of input array.
    http://codereview.stackexchange.com/questions/43343/add-one-to-a-number-represented-as-an-array-of-digits
     */
    public static int[] addOne(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {9, 9, 9, 9};
        int[] input2 = {};
        for(int x : addArrays(input, input2)) {
            System.out.println(x);
        }
    }
}
