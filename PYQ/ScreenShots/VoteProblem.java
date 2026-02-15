// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Scanner;

// public class q1 {

//     static void question(int n, int[] vote, int[] age) {
//         // Scanner sc = new Scanner(System.in);
//         // System.out.println("Enter the total length of Array");
//         // int n = sc.nextInt();

//         // System.out.println("Total votes Array");
//         // int[] vote = new int[n];

//         // for(int i = 0; i<n; i++){
//         // vote[i] = sc.nextInt();

//         // }
//         // int[] age = new int[n];
//         // System.out.println("Enter age");

//         // for(int i = 0; i<n; i++) age[i] = sc.nextInt();

//         LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

       
//         for (int i = 0; i < n; i++) {
//             if (age[i] >= 18) {

//                 if (!map.containsKey(vote[i])) {
//                     map.put(vote[i], new ArrayList<>());
//                 }

//                 map.get(vote[i]).add(age[i]);
//             }
//         }

//         int winner =0, ans = -1;;
//         for(var data:map.entrySet()){
//             int key = data.getKey();
//             List<Integer> value = data.getValue();

//             if(value.size()>winner){
//                 winner = value.size();
//                 ans = key;
//             }
           
//         }
//         System.out.println(ans);

//     }

//     public static void main(String[] args) {
//         int n = 10;
//         int[] vote = { 1, 1, 2, 3, 4, 1, 2, 2, 3, 1 };
//         int[] age = { 24, 13, 35, 15, 50, 16, 20, 15, 25, 64 };
//         question(n, vote, age);
//     }
// }


// -------------- Problem statemeent---------------------

// Who Is the Winner
// Problem Statement

// Elections are being conducted in a town with a population of N.
// Each person in the town has cast exactly one vote for a candidate.

// Later, it is decided that only the votes cast by people who are 18 years of age or older should be considered valid.
// Votes from people below 18 years must be ignored.

// You are given two arrays:

// vote[] → where vote[i] represents the candidate number voted for by the i-th person

// age[] → where age[i] represents the age of the i-th voter

// Your task is to determine the winning candidate after considering only valid voters (age ≥ 18).

// Rules for deciding the winner:

// The candidate who receives the maximum number of valid votes is the winner.

// If no winner can be uniquely decided (i.e., a tie occurs), print -1.

// Input Format

// The input consists of three lines:

// An integer N — the number of voters

// N space-separated integers representing the vote[] array

// N space-separated integers representing the age[] array

// Output Format

// Print a single integer:

// The candidate number who wins the election

// Print -1 if there is a tie or if the winner cannot be determined

// Constraints
// 1
// ≤
// 𝑁
// ≤
// 200
// 1≤N≤200
// Example
// Input
// 10
// 1 1 2 3 4 1 2 2 3 1
// 24 13 35 15 50 16 20 18 25 64

// Explanation

// All votes are:

// Candidate 1 → 4 votes
// Candidate 2 → 3 votes
// Candidate 3 → 2 votes
// Candidate 4 → 1 vote


// But only voters with age ≥ 18 are valid.

// Invalid votes (age < 18):

// 2nd vote of candidate 1 (age 13)

// 6th vote of candidate 1 (age 16)

// 4th vote of candidate 3 (age 15)

// After removing invalid votes:

// Candidate 1 → 2 valid votes
// Candidate 2 → 3 valid votes
// Candidate 3 → 2 valid votes
// Candidate 4 → 1 valid vote

// Output
// 2


// Candidate 2 has the highest number of valid votes, so 2 is the winner.








import java.util.*;

public class VoteProblem {

    static void question(int n, int[] vote, int[] age) {

        HashMap<Integer, Integer> count = new HashMap<>();

        // Count only valid votes (age >= 18)
        for (int i = 0; i < n; i++) {
            if (age[i] >= 18) {
                count.put(vote[i], count.getOrDefault(vote[i], 0) + 1);
            }
        }

        for(var data:count.entrySet()){
            System.out.println(data.getKey()+" "+ data.getValue());
        }

        int maxVotes = 0;
        int winner = -1;
        boolean tie = false;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int candidate = entry.getKey();
            int votes = entry.getValue();

            if (votes > maxVotes) {
                maxVotes = votes;
                winner = candidate;
                tie = false;        // new clear winner
            } 
            else if (votes == maxVotes) {
                tie = true;         // someone else got same max
            }
        }

        if (tie) System.out.println(-1);
        else System.out.println(winner);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] vote = {1, 1, 2, 3, 4, 1, 2, 2, 3, 1};
        int[] age = {24, 13, 35, 15, 50, 16, 20, 18, 25, 64};

        question(n, vote, age);
    }
}

