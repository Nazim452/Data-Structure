package DP;

public class ClimingStair {
    static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return countWays(n - 1) + countWays(n - 2);
    }

    // Tabulation Method _______________________________________

    static int climTabukation(int n) {
        int[] dp = new int[n + 1];
        // Initialization
        dp[0] = 1;
        // Fill Up

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // MemoIzation Method__________________________________________

    static int countWaysMemoization(int n, int[] ways) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (ways[n] != 0)
            return ways[n];

        ways[n] = countWaysMemoization(n - 1, ways) + countWaysMemoization(n - 2, ways);

        return ways[n];
    }

    public static void main(String[] args) {
        // System.out.println(countWays(5 ));;

        // Tabulation----

        // System.out.println( climTabukation(5));

        // Memoization----
        int  n = 4;
        int[]ways = new int[n+1];

       System.out.println( countWaysMemoization(n, ways));;


    }
}
