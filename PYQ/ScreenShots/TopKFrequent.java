import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    // M-1 Brute force

    static void question(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Frequency count
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find top K frequencies (brute force)
        for (int i = 0; i < k; i++) {

            int maxFreq = 0;
            int maxElem = -1;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxElem = entry.getKey();
                }
            }

            if (maxElem != -1) {
                System.out.println(maxElem + " -> " + maxFreq);
                map.put(maxElem, 0); // mark as used
            }
        }
    }

    static void optimized(int[] arr, int k) {

        // Step 1: Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Buckets (index = frequency)
        List<Integer>[] bucket = new ArrayList[arr.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (bucket[f] == null)
                bucket[f] = new ArrayList<>();
            bucket[f].add(key);
        }

        // Step 3: Get top K
        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {

                for (int num : bucket[i]) {
                    System.out.println(num + " -> " + i);
                    k--;
                    if (k == 0)
                        break;
                }
  
                
                // M-II to print______

                // for (int j = 0; j < bucket[i].size(); j++) {
                // System.out.println(bucket[i].get(j) + " -> " + i);
                // k--;
                // if (k == 0)
                // break;
                // }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 4, 4, 5, 2, 4, 8, 8, 5, 5, 6, 8, 8, 8, 9, 9, 0

        };
        int k = 4;
        optimized(arr, 3);

    }
}
