package TCS.Array;

import java.util.HashMap;

public class MajorityElem {
    static int[] makeFrequency(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        return freq;

    }

    static void findMajor(int[] arr) {
        int[] freq = makeFrequency(arr);

        int n = freq.length;
        int max = arr.length / 2;

        for (int i = 0; i < n; i++) {
            if (freq[i] >= max)
                System.out.print(i + " ");
        }

    }

    public int majorityElement(int[] arr) {

        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 2, 4, 2, 4 };
        findMajor(arr);

    }
}
