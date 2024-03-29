package Recursion;

public class PrintTarget {

    // PRINT ALL INDEXES OF TARGET

    static void findIndex(int[] arr, int n, int targert, int index) {

        if (index >= n) {
            return;
        }

        if (arr[index] == targert) {
            System.out.println(index);
        }

        findIndex(arr, n, targert, index + 1);
    }

    public static void main(String[] args) {
        // int[]arr ={1,2,34};
 

    }
}
