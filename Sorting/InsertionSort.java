package Sorting;

public class InsertionSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void insertionSort2(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j = i;

            while (j > 0 && arr[j] > arr[j - 1]) {

                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }

        }
    }

        static void  insertionSort(int []arr){

        int n = arr.length;

        for(int i =1; i<n; i++){

            int j = i;

            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }



    static void insertionSort3(int []arr){
        for(int i = 1; i<arr.length; i++){

          int j = i;

          while (j>0 && arr[j]<arr[j-1]) {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            
            j--;
          }
        }
    }

    static void insertionSortRecursive(int[] arr, int n) {
        // Base case: If the array size is 1, it's already sorted
        if (n <= 1) {
            return;
        }

        // Sort the first n-1 elements
        insertionSortRecursive(arr, n - 1);

        // Insert the nth element into its correct position in the sorted array
        int last = arr[n - 1];
        int j = n - 2;

        // Move elements of arr[0..n-1], that are greater than last, to one position ahead of their current position
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
    public static void main(String[] args) {
        // int[]arr = { 45, 3,24,89,5};
        // insertionSort3(arr);
        // printArray(arr);





        int[] arr = {5, 1, 4, 2, 8};
        insertionSortRecursive(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        

    }

}
