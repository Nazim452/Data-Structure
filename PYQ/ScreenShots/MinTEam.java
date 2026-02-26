import java.util.*;
// Rewritten Problem Statement (Clean Version)
// Problem: Team Formation

// Alice wants to organize a contest with 3 players in each team.

// There are two types of players:

// Experienced

// Freshers

// To keep the contest unbiased, each team must have:

// At least 1 Experienced player

// At least 1 Fresher

// You are given:

// N → number of Experienced players

// M → number of Freshers

// Constraints:

// No team member can be in more than one team.

// Each team must contain exactly 3 players.

// Task:

// Determine the maximum number of teams that can be formed.

// Example (Reconstructed)

// Input:

// 3 5

// Output:

// 2

// Explanation:

// Team 1 → 1 Experienced + 2 Freshers

// Team 2 → 2 Experienced + 1 Fresher

// Total teams = 2

// 🔎 Understanding the Core Logic

// Each team:

// Size = 3

// Must contain at least 1 from both groups

// So valid team types are:

// 1 Experienced + 2 Freshers

// 2 Experienced + 1 Fresher

// That’s it.
// 🧠 Smart Observation (Optimal Thinking)

// Each team requires:

// 3 total players

// At least 1 from each category

// So two limitations exist:

// Limitation 1 → Total players

// Since each team needs 3 players:

// Max teams ≤ (N + M) / 3
// Limitation 2 → Minority group restriction

// Each team needs at least 1 Experienced AND 1 Fresher.

// So:

// Max teams ≤ min(N, M)

// Because if one category finishes, no more teams possible.

// 🎯 Final Formula

// Maximum teams =

// min( (N + M) / 3 , min(N, M) )
// 🔥 Why This Formula Works

// We are taking the minimum of:

// 1️⃣ Total capacity limit
// 2️⃣ Category balancing limit

// Whichever runs out first stops team formation.

// 🧠 Example 1

// N = 3
// M = 5

// Total players = 8

// (3 + 5) / 3 = 8 / 3 = 2
// min(N, M) = 3

// Final answer = min(2, 3) = 2

// 🧠 Example 2

// N = 10
// M = 2

// Total players = 12

// 12 / 3 = 4
// min(N, M) = 2

// Answer = min(4, 2) = 2

// Because Freshers finish first.
public class MinTEam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int totalLimit = (N + M) / 3;
        int categoryLimit = Math.min(N, M);

        System.out.println(Math.min(totalLimit, categoryLimit));
    }
}