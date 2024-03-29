package Sorting;

public class Sort012 {
    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    static void sort012___2(int[] arr) {
        // it occurs in only pass

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

    }
    // TC - O(n) SC - O(1)
    public static void main(String[] args) {
        int[] arr = { 0, 2, 2, 1, 1, 0, 2, 1, 0 };
        sort012___2(arr);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        
    }
}
