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


    public static void main(String[] args) {
        int[]arr = { 45, 3,24,89,5};
        insertionSort(arr);
        printArray(arr);
        

    }

}
