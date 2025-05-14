package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FIndUnique {
    // O(n^2)
    
    static int unique(int [] arr){
        Arrays.sort(arr);
       
        for(int i = 0; i<arr.length; i++){
            for(int j= i+1; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    arr[i] = -2;    // kuch bhi - me man  sakte hai
                    arr[j] = -2;
                }
            }
        }
        int ans = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]!= -2)
            ans = arr[i];

        }
        return ans;
    }


    // O(nlogn)
    static int uniqueUsingSorting(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[arr.length - 1]; // Last element is unique
    }

// O(n)
static int uniqueUsingFrequencyMap(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : arr) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        if (entry.getValue() == 1) {
            return entry.getKey();
        }
    }
    return -1; // No unique element found
}

    public static void main(String[] args) {
        int[] arr = { 1,1,5,5,6,11,6};
        System.out.println(uniqueUsingSorting(arr)); //1
        
    }
    
}
