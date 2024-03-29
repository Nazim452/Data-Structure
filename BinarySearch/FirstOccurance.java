package BinarySearch;

public class FirstOccurance {
    static int firstOccuranceX(int[] arr, int x) {
        int st = 0, end = arr.length - 1;
       
        int firstOcc = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] == x) {
                firstOcc = mid;
                end = mid - 1;

            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return firstOcc;
    }

    public static void main(String[] args) {
        int[]arr ={2,2,3,3,3,5,5,6,7,8,8,8};
        System.out.println(firstOccuranceX(arr, 5));

    }
}
