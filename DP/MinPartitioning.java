package DP;

public class MinPartitioning {
    static int minPar(int[]arr){
        int n = arr.length;
        int sum = 0;
        for(int  i=0; i<n; i++){
            sum += arr[i];
        }
        int wt =sum/2;

        int[][]dp = new int[n+1][wt+1];

        // KnapSack Code
        for(int  i =1; i<n+1; i++){
            for(int  j = 1; j<wt+1; j++){
                if(arr[i-1]<=j){
                    int  iclude = arr[i-1]+dp[i-1][j-arr[i-1]];
                    int  exclude = dp[i-1][j];
                    dp[i][j] = Math.max(iclude, exclude);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        int sum1 = dp[n][wt];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int[]arr ={1,6,11,5};
        System.out.println(minPar(arr) );
        
    }
}
