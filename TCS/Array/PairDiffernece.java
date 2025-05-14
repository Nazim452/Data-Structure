package TCS.Array;

import java.util.*;

public class PairDiffernece {
    public static List<int[]> findPairs(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num - target)) {
                result.add(new int[] { num, num - target });
            }
            if (seen.contains(num + target)) {
                result.add(new int[] { num + target, num });
            }
            seen.add(num);
        }

        return result;
    }


    static List<int[]> pair (int[]arr , int tar){
        HashSet<Integer> set = new HashSet<>();
        List<int[]> ans = new ArrayList<>();
        int n = arr.length;
        if(n==0) return ans;

        for(int i = 0; i<arr.length; i++){
            if(set.contains(arr[i]-tar)){
                ans.add(new int[] { arr[i] , arr[i]-tar});
            }
            if(set.contains(arr[i]+tar)){
                ans.add(new int[] { arr[i] , arr[i]+tar});
            }
            set.add(arr[i]);
        }

        return ans;

    }
       public static void main(String[] args) {
        int[] arr = { 4, 8, 6, 2 }; // [(6, 4), (8, 6), (4, 2)]
        int tar = 2;


        // int[] arr = {4, 4, 4, 4};
        // int tar = 0;

        // int[] arr = { 2, 2, 4, 4 };
        // int tar = 2;


        
        
        List<int[]> pairs = findPairs(arr, tar);
 
        // Print the output
        System.out.print("Output: [");
        for (int i = 0; i < pairs.size(); i++) {
            int[] pair = pairs.get(i);
            System.out.print("(" + pair[0] + ", " + pair[1] + ")");
            if (i < pairs.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}