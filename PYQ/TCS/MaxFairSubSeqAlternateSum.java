package PYQ.TCS;

import javax.swing.GroupLayout.Group;

// You are given an integer array A of size N.

// Your friend defines something called a “Fair Subsequence.”

// A subsequence is called fair if:

// The elements alternate in sign.

// That means:

// positive → negative → positive → negative → ...

// OR

// negative → positive → negative → positive → ...

// ⚠ Important:

// It is a subsequence, not necessarily contiguous.

// Order must remain the same as original array.

// You must select elements in alternating sign pattern.

// 🎯 Your Task

// Among all possible fair subsequences:

// First, find the maximum possible length.

// Among all subsequences having that maximum length,

// Return the maximum possible sum.

// 🔎 Important Understanding

// This is NOT asking:

// longest alternating subarray ❌

// maximum sum subarray ❌

// It is asking:

// longest alternating subsequence

// and if multiple such longest subsequences exist → choose one with maximum sum

// 🧠 Let’s Understand With Examples
// ✅ Example 1
// Input
// N = 5
// A = [21, 12, 13, -21, -2]
// Step 1: Group by sign

// Positive numbers:

// 21, 12, 13

// Negative numbers:

// -21, -2
// Step 2: Maximum alternating possible

// We can do:

// 21 → -21

// Length = 2

// Or:

// 13 → -2

// Maximum length possible = 2
// (Because there are only 2 negatives)

// Step 3: Choose maximum sum pair

// Possible pairs:

// 21 + (-21) = 0

// 21 + (-2) = 19

// 13 + (-2) = 11

// Maximum = 19

// Output:
// 19
// ✅ Example 2
// Input
// A = [-153, -689]

// Only negative numbers.

// No alternating possible.

// So maximum fair subsequence length = 1

// Pick maximum element:

// -153

// Output:

// -153
// ✅ Example 3 (Important)
// A = [-1, 18, 13, 18, 2, -1, -213, 11]

// Group by sign blocks:

// Block 1: -1
// Block 2: 18, 13, 18, 2
// Block 3: -1, -213
// Block 4: 11

// To maximize length:
// Pick one element from each sign block.

// Best choice:

// From block1 → -1

// From block2 → 18 (max positive)

// From block3 → -1 (max negative)

// From block4 → 11

// Length = 4
// Sum = -1 + 18 + (-1) + 11 = 27
// [-1, 18, 13, 18, 2, 16, -1, -213, 11]

// Indexes:

// 0   1   2   3   4   5   6    7    8
// -1 18  13  18   2  16  -1  -213  11
// ❌ Why Your 34 Logic Is Wrong

// You said: (Wrong)

// First pair: 18 - 1 = 17
// Second pair: 18 - 1 = 17
// Total = 34

// Let’s see what you are actually selecting:

// You are selecting:

// 18 (index 1)
// -1 (index 6)
// 18 (index 3)
// -1 (index 6 again??)

// Two big problems:

// 🚫 Problem 1: Order Violation

// After picking:

// 18 (index 1)
// -1 (index 6)

// Now if you pick:

// 18 (index 3)

// That is impossible.

// Because index 3 comes before index 6.

// Subsequence must follow increasing index order.

// You cannot go back.

// 🚫 Problem 2: Reusing Same Element

// There are only two -1 values:

// index 0

// index 6

// You cannot use the same -1 twice in different pairs.

// Each element can be used only once.

// ✅ What Is the Longest Valid Alternating Subsequence?

// Let’s construct properly:

// Start from first negative:

// -1 (index 0)
// 18 (index 1)
// -1 (index 6)
// 11 (index 8)

// This is valid:

// Negative → Positive → Negative → Positive

// Length = 4
// Sum =

// -1 + 18 + (-1) + 11 = 27
// 🚫 Can We Get Length 6?

// Try to build:

// -1 → 18 → -1 → 18 → -1 → 11

// Impossible.

// Because:

// All positives 18,13,18,2,16 are between index 1–5.

// After picking -1 at index 6,
// you cannot go back to pick another positive from earlier.
public class MaxFairSubSeqAlternateSum {

    // A = [-1, 18, 13, 18, 2, -1, -213, 11]

    // Group by sign blocks:

    // Block 1: -1
    // Block 2: 18, 13, 18, 2
    // Block 3: -1, -213
    // Block 4: 11

    // To maximize length:
    // Pick one element from each sign block.

    // Best choice:

    // From block1 → -1

    // From block2 → 18 (max positive)

    // From block3 → -1 (max negative)

    // From block4 → 11

    // Length = 4
    //O/P -  Sum = -1 + 18 + (-1) + 11 = 27


 static long maxFairSubsequenceSum(int[] arr) {

    long sum = 0;
    int n = arr.length;

    int currentMax = arr[0];

    for (int i = 1; i < n; i++) {

        // Same sign
        if ((arr[i] >= 0 && currentMax >= 0) ||
            (arr[i] < 0 && currentMax < 0)) {

            currentMax = Math.max(currentMax, arr[i]);
        } 
        else {
            sum += currentMax;
            currentMax = arr[i];
        }
    }

    sum += currentMax;

    return sum;
}

    public static void main(String[] args) {
        int[] arr = {21, 12, 13, -21, -2};
       System.out.println( maxFairSubsequenceSum(arr));

    }

}
