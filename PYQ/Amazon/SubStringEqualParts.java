package PYQ.Amazon;
// First: What is “Maximum Parts”?

import java.util.Arrays;

// Suppose you have a string:

// ABAB

// We are checking each prefix.

// Full string = "ABAB"

// Now question is:

// 👉 Into how many equal parts can we divide it
// such that each part has same number of A, B, C, etc.

// 🔸 What does “equal parts” mean?

// It means:

// Parts must be same length.

// Each part must contain same count of characters.

// Example 1: "ABAB"

// Can we divide into 1 part?

// Yes → "ABAB"
// Every string can be 1 part.

// So minimum answer is always 1.

// Can we divide into 2 equal parts?

// Split like this:

// AB | AB

// First part:
// A = 1
// B = 1

// Second part:
// A = 1
// B = 1

// They are identical in character frequency.

// So answer = 2 parts possible

// Can we divide into 3 parts?

// Length = 4
// 4 cannot be divided equally into 3 parts.

// So not possible.

// So maximum parts = 2

// 🔹 Now Example: "ABBAC"

// Let’s understand slowly.

// Prefix 1 → "A"

// Only one character.

// You cannot split it further.

// So answer = 1

// Prefix 2 → "AB"

// Try dividing into 2 parts:

// A | B

// First part:
// A=1

// Second part:
// B=1

// They are NOT same frequency.

// So cannot divide.

// Answer = 1

// Prefix 3 → "ABB"

// Try dividing into 2 parts:

// Length = 3
// Cannot divide equally.

// Answer = 1

// Prefix 4 → "ABBA"

// Try dividing into 2 parts:

// AB | BA

// First part:
// A=1, B=1

// Second part:
// A=1, B=1

// Valid.

// So answer = 2
// Input = "ABAB"
// | Prefix | Frequencies |GCD(OwnLoic)|Max Parts |
// | ------ | ----------- | --- | --------- |
// | A      | A=1         | 1   | 1         |
// | AB     | A=1 B=1     | 1   | 1         |
// | ABA    | A=2 B=1     | 1   | 1         |
// | ABAB   | A=2 B=2     | 2   | 2         |
// [1, 1, 1, 2] - Output

public class SubStringEqualParts {

    public static int[] getMaxPartsOptimized(String s) {
        int n = s.length();
        int[] result = new int[n];
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;

            int gcd = 0;

            // Compute GCD of all non-zero frequencies
            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    gcd = gcd == 0 ? freq[j] : gcd(gcd, freq[j]);
                }
            }

            result[i] = gcd;
        }

        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


     public static int[] getMaxPartsBruteForce(String s) {
        int n = s.length();
        int[] result = new int[n];

        for (int end = 0; end < n; end++) {

            String prefix = s.substring(0, end + 1);
            int L = prefix.length();

            int maxParts = 1;

            // Try from L down to 1
            for (int k = L; k >= 1; k--) {

                if (L % k != 0) continue;

                int partSize = L / k;
                boolean valid = true;

                int[] baseFreq = getFreq(prefix.substring(0, partSize));

                for (int i = partSize; i < L; i += partSize) {
                    int[] currentFreq = getFreq(prefix.substring(i, i + partSize));

                    if (!Arrays.equals(baseFreq, currentFreq)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    maxParts = k;
                    break;
                }
            }

            result[end] = maxParts;
        }

        return result;
    }

    private static int[] getFreq(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'A']++;
        }
        return freq;
    }

    public static void main(String[] args) {
         String s = "ABBAC";
        int[] ans = getMaxPartsOptimized(s);

        for (int x : ans) {
            System.out.print(x + " ");
        }
        

        //  String s = "ABBAC";
        // int[] ans = getMaxParts(s);

        // System.out.println(Arrays.toString(ans));
    }
    

}
