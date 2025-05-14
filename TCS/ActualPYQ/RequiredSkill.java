package TCS.ActualPYQ;

import java.util.*;
 
// Problem Statement: Minimum Team Selection for Required Skills
// You are given a set of required skills and a number of candidates, where each candidate
// possesses certain skills. Your task is to form a team with the minimum number of people that
// collectively covers all the required skills.
// Input Format:
// A single line containing:
// A space-separated list of required skills. 1.
// A comma (,) followed by the number of candidates. 2.
// A comma-separated list where each part contains space-separated skills of a candidate. 3.
// Output Format:
// A space-separated list of indices representing the minimum number of candidates needed to
// cover all required skills.
// Example:
// Input:
// a b c d , 4 , a b , c , c d , c
// Output:
// 0 2
// Explanation:
// The required skills are {a, b, c, d}.
// There are 4 candidates:
// Candidate 0: {a, b}
// Candidate 1: {c}
// Candidate 2: {c, d}
// Candidate 3: {c}
// The minimum team is [0, 2] because:
// Candidate 0 covers {a, b}.
// Candidate 2 covers {c, d},Together, they cover {a, b, c, d} with the fewest people.

//   _________________Test Caess_________________________

//  Test case 1- a b c d , 4 , a b , c , c d , c  ________  Output -  0 2
//  Test case 2- x y z , 3 , x , y , z  ________  Output -  0 1 2
//  Test case 2- p q r , 3 , p q r , p , q  ________  Output -  0 1 2
//  Test case 2- m n , 4 , m n , m , n , m n ________  Output -  0 
//  Test case 2- 1 2 3 4 5 , 5 , 1 2 , 3 4 , 5 , 1 3 , 2 4 5 ________  Output - 3,4 

public class RequiredSkill {

    private static List<Integer> findMinimumTeam(Set<String> requiredSkills, List<Set<String>> candidates) {
        List<Integer> bestTeam = new ArrayList<>();
        backtrack(0, requiredSkills, candidates, new ArrayList<>(), bestTeam, new HashSet<>());
        return bestTeam;
    }

    private static void backtrack(int start, Set<String> requiredSkills, List<Set<String>> candidates,
            List<Integer> currentTeam, List<Integer> bestTeam, Set<String> coveredSkills) {
        if (coveredSkills.containsAll(requiredSkills)) {
            if (bestTeam.isEmpty() || currentTeam.size() < bestTeam.size()) {
                bestTeam.clear();
                bestTeam.addAll(currentTeam);
            }
            return;
        }

        if (!bestTeam.isEmpty() && currentTeam.size() >= bestTeam.size()) {
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            Set<String> newSkills = new HashSet<>(candidates.get(i));
            newSkills.removeAll(coveredSkills);
            newSkills.retainAll(requiredSkills);

            if (!newSkills.isEmpty()) {
                currentTeam.add(i);
                coveredSkills.addAll(candidates.get(i));

                backtrack(i + 1, requiredSkills, candidates, currentTeam, bestTeam, coveredSkills);

                currentTeam.remove(currentTeam.size() - 1);
                coveredSkills.removeAll(candidates.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        // Improved input parsing
        String[] parts = input.split("\\s*,\\s*", 3); // Split on commas with optional whitespace
        if (parts.length != 3) {
            System.out.println("Invalid input format");
            return;
        }

        Set<String> requiredSkills = new HashSet<>(Arrays.asList(parts[0].split("\\s+")));
        int numCandidates;
        try {
            numCandidates = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of candidates");
            return;
        }

        List<Set<String>> candidates = new ArrayList<>();
        String[] candidateSkills = parts[2].split("\\s*,\\s*"); // Split on commas with optional whitespace

        for (String skills : candidateSkills) {
            candidates.add(new HashSet<>(Arrays.asList(skills.trim().split("\\s+"))));
        }

        if (candidates.size() != numCandidates) {
            System.out.println("Number of candidates doesn't match");
            return;
        }

        List<Integer> result = findMinimumTeam(requiredSkills, candidates);

        // Output the result
        for (int i = 0; i < result.size(); i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(result.get(i));
        }
    }

}