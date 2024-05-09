package DP;

// import java.util.Arrays;

public class Catalan {

     // Tabulation________________________________________________________________

     static int cataTabul(int n){
        int[]dp = new int[n+1];
        dp[0] =dp[1]=1;

        for(int i =2; i<=n;  i++){
            for(int j = 0; j<i; j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
     }

    static int memoTab(int n){
        int[]dp = new int[n+1];

        for(int i = 2; i<n+1; i++){
            for(int j = 0; j<i; j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }

        return dp[n];

    }


    // Memoization_____________________________________________________________

    static int cataMemo(int n, int[]dp){
        if(n==0|| n==1) return 1;

        if(dp[n]!=0) return dp[n];
        int ans = 0;
        for(int  i = 0; i<n; i++){
           ans+= cataMemo(i, dp)*cataMemo(n-i-1, dp);
        }

        return dp[n]=ans;
    }

    // Recursive________________________________________________________________
    static int catalanNum(int n){
     if(n==0 ||n==1) return 1;

     int ans = 0;

     for(int i = 0; i<n; i++){
         ans+=catalanNum(i)*catalanNum(n-i-1);
     }

     return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Recursion Answer "+catalanNum(n));

        int[]dp = new int[n+1];
        
        System.out.println("Memoization Answer "+cataMemo(n, dp));

        System.out.println(cataTabul(n));
        
        
    }
}
