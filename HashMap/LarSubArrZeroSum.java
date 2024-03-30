package HashMap;

import java.util.HashMap;

public class LarSubArrZeroSum {

    public static int largestSubArray(int[] arr) {
        int prefSum = 0, maxLen = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];

            if (mp.containsKey(prefSum)) {
              maxLen=  Math.max(maxLen, i - mp.get(prefSum));
            } else {
                mp.put(prefSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        // int[]arr = {15,-2,2,-8,1,7,10,23};    //5     -2,2,-8,1,7
        int[]arr= {15,-2,1,0,1,10};    //4     -2,1,0,1
       System.out.println( largestSubArray(arr ));

    }
}
