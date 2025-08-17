package RealPYQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Why Use Set<Character>?
// Sets allow fast lookup: O(1) average time.

// So set.contains(c) is efficient.

// 🔁 What Happens with List<List<Character>>?
// You’ll use a List<Character> for each word.

// To check if a character exists in another list, you’ll use list.contains(c) — this is O(n) where n is the word length.

// So overall complexity increases, but it still works correctly.

// We need to find two words from an array such that:

// They don't share any common letters.

// The sum of their lengths is the maximum possible among all such pairs.

// If no such pair exists, return 0.

public class WordsProblemTwo {

    public static int maxLengthSum(String[] words) {
        int n = words.length;
        List<Set<Character>> charSets = new ArrayList<>();

        // Step 1: Convert each word to a Set of characters

        // TC - n*k , n = word .length and k - average length of each word
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            charSets.add(set);
        }

        int max = 0;

        // Step 2: Compare all pairs
        // Tc - O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hasCommonLetter(charSets.get(i), charSets.get(j))) {
                    int lenSum = words[i].length() + words[j].length();
                    max = Math.max(max, lenSum);
                }
            }
        }

        return max;

        // Tc - (n*k+ n^2)
    }

    // Step 3: Check for common letters
    private static boolean hasCommonLetter(Set<Character> set1, Set<Character> set2) {
        for (char c : set1) {
            if (set2.contains(c))
                return true;
        }
        return false;
    }

    // In essence, Set is the blueprint, while HashSet is a specific implementation
    // of that
    // blueprint. You cannot directly instantiate a Set because it's an interface.
    // Instead
    // , you create an object of a class that implements Set, such as HashSet,
    // TreeSet,
    // or LinkedHashSet, depending on the specific requirements for ordering and
    // performance.

    public static void main(String[] args) {
        // ✅ Test Case 1: Normal case
        String[] test1 = { "abc", "ab", "foo", "bar", "xtnnn", "abcdeg" };
        System.out.println("Test 1 Output: " + maxLengthSum(test1)); // Expected: 9 (foo + abcdeg)

        // ✅ Test Case 2: All words share common characters
        String[] test2 = { "a", "aa", "aaa", "aaaa" };
        System.out.println("Test 2 Output: " + maxLengthSum(test2)); // Expected: 0

        // ✅ Test Case 3: Minimum input size
        String[] test3 = { "abc" };
        System.out.println("Test 3 Output: " + maxLengthSum(test3)); // Expected: 0

        // ✅ Test Case 4: Words with empty string
        String[] test4 = { "", "abc", "xyz" };
        System.out.println("Test 4 Output: " + maxLengthSum(test4)); // Expected: 6 (abc + xyz)

        // ✅ Test Case 5: Two large disjoint words
        String[] test5 = { "abcdefghij", "klmnopqrst" };
        System.out.println("Test 5 Output: " + maxLengthSum(test5)); // Expected: 20

    }
}
