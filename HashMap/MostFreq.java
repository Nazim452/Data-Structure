package HashMap;

import java.util.*;

public class MostFreq {
    static void findMostFreq(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int el : arr) {
            if (!freq.containsKey(el)) {
                freq.put(el, 1);
            } else {
                freq.put(el, freq.get(el) + 1);
            }
        }
        System.out.println(freq.entrySet());
        int mxFreq = 0, ansKey = -1;

        for (var e : freq.entrySet()) {
            if (e.getValue() > mxFreq) {
                mxFreq = e.getValue();
                ansKey = e.getKey();

            }
        }

        // 2nd way of iterating

        // for (var key : freq.keySet()) {
        //     if (freq.get(key) > mxFreq) {
        //         mxFreq = freq.get(key);
        //         ansKey = key;
        //     }
        // }

        // System.out.println(ansKey);
        System.out.printf("%d has maximum freq & it occurs %d times ", ansKey, mxFreq);

    }

    public static void main(String[] args) {

        // FIND MOST FREQ ELEM

        int[] arr = { 1, 3, 4, 3, 3, 3, 5, 6, 6, 5, 7, 8, 8 };
        findMostFreq(arr);

    }
}
