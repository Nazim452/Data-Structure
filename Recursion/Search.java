package Recursion;

public class Search {

    static boolean searchArray(int[] arr, int n, int targert, int index) {

        // base casw
        if (index >= n)
            return false;

        // self work

        if (arr[index] == targert)
            return true;

        if (searchArray(arr, n, targert, index + 1) == true) { // OR retun searchArray(arr, n, targert, index+1)
            return true;
        } else {
            return false;
        }
    }

    // T C & SC - O(n)

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 45, 78, 56 };
        int n = arr.length;
        System.out.println(searchArray(arr, n, 56, 0));

    }
}
