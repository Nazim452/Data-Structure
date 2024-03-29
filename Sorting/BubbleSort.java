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

    public static void main(String[] args) {
         int[]arr = { 45, 3,24,89,5};
         bubblleSort(arr);
         printArray(arr);

        

    }

}
