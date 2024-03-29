package BinarySearch;

public class TargetInRotatedArr {

    // Find Target in rotated array in Duplicate number present__________________________
    // BInary search not work in duplicate array of element

    static int findTarget_Dup(int[] arr, int target) {

        int st = 0, end = arr.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (target == arr[mid]) {
                return mid;

            } else if (arr[st] == arr[mid] && arr[end] == mid) {// remove dup elem
                st++;
                end--;
            }

            else if (arr[mid] <= arr[end]) { // mid to end sorted

                // here also equal to add bcz in eaual to condition pivot elem is not pres btw

                if (target > arr[mid] && target <= arr[end]) { // whether elem present btw mid to end or not
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else { // st to mid sorted
                if (target < arr[mid] && target >= arr[st]) { // ehether elem present btw the st to mid
                    end = mid - 1;

                } else {
                    st = mid + 1;
                }

            }

        }
        return -1;

    }

    // return the index of the taget int in rotated array - using bin search
    // here 2 property of rotated array used

    static int findTarget(int[] arr, int target) {

        int st = 0, end = arr.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < end) { // mid to end sorted
                if (target > arr[mid] && target <= end) { // whether elem present btw mid to end or not
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else { // st to mid sorted
                if (target >= arr[st] && target < arr[mid]) { // ehether elem present btw the st to mid
                    end = mid - 1;

                } else {
                    st = mid + 1;
                }

            }

        }
        return -1;

    }





    static int findTarget2(int[] arr, int target) {

        int st = 0, end = arr.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[end]) { // mid to end sorted
                if (target > arr[mid] && target <= arr[end]) { // whether elem present btw mid to end or not
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else { // st to mid sorted
                if (target >= arr[st] && target < arr[mid]) { // ehether elem present btw the st to mid
                    end = mid - 1;

                } else {
                    st = mid + 1;
                }

            }

        }
        return -1;

    }

    public static void main(String[] args) {
        // int[] arr = { 3, 4, 5, 6, 7, 1, 2 };

        // System.out.println(findTarget2(arr, 6));
        int[]arr = { 1,1,1,2,2,3,3,3,3,1};
        int target =3;
        System.out.println(findTarget_Dup(arr, target));

    }
}
