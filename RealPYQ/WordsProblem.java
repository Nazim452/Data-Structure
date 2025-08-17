package RealPYQ;

public class WordsProblem {


// We need to find two words from an array such that:

// They don't share any common letters.

// The sum of their lengths is the maximum possible among all such pairs.

// If no such pair exists, return 0.


// But in real-world performance:
// Bitmasking is significantly faster because it reduces the costly character-wise comparisons.

 public static int maxLengthPair(String[] words) {
        int n = words.length;
        if (n < 2) return 0;

        int[] bitMasks = new int[n];
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            bitMasks[i] = mask;
            lengths[i] = words[i].length();
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitMasks[i] & bitMasks[j]) == 0) {
                    maxSum = Math.max(maxSum, lengths[i] + lengths[j]);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
          // ✅ Test Case 1: Normal case
        String[] test1 = { "abc", "ab", "foo", "bar", "xtgn", "abcdeg" };
        System.out.println("Test 1 Output: " + maxLengthPair(test1)); // Expected: 9 (foo + abcdeg)

        // ✅ Test Case 2: All words share common characters
        String[] test2 = { "a", "aa", "aaa", "aaaa" };
        System.out.println("Test 2 Output: " + maxLengthPair(test2)); // Expected: 0

        // ✅ Test Case 3: Minimum input size
        String[] test3 = { "abc" };
        System.out.println("Test 3 Output: " + maxLengthPair(test3)); // Expected: 0

        // ✅ Test Case 4: Words with empty string
        String[] test4 = { "", "abc", "xyz" };
        System.out.println("Test 4 Output: " + maxLengthPair(test4)); // Expected: 6 (abc + xyz)

        // ✅ Test Case 5: Two large disjoint words
        String[] test5 = { "abcdefghij", "klmnopqrst" };
        System.out.println("Test 5 Output: " + maxLengthPair(test5)); // Expected: 20
        
    }
}
