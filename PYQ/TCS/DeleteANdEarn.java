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

public class DeleteANdEarn {

    public static void main(String[] args) {

        int[] nums = { 2, 2, 3, 3, 3, 4 };

        int max = 0;
        for (int n : nums)
            max = Math.max(max, n);

        int[] sum = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            sum[value] += value;
        }

        int prev = 0, curr = 0;

        for (int i = 0; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + sum[i]);
            prev = temp;
        }

        System.out.println("Max Earn = " + curr);
    }
}