package PYQ.TCS;

public class NextPermutation {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void question(int[] arr) {
        int n = arr.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] > arr[i]) {
                index = i;
                break;
            }

        }

        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[index] < arr[i]) {
                swap(arr, index, i);
                break;
            }
        }

        reverse(arr, index + 1, n - 1);
        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 2,1,5,4,3,0,0, };
        question(arr);

    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 7d1ba78 (ALL file done)
