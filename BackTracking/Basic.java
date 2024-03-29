package BackTracking;

public class Basic {
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void changeArr(int[] arr, int i, int val) {
        int n = arr.length;

        if (i == n) {
            printArr(arr);
            return;
        }
        // self work
        arr[i] = val;
        // Recursive work
        changeArr(arr, i + 1, val+1);
        // backTrack
        arr[i] = arr[i] - 2;
    }

    public static void main(String[] args) {
        int[]arr = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        
    }

}
