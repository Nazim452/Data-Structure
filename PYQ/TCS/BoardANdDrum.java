package PYQ.TCS;

// Clear Problem Statement (Rewritten Simply)

// You have:

// N students standing in positions 1 to N

// Each student holds a board showing a number

// Example:

// Board = [2, 3, 1, 5, 4]

// Meaning:

// Student at position:

// 1 will move to position 2

// 2 will move to position 3

// 3 will move to position 1

// 4 will move to position 5

// 5 will move to position 4

// After every drum beat:

// 👉 Each student moves to the position written on the board he is holding.

// You must find:

// ⏳ How many beats are required for all students to come back to their original positions?

// ✅ Example 1 (Very Easy)

// Input:

// N = 3
// Board = [1, 2, 3]

// Meaning:

// Student 1 → position 1

// Student 2 → position 2

// Student 3 → position 3

// Nobody moves.

// After 1 beat:
// Still same.

// So answer = 1

// ✅ Example 2 (From Your Screenshot)

// Input:

// N = 5
// Board = [2, 3, 1, 5, 4]

// Initial positions:

// 1 2 3 4 5
// 🔹 Beat 1

// Movement:

// 1 → 2

// 2 → 3

// 3 → 1

// 4 → 5

// 5 → 4

// New order:

// 3 1 2 5 4
// 🔹 Beat 2

// Apply same rule again:

// 2 3 1 4 5
// 🔹 Beat 3
// 1 2 3 5 4
// 🔹 Beat 4
// 3 1 2 4 5
// 🔹 Beat 5
// 2 3 1 5 4
// 🔹 Beat 6
// 1 2 3 4 5

// Back to original.

// Answer = 6

// Because this permutation contains cycles.

// Look at board:

// 1 → 2 → 3 → 1

// This is a cycle of length 3.

// And:

// 4 → 5 → 4

// This is a cycle of length 2.

// To return to original position:

// We need LCM of cycle lengths.

// LCM(3,2) = 6

// That’s why answer is 6.

import java.util.*;

public class BoardANdDrum {

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // int[] board = new int[n + 1];

        // for (int i = 1; i <= n; i++) {
        // board[i] = sc.nextInt();
        // }

        // int[] current = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        // current[i] = i;
        // }

        // int[] original = current.clone();

        // int beats = 0;

        // while (true) {
        // beats++;

        // int[] next = new int[n + 1];

        // for (int i = 1; i <= n; i++) {
        // next[board[i]] = current[i];
        // }

        // current = next;

        // if (Arrays.equals(current, original)) {
        // break;
        // }
        // }

        // System.out.println(beats);

        // _________________________________________________________

        // Optimized
        // _________________________________________________________

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Make array size n+1 (ignore index 0)
        int[] board = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            board[i] = sc.nextInt(); // no -1
        }

        boolean[] visited = new boolean[n + 1];
        long answer = 1;

        for (int i = 1; i <= n; i++) {

            if (!visited[i]) {

                int count = 0;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = board[j]; // direct jump
                    count++;
                }

                answer = lcm(answer, count);
            }
        }

        System.out.println(answer);
    }
}

// Excellent question. This is not a trick — this is pure permutation
// mathematics.
// Let’s break it step-by-step using your test case:

// board = {2,3,1,5,4}
// n = 5

// (After converting to 0-based → {1,2,0,4,3})

// 🔥 STEP 1: Understand What This Problem Really Is

// This is a permutation problem.

// Each student moves according to:

// i → board[i]

// That means this forms a directed graph where every node has exactly one
// outgoing edge.

// Such a structure always forms cycles.

// 🔥 STEP 2: Find Cycles (Core Idea)

// Let’s trace manually.

// Cycle 1

// Start from index 0:

// 0 → 1
// 1 → 2
// 2 → 0

// Cycle = (0,1,2)

// Length = 3

// Cycle 2

// Start from index 3:

// 3 → 4
// 4 → 3

// Cycle = (3,4)

// Length = 2

// So permutation has:

// Cycle lengths = 3 and 2
// 🔥 STEP 3: What Does “Returning to Original” Mean?

// Inside a cycle of length 3:

// After 1 beat → shifted
// After 2 beats → shifted
// After 3 beats → back to original

// So:

// 👉 A cycle of length k returns after k beats.

// 🔥 STEP 4: When Do ALL Students Return?

// Cycle 1 returns every 3 beats.

// Cycle 2 returns every 2 beats.

// We need a number that satisfies:

// Multiple of 3
// AND
// Multiple of 2

// Smallest such number is:

// LCM(3,2) = 6

// So answer = 6

// 🔥 WHY LCM???

// Because:

// Each cycle repeats independently.

// We need the first time when all cycles align together.

// This is exactly what LCM means:

// Smallest number divisible by all cycle lengths.

// 🔥 WHY GCD IS USED?

// LCM formula:

// LCM(a,b) = (a × b) / GCD(a,b)

// We use GCD to avoid overflow and compute LCM efficiently.

// Example:

// LCM(3,2)
// = (3×2)/GCD(3,2)
// = 6/1
// = 6
// 🔥 What If Example Was Different?

// Suppose cycles were:

// 4 and 6

// Then:

// LCM(4,6)
// = (4×6)/GCD(4,6)
// = 24/2
// = 12

// So they align after 12 beats.

// ____________________________________________________

// Dry Run

// n = 5
// board = 2 3 1 5 4

// Array representation (1-based):

// Index 1 2 3 4 5
// board 2 3 1 5 4

// Meaning:

// 1 → 2
// 2 → 3
// 3 → 1
// 4 → 5
// 5 → 4
// 🔵 Initial State
// visited = [false,false,false,false,false,false]
// answer = 1

// (Index 0 ignored)

// 🔵 i = 1

// visited[1] = false → start cycle

// Step 1
// j = 1
// visited[1] = true
// j = board[1] = 2
// count = 1
// Step 2
// visited[2] = true
// j = board[2] = 3
// count = 2
// Step 3
// visited[3] = true
// j = board[3] = 1
// count = 3

// Now visited[1] = true → stop

// Cycle length = 3

// Update:

// answer = lcm(1,3) = 3
// 🔵 i = 2

// visited[2] = true → skip

// 🔵 i = 3

// visited[3] = true → skip

// 🔵 i = 4

// visited[4] = false → start cycle

// Step 1
// j = 4
// visited[4] = true
// j = board[4] = 5
// count = 1
// Step 2
// visited[5] = true
// j = board[5] = 4
// count = 2

// visited[4] = true → stop

// Cycle length = 2

// Update:

// answer = lcm(3,2)
// = (3×2)/gcd(3,2)
// = 6
// 🔵 i = 5

// visited[5] = true → skip

// ✅ Final Output
// 6
// 🔥 Key Understanding

// Permutation cycles:

// (1 → 2 → 3 → 1) length 3
// (4 → 5 → 4) length 2

// Return time:

// LCM(3,2)=6
// ____________________________________________________