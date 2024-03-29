package Sorting;

public class MergeSort {
    static void merge(int[] arr, int l, int mid, int r) {

        int n1 = mid - l + 1; // size of left array , divided by recursion

        int n2 = r - mid; // size of right array , divided by recursion

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i, j, k;

        // smajha n aaya sala

        for (i = 0; i < n1; i++)
            left[i] = arr[l + i]; // for fill the elem in right arr

        for (j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        i = 0; // left ke 0th index ko point kar raha
        j = 0; // right ke 0th index ko point kar raha
        k = l; // k array ke 0th index ko indicate karega

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }

        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];

        }

    }

    static void mergeSort(int[] arr, int l, int r) {

        if (l >= r)
            return; // if single value of array the n return

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);

        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r); // dono sotred sub array ko merge karne ka kam

        // tc - O(nlogn)
        // SC -O(n)
        // stable - yes

    }

    public static void main(String[] args) {
        int []arr= { 3,9,8,2,6,4,7};
        mergeSort(arr, 0, arr.length-1);

        for(int elem:arr){
            System.out.print(elem+ " ");
        }


    }

}
