package Sorting;

public class OneSwapSorting {
        /*
     * input arr = { 10,5,6,7,8,9,3}
     * only any 2 elem is swap in sorting array
     * or mission sort this two elem by sapping
     */

     static void sortArray(int[] arr) {

        int x = -1, y = -1;

        if (arr.length == 1)
            return; // corner case handle extra point

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                if (x == -1) { // 1st conflict
                    x = i - 1;
                    y = i;
                } else {
                    y = i; // 2nd conflict
                }
            }
        }

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
    public static void main(String[] args) {
        
        int[]arr ={ 10,5,6,7,8,9,3};
        sortArray(arr);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
