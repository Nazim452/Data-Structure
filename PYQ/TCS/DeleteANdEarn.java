package PYQ.TCS;

import java.util.*;
// Problem Statement (Clearly Explained)

// You are given an array of integers.

// You can pick any number x.
// When you pick x:

// You earn x points.

// All elements equal to x - 1

// All elements equal to x + 1

// are deleted automatically.

// You can keep picking numbers until array becomes empty.

// 👉 Find maximum points you can earn.

// 🔥 Key Insight

// If you pick 3, you cannot pick 2 and 4.

// This is EXACTLY like House Robber.

// Instead of houses in line, numbers behave like houses based on value.

// 🧠 Example 1
// nums = [3, 4, 2]

// If pick 3:

// earn 3

// delete 2 and 4
// → total = 3

// If pick 4:

// earn 4

// delete 3
// → total = 4

// If pick 2:

// earn 2

// delete 3
// → total = 2

// Best = 6

// Wait… how?

// Because real rule is:
// You earn ALL occurrences of that number.

// So:

// Sum per value:
// 2 → 2
// 3 → 3
// 4 → 4

// But if array was:

// [2,2,3,3,3,4]

// Then:

// 2 → 4
// 3 → 9
// 4 → 4

// Now if pick 3:
// Earn 9
// Cannot pick 2 or 4
// Total = 9

// If pick 2 and 4:
// Earn 4 + 4 = 8

// So answer = 9
// Now Let’s Follow Your Thinking

// You said:

// If I pick 2, then 2+2 = 4
// And since 4 (x+2) is still there, I can add 4 also
// So total becomes 8 immediately.

// This part is correct — but not “immediately.”

// Let’s simulate properly.

// ✅ Case 1: Pick 2 First
// Step 1: Pick 2

// 2 appears twice.

// You earn:

// 2 + 2 = 4

// Now delete:

// all 1’s (none)

// all 3’s (three 3’s)

// Array becomes:

// {4}

// Current total = 4

// Step 2: Pick 4

// Now 4 appears once.

// You earn:

// 4

// Now delete:

// all 3’s (none left)

// all 5’s (none exist)

// Array becomes empty.

// Final total:
// 4 (from 2’s)
// + 4 (from 4)
// = 8

// ✔ Yes, total is 8.

// 🔵 Now Your Second Confusion

// You said:

// If I pick 4 first, then 2 is x-2, so I should be able to pick 2 also, so again total 8.

// Let’s simulate that.

// ✅ Case 2: Pick 4 First
// Step 1: Pick 4

// 4 appears once.

// You earn:

// 4

// Now delete:

// all 3’s (three 3’s)

// all 5’s (none)

// Array becomes:

// {2, 2}

// Current total = 4

// Step 2: Pick 2

// 2 appears twice.

// You earn:

// 2 + 2 = 4

// Now delete:

// all 1’s (none)

// all 3’s (none left)

// Array becomes empty.

// Final total:
// 4 + 4 = 8

// ✔ Yes, also 8.

// 🔥 So Why Not 9?

// Because if we instead choose 3 first:

// ✅ Case 3: Pick 3 First

// 3 appears 3 times.

// You earn:

// 3 + 3 + 3 = 9

// Now delete:

// all 2’s

// all 4’s

// Array becomes empty.

// Final total = 9

// 🎯 So The Possibilities Are
// First Choice	Final Total
// Pick 2	8
// Pick 4	8
// Pick 3	9

// Best = 9
// What You Were Thinking (Important)

// You were thinking:

// When picking 2, can I add 4 also?

// Yes, but only after finishing first operation and updating array.

// You cannot add everything at same time.

// Operations are sequential.

// 🔵 Key Clarification

// Delete and Earn is NOT:

// Choose multiple numbers at same time.

// It is:

// Pick one number
// Update array
// Then pick again

// Like rounds.

import java.util.*;

public class DeleteANdEarn {

    // 🔹 Your House Robber code (UNCHANGED)
    static int rob(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }

        return dp[n-1];
    }

    // 🔹 Delete and Earn method
    static int deleteAndEarn(int[] nums) {

        // Step 1: Find maximum value
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        // Step 2: Build sum array
        int[] sum = new int[max + 1];
        for(int num : nums) {
            sum[num] += num;
        }

        // Step 3: Apply House Robber on sum array
        return rob(sum);
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 3, 3, 4};

        // // Step 1: Find maximum value in array
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > max) {
        //         max = nums[i];
        //     }
        // }

        // // Step 2: Build sum array
        // // sum[i] = total value we get if we choose number i
        // int[] sum = new int[max + 1];

        // for (int i = 0; i < nums.length; i++) {
        //     int value = nums[i];
        //     sum[value] += value;
        // }

        // // Example for nums = {2,2,3,3,3,4}
        // // sum[2] = 4
        // // sum[3] = 9
        // // sum[4] = 4

        // // Step 3: Create DP array
        // int[] dp = new int[max + 1];

        // // Base cases
        // dp[0] = 0;
        // dp[1] = sum[1];  // may be 0 if no 1 in array

        // // Step 4: Fill DP
        // for (int i = 2; i <= max; i++) {
        //     dp[i] = Math.max(
        //             dp[i - 1],          // skip current number
        //             dp[i - 2] + sum[i]  // take current number
        //     );
        // }

        // System.out.println("Max Earn = " + dp[max]);

        System.out.println(deleteAndEarn(nums));
    }
}
