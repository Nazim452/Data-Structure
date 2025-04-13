package DP;

public class ZeroOneKnCorrectver {
    static int ZeroOneKnapSackNazim(int[]wt , int[] val,int cap,int n,int[][]dp){
        if(n==0|| cap==0) return 0;
        int ans = Integer.MIN_VALUE;

        if(dp[n][cap]!=0) return dp[n][cap];

        if(wt[n-1]<=cap){
            // Include

            int ans1 = val[n-1]+ZeroOneKnapSackNazim(wt,val,cap-wt[n-1],n-1,dp);
            // Excclude
            int ans2 = ZeroOneKnapSackNazim(wt, val, cap, n-1,dp);
            ans = Math.max(ans1, ans2);
            

        }
        else  ans=ZeroOneKnapSackNazim(wt, val, cap, n-1,dp);
        dp[n][cap] = ans;
        return ans;
    }
    public static void main(String[] args) {
        int[]wt = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int cap = 7;
        int[][]dp = new int[val.length+1][cap+1];

        System.out.println(ZeroOneKnapSackNazim(wt,val,cap,wt.length,dp));
        
    }
}
