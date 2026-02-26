package PYQ.Zoho;

// ✅ Rewritten Problem Statement (Clear Version)

// In a village called Lexiconia, there is a grid of characters (2D matrix).

// A traveler starts at the top-left cell (0,0) and must reach the bottom-right cell (n-1, m-1).

// Movement Rules:

// You can move only Right → (i, j+1)

// Or move only Down ↓ (i+1, j)

// No left, no up, no diagonal.

// While moving, you collect the characters along the path to form a string.

// Your Task

// Find the longest path string (from top-left to bottom-right) that forms a palindrome.

// A palindrome reads the same forward and backward.

// There may be multiple longest palindromic paths.

// If no palindrome path exists, return an empty string.

// Important Observations

// Every valid path will have fixed length:

// path length = n + m - 1

// You must check all possible right/down paths.

// From those paths, keep only the palindromes.

// Return the longest one(s).

// ✅ Basic Brute Force Approach (Very Simple Logic)
// Idea:

// Generate all possible paths

// Build string while traversing

// When reaching bottom-right:

// Check if string is palindrome

// Store valid ones

// Return longest palindrome(s)

// Time Complexity:

// O(2^(n+m))

// (Exponential — but acceptable since you asked brute force)
import java.util.*;

public class AskTOME3 {

    static List<String> result = new ArrayList<>();
    static int maxLen = 0;

    public static List<String> findLongestPalindromes(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        result.clear();
        maxLen = 0;

        dfs(grid, 0, 0, new StringBuilder());

        return result;
    }

    private static void dfs(char[][] grid, int i, int j, StringBuilder path) {

        int n = grid.length;
        int m = grid[0].length;

        // Add current character
        path.append(grid[i][j]);

        // If reached bottom-right
        if (i == n - 1 && j == m - 1) {

            String current = path.toString();

            if (isPalindrome(current)) {

                if (current.length() > maxLen) {
                    maxLen = current.length();
                    result.clear();
                    result.add(current);
                }
                else if (current.length() == maxLen) {
                    result.add(current);
                }
            }
        }
        else {
            // Move Down
            if (i + 1 < n)
                dfs(grid, i + 1, j, path);

            // Move Right
            if (j + 1 < m)
                dfs(grid, i, j + 1, path);
        }

        // Backtrack
        path.deleteCharAt(path.length() - 1);
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'a', 'x', 'a'},
                {'x', 'b', 'x'},
                {'a', 'x', 'a'}
        };                  //
        // char[][] grid = {
        //         {'a', 'e'},
        //         {'c', 'd'},
               
        // };
        // char[][] grid = {
        //         {'a', 'b'},
        //         {'b', 'a'},
               
        // };

        // Can use hashSet to remove duplicate

        List<String> ans = findLongestPalindromes(grid);

        if (ans.isEmpty()) {
            System.out.println("");
        } else {
            for (String s : ans)
                System.out.println(s);
        }
    }
}
