package Sorting;

public class CountSort {
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort(int[] arr) {
        int maximum = findMax(arr);

        int[] count = new int[maximum + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;

            }
        }
    }

    public static void main(String[] args) {
        int []arr = {3,2,8,5,4};
        countSort(arr);
        for(int elem:arr){
            System.out.print(elem+ " ");
        }

    }
}
