package PYQ.ActualPYQ;

import java.util.HashMap;

// Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] 

// is a subset of a1[] or not. Both the arrays can be sorted or unsorted.  
// Example 1: 
// Input: 
// a1[] = {11, 1, 13, 21, 3, 7} 
// a2[] = {11, 3, 7, 1} 
// Output: 
// Yes 
// Explanation: 
// a2[] is a subset of a1[] 

// Example 2: 
// Input: 
// a1[] = {1, 2, 3, 4, 5, 6} 
// a2[] = {1, 2, 4} 
// Output: 
// Yes 
// Explanation: 
// a2[] is a subset of a1[] 

// Example 3: 
// Input: 
// a1[] = {10, 5, 2, 23, 19} 
// a2[] = {19, 5, 3} 
// Output: 
// No 
// Explanation: 
// a2[] is not a subset of a1[]

public class SubsetOfAnotherArray {

    //  Not working with all the test case - 

    static boolean question(int[] arr1, int[] arr2) {

        // Not Working for all test c ases -

        // For Input :
        // 1 2 2
        // 1 1
        // Your Code's output is:
        // true
        // It's Correct output is:
        // false


        int n1 = arr1.length;
        int n2 = arr2.length;

        for (int i = 0; i < n2; i++) {
            int curr = arr2[i];
            boolean currentFound = false;

            for (int j = 0; j < n1; j++) {
                if (curr == arr1[j]) {
                    currentFound = true;
                    break; // Element found, no need to check further
                }
            }

            // If current element of arr2 not found in arr1, it's not a subset
            if (!currentFound) {
                return false;
            }
        }

        // All elements of arr2 found in arr1
        return true;
    }


    // Working with all the test cases - 

    static boolean isSubset(int[] arr1, int[] arr2) {
        int[] used = new int[arr1.length]; // Track used elements

        for (int i = 0; i < arr2.length; i++) {
            boolean found = false;

            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j] && used[j] == 0) {
                    used[j] = 1; // Mark this element as used
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false; // arr2[i] not found in arr1 or already used
            }
        }

        return true; // All elements of arr2 found in arr1 with correct frequency
    }



    // Optimized - 

     static boolean isSubsetOptimized(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Store frequencies of arr1 elements
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if arr2 elements exist in required frequency
        for (int num : arr2) {
            if (!freqMap.containsKey(num) || freqMap.get(num) == 0) {
                return false; // Either not found or used up
            }
            freqMap.put(num, freqMap.get(num) - 1); // Decrease count
        }

        return true;
    }

    public static void main(String[] args) {
        int a1[] = { 10, 5, 2, 23, 19 };
        int a2[] = { 19, 5, 2 };

        System.out.println(isSubsetOptimized(a1, a2) ? "Yes" : "No");
    }
}
