package structures;

public class BinarySearch {
    static int binarySearchRecursive(int[] a, int key, int low, int high) {
        if (low > high) return -1;

        int mid = low + ((high - low) / 2);
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRecursive(a, key, low, mid - 1);
        } else {
            return binarySearchRecursive(a, key, mid + 1, high);
        }
    }

    static int binarySearchRecursiveSolution(int[] a, int key) {
        //O(logn) runtime and memorys
        return binarySearchRecursive(a, key, 0, a.length - 1);
    }

    static int binarySearchIterative(int[] a, int key){
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if(a[mid] == key) {
                return mid;
            }else if (key < a[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int test[] = {1, 3, 5, 7, 8, 9, 10};
        System.out.println(binarySearchRecursiveSolution(test, 3));
        System.out.println(binarySearchIterative(test, 9));
    }
}
