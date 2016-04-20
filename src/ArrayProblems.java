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
        return retArr;
    }

    public static void main(String[] args) {
        int[] input = {9, 9, 9, 9};
        int[] input2 = {};
        for(int x : addArrays(input, input2)) {
            System.out.println(x);
        }
    }
}
