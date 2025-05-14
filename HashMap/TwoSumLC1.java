package HashMap;

import java.util.HashMap;

public class TwoSumLC1 {


    public static int[] twoSum(int[] arr, int tar) {
        int[] ans = { -1 };
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int partner = tar - arr[i];

            if (mp.containsKey(partner)) {
                ans = new int[] { mp.get(partner),i  };
            } else {
                mp.put(arr[i],i);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[]arr = {2,5,6,2,4};  // {2,4} - index number.
        int tar = 10;
        int[]ans = twoSum(arr, tar);
        for(Integer i:ans) System.out.print(i+" ");

    }
}
