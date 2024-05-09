package DP;

public class MatChainMul {
    // Memization_________________________________________________________________
    static int  mcmMemo(int[]arr, int  i, int j, int[][]dp){
        if(i==j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int ans = Integer.MAX_VALUE; // Initialize ans with a large value
        for(int k=i; k<=j-1; k++){
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(finalCost, ans);

        }
        return dp[i][j]=ans;
    }

    // Recursive_________________________________________________________________

    static int mcmRec(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmRec(arr, i, k);
            int cost2 = mcmRec(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(finalCost, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        // System.out.println(mcmRec(arr, 1, n - 1));
        int[][]dp = new int[n][n];


        System.out.println(mcmMemo(arr, 1, n-1, dp));

    }

}
