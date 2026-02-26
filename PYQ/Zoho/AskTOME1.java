package PYQ.Zoho;

// Lena receives a long message S from her friend. Hidden within this message is a secret word T.

// The letters of T appear in S in the same order, but they may not be next to each other. In other words, T must appear as a subsequence of a substring of S.

// Your task is to help Lena find the shortest substring of S in which T appears as a subsequence.

// If multiple substrings have the same shortest length, return all such substrings.

// If no such substring exists, return an empty string.

// Definitions

// A substring is a continuous portion of a string.

// A subsequence means characters appear in the same order, but not necessarily consecutively.

// Test Case 1
// Input:
// S = "aaabbbccc"
// T = "abc"
// Output:
// abbbc
// Test Case 2
// Input:
// S = "abcdebdde"
// T = "bde"
// Output:
// bcde
// bdde
// Explanation:

// Both "bcde" and "bdde" are the shortest substrings in which "bde" appears as a subsequence.

// Test Case 3
// Input:
// S = "abc"
// T = "abcd"
// Output:
// ""
// Explanation:

// It is not possible to form "abcd" as a subsequence of any substring of "abc".

import java.util.ArrayList;
import java.util.List;

public class AskTOME1{
     public static List<String> minWindow2(String S, String T) {

        int n = S.length();
        int minLen = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int tIndex = 0;

            for (int j = i; j < n; j++) {

                if (S.charAt(j) == T.charAt(tIndex)) {
                    tIndex++;
                }

                // If full subsequence matched
                if (tIndex == T.length()) {

                    int windowLen = j - i + 1;
                    String window = S.substring(i, j + 1);

                    if (windowLen < minLen) {
                        minLen = windowLen;
                        result.clear(); // remove old longer windows
                        result.add(window);
                    } else if (windowLen == minLen) {
                        result.add(window); // add equal shortest window
                    }

                    break; // stop expanding this start index
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
          String S = "abcdebdde";
        String T = "bde";

        List<String> ans = minWindow2(S, T);

        if (ans.isEmpty()) {
            System.out.println("");
        } else {
            for (String s : ans) {
                System.out.println(s);
            }
        }

    }
}