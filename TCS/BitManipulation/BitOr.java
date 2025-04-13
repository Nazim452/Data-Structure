package TCS.BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class BitOr {
    
     public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> uniqueOrs = new HashSet<>();
        
        // Iterate through all starting points
        for (int i = 0; i < arr.length; i++) {
            int currentOr = 0;
            // Calculate OR for subarrays starting at i
            for (int j = i; j < arr.length; j++) {
                currentOr |= arr[j];
                uniqueOrs.add(currentOr);
            }
        }
        
        return uniqueOrs.size();
    }


    // OPtimized -

    public static int OptimizedsubarrayBitwiseORs(int[] arr) {
        Set<Integer> overallSet = new HashSet<>();
        Set<Integer> prevSet = new HashSet<>();

        for (int num : arr) {
            Set<Integer> currSet = new HashSet<>();
            currSet.add(num);
            for (int prev : prevSet) {
                currSet.add(prev | num);
            }
            prevSet = currSet;
            overallSet.addAll(prevSet); 
        }

        return overallSet.size();
    }
    public static void main(String[] args) {
        // int[] arr1 = {0};
        // System.out.println(subarrayBitwiseORs(arr1)); // Output: 1

        // int[] arr2 = {1, 1, 2};
        // System.out.println(subarrayBitwiseORs(arr2)); // Output: 3

        // int[] arr3 = {1, 2, 4};
        // System.out.println(subarrayBitwiseORs(arr3)); // Output: 6

        int[] arr1 = {0};
        System.out.println(OptimizedsubarrayBitwiseORs(arr1)); // Output: 1

        int[] arr2 = {1, 1, 2};
        System.out.println(OptimizedsubarrayBitwiseORs(arr2)); // Output: 3

        int[] arr3 = {1, 2, 4};
        System.out.println(OptimizedsubarrayBitwiseORs(arr3)); // Output: 6
    }
}
