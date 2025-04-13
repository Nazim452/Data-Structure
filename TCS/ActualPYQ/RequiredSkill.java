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
// Candidate 2 covers {c, d},Together, they cover {a, b, c, d} with the fewest people


public class RequiredSkill {
    static List<Integer> bestTeam;
    static Map<String, Integer> SkillIndex = new HashMap<>();
    private static List<Integer> findMinimumTeam(Set<String> required, List<Set<String>> candidates) {
        List<Integer> currentTeam = new ArrayList<>();
        List<Integer> bestTeam = new ArrayList<>();
        Set<String> covered = new HashSet<>();
        
        backtrack(0, required, candidates, covered, currentTeam, bestTeam);
        return bestTeam;
    }
    
    private static void backtrack(int start, Set<String> required, List<Set<String>> candidates, 
                                Set<String> covered, List<Integer> currentTeam, List<Integer> bestTeam) {
        // Check if we've covered all required skills
        if (covered.containsAll(required)) {
            if (bestTeam.isEmpty() || currentTeam.size() < bestTeam.size()) {
                bestTeam.clear();
                bestTeam.addAll(currentTeam);
            }
            return;
        }
        
        // Prune if current team is already larger than the best found so far
        if (!bestTeam.isEmpty() && currentTeam.size() >= bestTeam.size()) {
            return;
        }
        
        // Try adding each candidate starting from 'start'
        for (int i = start; i < candidates.size(); i++) {
            Set<String> newSkills = new HashSet<>(candidates.get(i));
            newSkills.removeAll(covered);
            
            // Only proceed if this candidate adds new skills
            if (!newSkills.isEmpty()) {
                covered.addAll(candidates.get(i));
                currentTeam.add(i);
                
                // Recursively try adding more candidates
                backtrack(i + 1, required, candidates, covered, currentTeam, bestTeam);
                
                // Backtrack
                currentTeam.remove(currentTeam.size() - 1);
                covered.removeAll(candidates.get(i));
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        // Parse the input
        String[] parts = input.split(" , ");
        String[] requiredSkills = parts[0].split(" ");
        int numCandidates = Integer.parseInt(parts[1]);
        String[] candidatesSkills = parts[2].split(" , ");
        
        // Convert required skills to a set
        Set<String> required = new HashSet<>(Arrays.asList(requiredSkills));
        
        // Convert each candidate's skills to a set
        List<Set<String>> candidates = new ArrayList<>();
        for (String skills : candidatesSkills) {
            candidates.add(new HashSet<>(Arrays.asList(skills.split(" "))));
        }
        
        // Find the minimum team
        List<Integer> result = findMinimumTeam(required, candidates);
        
        // Output the result
        if (result.isEmpty()) {
            System.out.println("No solution exists");
        } else {
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
}