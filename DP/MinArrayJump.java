package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class MinArrayJump {

    // MinimumJump Without DP

    static int minjumpWithoutDP(int[] arr) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            // Expand the farthest reach
            farthest = Math.max(farthest, i + arr[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }

        }

        return jumps;
        // Time to use one jump

        // You have scanned ALL positions that can be reached with the current jump.
        // ➡️ You know the maximum reach for the next jump (farthest).
        // ➡️ So now you MUST take a jump to extend your window.

        // 🧠 Very Simple Interpretation

        // Imagine you're walking, and your current step allows you to walk till some
        // checkpoint (currentEnd).
        // While walking to that checkpoint, you're also scanning how far the next big
        // step can take you (farthest).

        // When you finally reach that checkpoint:

        // ➡️ You must take the next step
        // ➡️ Because you cannot go further without increasing your jump count
        // ➡️ That’s the exact time i == currentEnd

    }


    // Minimum Jump with DP
 
    static int minJumpsWithDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1)
                    ans = Math.min(ans, dp[j] + 1);
            }

            if (ans != Integer.MAX_VALUE)
                dp[i] = ans;

        }

        printArray(dp);

        System.out.println();

        return dp[0];
    }


       static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        System.out.println(minJumpsWithDP(arr));
        System.out.println();

    }
}
