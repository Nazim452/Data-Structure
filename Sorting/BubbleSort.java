package Sorting;

public class BubbleSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void bubblleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            boolean flag = false; // i ke iteration ko check karne ke liye ki i ka iteration ho ya n

            // har ek i ke baad ham janna chahte hai ki iteration hua hai ya nahi

            for (int j = 0; j < arr.length - i - 1; j++) { // for swapping -
                // j - loop - last i element is already sorted , no need to check

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }

            }

            if (flag == false) {
                return;
            }
        }
    }

    static void bubbleSortRecursive(int[] arr, int n) {
        // Base case: If the array size is 1, it's already sorted
        if (n == 1) {
            return;
        }

        // One pass of bubble sort. After this pass, the largest element is moved to the end.
        boolean flag = false;
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = true;
            }
        }

        // If no two elements were swapped by inner loop, then array is already sorted
        if (!flag) {
            return;
        }

        // Largest element is fixed, recur for remaining array
        bubbleSortRecursive(arr, n - 1);
    }


    public static void main(String[] args) {
         int[]arr = { 45, 3,24,89,5};
         bubbleSortRecursive(arr,arr.length);   
         printArray(arr);

        

    }

}
