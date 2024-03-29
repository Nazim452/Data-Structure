package Sorting;

public class SelectionSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i <= n - 2; i++) {

            int minINdex = i; // i - current element TC - n

            for (int j = i + 1; j < n; j++) { // pure aaray traverse for find min value

                if (arr[j] < arr[minINdex]) {// tc - n
                    minINdex = j;
                }

            }

            // swap current elemnt & minm index

            int temp = arr[i];
            arr[i] = arr[minINdex];
            arr[minINdex] = temp;
        }
    }

    public static void main(String[] args) {
        int[]arr = { 45, 3,24,89,5};
        selectionSort(arr);
        printArray(arr);

    }
}
