package BinarySearch;

public class RecursBinSrch {
    // / binary search by recursively

    static boolean binarySearchR(int[] arr, int st, int end, int target) {
        if (st > end)
            return false;

        int mid = (st + end) / 2;

        if (target == arr[mid]) {
            return true;
        } else if (target < arr[mid]) {

            return binarySearchR(arr, st, mid - 1, target);
        } else {

            return binarySearchR(arr, mid + 1, end, target);
        }

    }

    // TC _- O(log n)
    // SC _ O(log n)

    public static void main(String[] args) {
        int[] arr = { 1, 6, 8, 45, 67, 89 };

        System.out.println(binarySearchR(arr, 0, arr.length - 1, 16));

    }
}
