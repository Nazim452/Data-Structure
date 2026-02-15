import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwoMostFreq{

    static void question(int[]arr){
        int n= arr.length;
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }

        int firstFreq = 0, secondFreq = 0;
        int firstElem = -1, secondElem = -1;

        // Step 2: Find top two frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int freq = entry.getValue();
            int elem = entry.getKey();

            if (freq > firstFreq) {
                secondFreq = firstFreq;
                secondElem = firstElem;

                firstFreq = freq;
                firstElem = elem;

            } else if (freq > secondFreq ) {
                secondFreq = freq;
                secondElem = elem;
            }
        }

        System.out.println("1st most frequent: " +
                firstElem + " -> " + firstFreq);
        System.out.println("2nd most frequent: " +
                secondElem + " -> " + secondFreq);
    }
    public static void main(String[] args) {
        int[] arr = {5,5,8,5,5,3,2,2,3,2,3,2};
        question(arr);
        
    }
}