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

    public static void main(String[] args) {
        int[] input = {1, 7, 3, 4};
        for(int x : getProductsOfAllIntsExceptAtIndex(input)) {
            System.out.println(x);
        }
    }
}
