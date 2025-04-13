package TCS.Array;

public class ColorSort {
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

    static void sortColor(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j + 1, j);

            }
        }

        printArray(arr);
    }

    static void sortColor2(int[] arr) {
        int n = arr.length;
        int count3 = 0, count6 = 0, count7 = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 3)
                count3++;
            else if (arr[i] == 6)
                count6++;
            else
                count7++;

        }
        int[] ans = new int[n];
        int k = 0;

        while (k < n) {

            if (count3-- > 0)
                ans[k++] = 3;
            else if (count6-- > 0)
                ans[k++] = 6;
            else
                ans[k++] = 7;
        }
        printArray(ans);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 3, 7, 6, 3, 7 }; // O/P - {3,3,3,6,6,7,7}
        sortColor2(arr);

    }
}
