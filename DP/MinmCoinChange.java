package DP;


// Problem Statement - 

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0












public class MinmCoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Initicalization
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int j = 1; j <= amount; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;

        // If dp[i][j - coins[i - 1]] was set to Integer.MAX_VALUE (meaning "infinity"
        // or "not possible yet"),
        // then we would be doing:

        // 1 + Integer.MAX_VALUE

        // ➡️ This causes integer overflow, because:

        // 2147483647 + 1 = -2147483648

        // This wraps around into a negative number due to Java’s 32-bit integer
        // overflow behavior.

        // So if you “keep first column as only 0” but skip the first row initialization

        // Then:

        // Base case for sum 0 ✅ works fine

        // But base case for “no coins” ❌ breaks the logic

        // The algorithm thinks impossible sums are possible

        // Hence, you will fail many test cases (especially when amount > smallest coin)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= amount; j++) {
                // Valid
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];

            }

        }

        return dp[n][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }

}
