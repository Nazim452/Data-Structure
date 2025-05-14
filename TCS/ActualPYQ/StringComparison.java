package TCS.ActualPYQ;

// Problem statement - 
// Two strings are considered close if you can attain one from the other using the following operations:
//  Operation 1: Swap any two existing characters.
//  For example, abcde-> aecdb
//  Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//  For example, aacabb-> bbcbaa (all a's turn into b's, and all b's turn into a's)
//  You can use the operations on either string as many times as necessary.
//  Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
//  Example 1:
//  Input: word1 = "abc", word2 = "bca" Output: true Explanation: You can attain word2 from word1 in 2 operations. Apply Operation 1: "abc" -> 
// "acb" Apply Operation 1: "acb" -> "bca" 
// Example 2:
//  Input: word1 = "a", word2 = "aa" Output: false Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of 
// operations. 
// Example 3:
//  Input: word1 = "cabbba", word2 = "abbccc" Output: true Explanation: You can attain word2 from word1 in 3 operations. Apply Operation 1: 
// "cabbba" -> "caabbb" Apply Operation 2: "caabbb" -> "baaccc" Apply Operation 2: "baaccc" -> "abbccc" 
// Constraints:
//  1 <= word1.length, word2.length <= 105
//  word1 and word2 contain only lowercase English letters








// _______________________________SOLUTION______________________________________


// To determine if two strings are "close" according to the given operations, we need to check three key conditions:

// Same Length: The strings must be of equal length.

// Same Character Set: Both strings must contain exactly the same set of characters.

// Same Frequency Multiset: The multiset of character frequencies must be identical between both strings (the frequencies can be rearranged).

// Same Number of Blocks: Both groups must have equal total blocks (words same length) ✅

// Same Colors Available: Both groups must use the exact same colors (same letters) ✅

// Same Quantity Patterns: The way colors are distributed must match when you ignore which color is which. This is the frequency check.

//  Input: word1 = "cabbba", word2 = "abbccc" Output: true _______________________________
// Check if both words have the same characters (non-zero frequencies at same indices):

// freq1 non-zero indices: 0,1,2 (a,b,c)

// freq2 non-zero indices: 0,1,2 (a,b,c)

// Character sets match → Continue

// The Frequency Check (Step 4) Explained Simply:
// For "cabbba":

// a appears 2 times

// b appears 3 times

// c appears 1 time
// → Pattern: [2, 3, 1]

// For "abbccc":

// a appears 1 time

// b appears 2 times

// c appears 3 times
// → Pattern: [1, 2, 3]

// Now sort both patterns:

// Both become [1, 2, 3] when sorted

// This means:

// You can swap which color has which count (Operation 2)

// Like swapping price tags between items - the counts stay the same, just which letters have them changes

// Why Sorting Works:
// Sorting lets us ignore which letters have which counts, just checking if the same counts exist in both words.
import java.util.*;

public class StringComparison {
    public static boolean closeStrings(String word1, String word2) {
        // Check if lengths are different
        if (word1.length() != word2.length()) {
            return false;
        }

        // Get frequency maps for both words
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // for (char c : word1.toCharArray()) freq1[c - 'a']++;
        // for (char c : word2.toCharArray()) freq2[c - 'a']++;


        // Or

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            freq1[c - 'a']++;
        }
        
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            freq2[c - 'a']++;
        }

        // Check if character sets are the same
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Sort and compare frequency arrays
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }


   
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));  // true
        System.out.println(closeStrings("a", "aa"));     // false
        System.out.println(closeStrings("cabbba", "abbccc"));  // true
    }
}

// TIME COMPLEXITY_________O(n)________________SPACE - O(1)__Fixed size __________________


// Time Complexity Breakdown:
// Length Check: O(1) - Simple integer comparison

// Frequency Counting: O(n) - Two passes through each string (n = length of strings)

// Character Set Check: O(26) = O(1) - Fixed iteration through alphabet size

// Sorting Frequencies: O(26 log 26) = O(1) - Sorting fixed-size arrays (26 elements)

// Total Time Complexity:
// O(n) (dominated by the frequency counting step)

// The other steps are constant time operations

// Space Complexity:
// O(1) - Uses fixed-size arrays (26 elements each) regardless of input size

// Why This is Efficient:
// The alphabet size (26) is constant, so operations on the frequency arrays are O(1)

// Only linear passes through the input strings (O(n))

// No data structures grow with input size