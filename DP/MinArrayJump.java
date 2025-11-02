package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class MinArrayJump {








     public int MinimumArrayJumpReal(ArrayList<Integer> A) {
        int n = A.size();
        if (n <= 1) return 0;

        // Convert to primitive int[] to avoid boxing/unboxing overhead
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = A.get(i);

        // If the first element is 0 and n > 1, cannot move
        if (arr[0] == 0) return -1;

        int maxReach = arr[0];  // farthest index we can reach so far
        int steps = arr[0];     // steps we can still take in current jump
        int jumps = 1;          // at least one jump needed if n > 1

        for (int i = 1; i < n; i++) {
            // If we reached the last index, return jumps
            if (i == n - 1) return jumps;

            // update maxReach
            int candidate = i + arr[i];
            if (candidate > maxReach) maxReach = candidate;

            // use a step to move to i
            steps--;

            // if no more steps available we must make another jump
            if (steps == 0) {
                jumps++;

                // if current index is already beyond maxReach, we cannot progress
                if (i >= maxReach) return -1;

                 // reinitialize steps to the amount of steps to reach maxReach from i
                steps = maxReach - i;
            }
        }

        // If loop finishes without reaching last index
        return -1;
    }
     static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int minJumps(int[]arr){
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1]=0;

        for(int i = n-2; i>=0; i--){
            int steps = arr[i];
           int ans=Integer.MAX_VALUE;
            for(int  j = i+1; j<=i+steps &&j<n; j++){
                if(dp[j]!=-1) ans=Math.min(ans, dp[j]+1);
            }

            if(ans!=Integer.MAX_VALUE) dp[i]=ans;


        }

        printArray(dp);

        System.out.println();
       

        return dp[0];
    }
    public static void main(String[] args) {
        int[]arr ={2,3,1,1,4};
        System.out.println(minJumps(arr));
        System.out.println();

        
    }
}
