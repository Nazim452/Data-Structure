package DP;

public class Fibonaaci {
    static int fib(int n, int[]f){
        if(n==0||n==1) return n;

        if(f[n]!=0) return f[n];
        f[n]=fib(n-1, f)+fib(n-2, f);
        return f[n];

    } 
    
    
    // Fibonaaci - Tabulation.....

    static  int fibTabulation(int n){
        int[]dp = new int[n+1];

        // 1. initialize
        dp[0]=0;
        dp[1]=1;

        // 2. Filling bottom up
        for(int i = 2; i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n = 6;
        // int[]f = new int[n+1];
        // System.out.println(fib(n, f));  

        // Print all the number
        // for (int i = 0; i <= n; i++) {
        //     System.out.print(fib(i, f) + " ");
        // }
        
        

        System.out.println(fibTabulation(n));
    }
}
