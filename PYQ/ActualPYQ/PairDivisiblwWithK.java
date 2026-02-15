package PYQ.ActualPYQ;

import java.util.HashMap;
import java.util.Map;

// We need to determine if we can split an even-length array into pairs where the sum of 
// each pair is divisible by a given integer k.

public class PairDivisiblwWithK {

    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();

        // Calculate remainder frequencies
        for (int num : arr) {
            int remainder = (num % k + k) % k; // Handle negative numbers

            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }

        if (remainderFreq.containsKey(0) && remainderFreq.get(0) % 2 != 0) {
            return false;
        }
        // Check other remainders
        for (var entry : remainderFreq.entrySet()) {
            int r = entry.getKey(); // current key (remainder)
            int freq = entry.getValue(); // current frequency

            if (r == 0)
                continue; // Already checked zero case separately

            int complement = k - r;

            if (r == complement) {
                // When remainder is exactly half of k (e.g., k = 10, r = 5)
                if (freq % 2 != 0) { // frequency must be even to form valid pairs
                    return false;
                }
            } else {
                // Check if complement remainder exists and frequency matches
                if (!remainderFreq.containsKey(complement) || remainderFreq.get(complement) != freq) {
                    return false;
                }
            }
        }

        return true;
    }


//  Not handle negative number........
    static boolean question(int[] arr , int k){


        HashMap<Integer , Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int remainder = arr[i]%k;
            map.put(remainder, map.getOrDefault(remainder, 0)+1);

        }

        if(map.containsKey(0) && map.get(0) %2!=0) return false;

        for(var data : map.entrySet()){
            int r  = data.getKey();
            int freq = data.getValue();

            if(r==0) continue;

            int complement = k-r;

            if(r==complement){
                 if(freq%2!=0) return false;
            }
            else{

                if(!map.containsKey(complement) || map.get(complement)!=freq) return false;

            }

        }
        return true;


    }
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k1 = 5;
        System.out.println(question(arr1, k1)); // Output: true
        // // (1,9) (2,8) (3,7)(4,6) - pair are divisible with k1 (5)

    

        // Mathematical Insight
        // For any two numbers a and b:

        // If (a + b) % k == 0, then a % k + b % k must equal k or 0.

        // Example: k = 5, a = 3, b = 7 → (3 + 7) % 5 = 0 because 3 % 5 = 3 and 7 % 5 =2
        //  → 3 + 2 = 5.

        // This means a % k and b % k are complements (they add up to k).

        // 2. Why Store Remainders?
        // By calculating num % k for each number, we reduce the problem to pairing
        // remainders:

        // Remainder 0: Numbers divisible by k (e.g., 5 and 10 for k=5).

        // These must be paired among themselves (frequency must be even).

        // Other Remainders:

        // A remainder r must pair with k - r (its complement).

        // Example: For k=5, r=1 pairs with r=4, for r=2 pairs with r=3.

        // 3. Handling Edge Cases
        // Negative Numbers:

        // Use (num % k + k) % k to ensure remainders are positive.

        // Example: num = -3, k = 5 → (-3 % 5 + 5) % 5 = 2.

        // Self-Complementary Remainders:

        // If k is even, r = k/2 is its own complement (e.g., k=10, r=5).

        // Such remainders must have an even frequency to pair among themselves.

        // Odd k:

        // No self-complementary remainders exist.

        // 4. Algorithm Steps
        // Calculate Remainders:

        // For each number in arr, compute (num % k + k) % k and store frequencies.

        // Check Pairing Rules:

        // Remainder 0: Frequency must be even.

        // Other Remainders (r):

        // If r != k - r, ensure freq[r] == freq[k - r].

        // If r == k - r, ensure freq[r] is even.

        // Early Termination:

        // If any check fails, return false.

        // 5. Example Walkthrough
        // Input: arr = [1, 2, 3, 4, 5, 10, 6, 7, 8, 9], k = 5
        // Step 1: Remainder Frequencies

        // {
        // 0: 2 (from 5, 10),
        // 1: 2 (from 1, 6),
        // 2: 2 (from 2, 7),
        // 3: 2 (from 3, 8),
        // 4: 2 (from 4, 9)
        // }
        // Step 2: Pairing Validation

        // 0: Frequency 2 (even) → Valid.

        // 1 and 4: freq[1] == freq[4] → Valid.

        // 2 and 3: freq[2] == freq[3] → Valid.
        // Result: true.

        // Special Cases: Handle 0 and self-complementary remainders separately.

        // __________________________________Other Edge
        // cases_______________________________

        // int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        // int k2 = 7;
        // System.out.println(canArrange(arr2, k2)); // Output: true

        // int[] arr3 = {1, 2, 3, 4, 5, 6};
        // int k3 = 10;
        // System.out.println(canArrange(arr3, k3)); // Output: false

        // int[] arr4 = {0, 0, 0, 0};
        // int k4 = 3;
        // System.out.println(question(arr4, k4)); // true

        // // Edge Case 2: negative numbers
        // int[] arr5 = {-10, 10, -20, 20, -30, 30};
        // int k5 = 10;
        // System.out.println(canArrange(arr5, k5)); // true

        // // Edge Case 3: odd length
        // int[] arr6 = {1, 2, 3};
        // int k6 = 3;
        // System.out.println(question(arr6, k6)); // false (odd length input invalid)
        

        // // Edge Case 4: remainder = k/2
        // int[] arr7 = {2, 2, 4, 4};
        // int k7 = 6;
        // System.out.println(canArrange(arr7, k7)); // true

    }

}
