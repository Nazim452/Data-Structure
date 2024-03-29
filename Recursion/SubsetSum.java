package Recursion;

public class SubsetSum {

    // SUM OF SUBSET OF INTEGER ARRAY

    static void sumSubsset(int[] arr, int n, int index, int currSum) {
        if (index >= n) {
            System.out.println(currSum);
            return;
        }

        // ans + current elem

        sumSubsset(arr, n, index + 1, currSum + arr[index]);

        // ans ---- no add curr elem
        sumSubsset(arr, n, index + 1, currSum);
    }

    public static void main(String[] args) {
        int[] arr={2,4,5};
        sumSubsset(arr, arr.length, 0, 0);

    }
}
