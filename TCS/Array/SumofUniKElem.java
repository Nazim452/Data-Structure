package TCS.Array;

import java.util.HashMap;
import java.util.HashSet;

public class SumofUniKElem {
    static void findSum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for ( int n : set)
            sum += n;

        System.out.println("Total Sum " + sum);
    }

    // This is wrong mwthod..... if question ask calculate the sum of  value those comes  only one times

    public static int sumOfUniqueElements(int[] array) {
        // Step 1: Use a HashMap to count occurrences
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Calculate the sum of unique elements
        int sum = 0;
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == 1) { // Unique element
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        
        int[] arr = { 1, 3, 2, 3, 2, 4 };   //  Output - 10 (1+3+2+4) - removed duplicate number.
        System.out.println(sumOfUniqueElements(arr));

    }
}
 