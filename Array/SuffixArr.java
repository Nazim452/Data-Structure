package Array;

public class SuffixArr {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void suffix(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] + arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4, 5 };
        suffix(arr);
        printArray(arr);
    }

}
