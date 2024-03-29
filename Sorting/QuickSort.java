package Sorting;

public class QuickSort {
    static int partition(int[] arr, int st, int end) {

        int pivot = arr[st];

        int count = 0;
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] <= pivot)
                count++;

        }
        int pivotIndex = st + count;
        swap(arr, st, pivotIndex);

        int i = st, j = end;

        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivot)
                i++; // = means duplicate elem ko pahle rakh rahe ha
            while (arr[j] > pivot)
                j--;

            // leeser - left, greater - right

            if (i < pivotIndex && j > pivotIndex) {
                swap(arr, i, j);
                i++;
                j--;

            }

        }
        return pivotIndex;
    }

    static void quickSort(int[] arr, int st, int end) {
        if (st >= end)
            return;

        int pi = partition(arr, st, end);

        quickSort(arr, st, pi - 1);
        quickSort(arr, pi + 1, end);

    }

    // stable - not
    // Sc- for avg/best - log n -- due to implicit case
    // Sc - for worst case - n
    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 1, 1, 5, 5, 4 };

        quickSort(arr, 0, arr.length - 1);

        for (int elem : arr) {
            System.out.print(elem+" ");
        }

    }

}
