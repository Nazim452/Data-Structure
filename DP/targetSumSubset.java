package DP;

public class targetSumSubset {

    static void print(boolean dp[][]){
        for(int  i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }



    static boolean sumSubset(int arr[], int sum){
        int  n = arr.length;
        boolean[][] dp= new boolean[n+1][sum+1];
        // i - item , j = target sum
        for(int  i = 0; i<n+1; i++) dp[i][0] = true;

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
                int  v = arr[i-1];
                // include
                //  - v<=j --- checking validt or not
                if(v<=j && dp[i-1][j-v]) dp[i][j] = true;

                // Invalid - exclude
                else if(dp[i-1][j]==true) dp[i][j] = true;
            }
        }

        print(dp);

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int []arr = {4,2,7,1,3};
        int targetSum=10;

        System.out.println(sumSubset(arr, targetSum));
        
    }
}
