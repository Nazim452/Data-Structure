package TCS.Miscellaneous;

import java.util.HashMap;

public class ShoesPair {

  
    static void findValidPairShoe1(String[] arr) {
        int n = arr.length;
        HashMap<String, Integer> map = new HashMap<>();
    
        // Count occurrences of each shoe size and type
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
    
        // Create a map to hold only the sizes (e.g., "7") with counts of L and R
        HashMap<String, Integer> leftMap = new HashMap<>();
        HashMap<String, Integer> rightMap = new HashMap<>();
    
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            
            // Split size and side (e.g., "7L" -> "7" and "L")
            String size = key.substring(0, key.length() - 1);
            char side = key.charAt(key.length() - 1);
    
            if (side == 'L') {
                leftMap.put(size, count);
            } else if (side == 'R') {
                rightMap.put(size, count);
            }
        }
    
        // Calculate the number of valid pairs
        int validPairs = 0;
        for (String size : leftMap.keySet()) {
            if (rightMap.containsKey(size)) {
                validPairs += Math.min(leftMap.get(size), rightMap.get(size));
            }
        }
    
        System.out.println("Valid Pairs: " + validPairs);
    }
    public static void main(String[] args) {
        String []arr  ={"7L","7R","7L","8L","6R","7R","8R","6R"}; // Valid Pair - 3 , So - O/P - 3

        findValidPairShoe1(arr);
    }
}
