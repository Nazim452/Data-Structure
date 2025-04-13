package TCS.Array;

import java.util.Arrays;

public class EmployEfficiency {
     public static int maxEfficiency(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements");
        }

        // Sort the array
        Arrays.sort(arr);

        // Case 1: Product of the three largest numbers
        int max1 = arr[n - 1] * arr[n - 2] * arr[n - 3];

        // Case 2: Product of the two smallest numbers and the largest number
        int max2 = arr[0] * arr[1] * arr[n - 1];

        // Return the maximum of both cases
        return Math.max(max1, max2);
    }
    
    public static void main(String[] args) {

        // int[] arr = {3,-2,-8,4,1}; // Maxm Efficeincy of 3 People = (-2)X(-8)(4) = 64 (always +ve) 
        int[] arr = {-3,-2,-8,4,1}; // Maxm Efficeincy of 3 People = (-2)X(-8)(4) = 64 (always +ve) 
        System.out.println(maxEfficiency(arr));
    }
}
