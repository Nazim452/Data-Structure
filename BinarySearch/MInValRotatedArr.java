package BinarySearch;

public class MInValRotatedArr {

    // Return index of minimum value in array

    static int minIndRotated(int[] arr) {// 3 , 4, 5 , 1 ,2
        int n = arr.length;
        int st = 0;
        int end = n - 1;

        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] > arr[n - 1]) {
                st = mid + 1;

            } else if (arr[mid] <= arr[n - 1]) {
                end = mid - 1;
                ans = mid;

            }

        }
        return ans;

    }

    // TC - log n
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5,6,7, 1, 2 };
        System.out.println(minIndRotated(arr));
    }
}
