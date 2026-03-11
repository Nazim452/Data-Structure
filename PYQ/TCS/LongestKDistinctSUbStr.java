package PYQ.TCS;

import java.util.HashMap;
import java.util.HashSet;
// Problem Statement (Clearly Explained)
import java.util.Map;

import javax.crypto.spec.HKDFParameterSpec.Expand;

// You are given:

// A string s

// An integer k

// Your task is:

// 👉 Find the length of the longest contiguous substring
// 👉 That contains at most k distinct characters

// 🔍 Important Words Explained
// 1️⃣ Contiguous Substring

// Characters must be continuous (no skipping).

// Example:

// For "abcde"
// Valid substring: "bcd"
// Invalid: "ace" ❌ (not contiguous)

// 2️⃣ At Most k Distinct Characters

// If k = 2, substring can contain:

// 1 distinct character ✅

// 2 distinct characters ✅

// 3 distinct characters ❌

// 🧪 Example From Image
// s = "eceba"
// k = 2

// We must find longest substring with ≤ 2 distinct characters.

// 🔎 Try All Substrings
// Substring	Distinct Characters	Valid?
// e	1	✅
// ec	2	✅
// ece	2	✅
// eceb	3	❌
// ce	2	✅
// ceb	3	❌
// ba	2	✅

// Longest valid substring:

// "ece"

// Length = 3

// ✔ Output = 3

// 🧪 More Test Cases
// Test Case 1
// s = "aaabbcc"
// k = 1

// Valid substrings:

// "aaa" → length 3

// "bb" → length 2

// "cc" → length 2

// Longest = 3

// Output:

// 3
// Test Case 2
// s = "abcabc"
// k = 2

// Possible substrings:

// "ab" → 2

// "bc" → 2

// "ca" → 2

// "abc" → 3 distinct ❌

// Longest = 2

// Output:

// 2
// Test Case 3
// s = "aaaa"
// k = 2

// Entire string has only 1 distinct character.

// Output:

// 4
// Test Case 4 (Edge Case)
// s = "abc"
// k = 0

// At most 0 distinct characters means:
// No characters allowed.

// Output:

// 0
// Test Case 5
// s = "aabacbebebe"
// k = 3

// Longest substring:

// cbebebe

// Length = 7

// Output:

// 7
public class LongestKDistinctSUbStr {

   static void bruteForce(String s, int k) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < n; j++) {

                set.add(s.charAt(j));

                if (set.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break; // more than k distinct
                }
            }
        }

        System.out.println("Brute Force Answer = " + maxLen);
    } 
    
//    What Is Sliding Window Actually Doing?

// Think of it like:

// [left .......... right]

// We:

// Expand window → move right

// If condition breaks → shrink window → move left

// That’s it.

// 🔥 Core Idea Behind Shrinking

// The moment:

// distinct characters > k

// The window becomes invalid.

// So we must shrink it until it becomes valid again.

// 🧩 Why Do We Reduce Frequency?

// Let’s understand step-by-step.

// Suppose:

// s = "eceba"
// k = 2

// We expand:

// Window = "ece"
// Distinct = 2 → valid

// Then expand:

// Window = "eceb"
// Distinct = 3 → invalid ❌

// Now what?

// We must remove characters from the left side.

// 🎯 Why Remove From Left?

// Because:

// We are finding contiguous substring.

// If we remove from middle → not contiguous anymore.

// So only left can move.

// 🧠 Why Decrease Frequency?

// We use HashMap:

// map.put(char, frequency)

// When shrinking:

// map.put(leftChar, map.get(leftChar) - 1)

// Why?

// Because:

// Maybe that character appears multiple times.

// Example:

// Window = "eceb"
// Map = {e=2, c=1, b=1}

// If we remove first 'e':

// Map becomes {e=1, c=1, b=1}

// Still 3 distinct → still invalid.

// 🚨 Why Remove From Map When Frequency = 0?

// Suppose:

// Map = {e=1, c=1, b=1}

// Remove 'e':

// Map = {e=0, c=1, b=1}

// If we don’t remove e, then:

// Map size still = 3 ❌

// But actually, 'e' is no longer in window.

// So we must:

// if(freq == 0)
//     map.remove(char)

// Now:

// Map = {c=1, b=1}
// Distinct = 2 → valid again
// 🎯 So The Shrinking Logic Is:

// When invalid:

// while (map.size() > k)
// {
//     reduce leftChar frequency
//     if frequency becomes 0
//         remove from map
//     left++
// }

// This ensures:

// ✅ Window becomes valid again
// ✅ Window always stays contiguous
// ✅ No unnecessary recalculation

// 🔎 The Deep Technique Behind This

// This technique works because:

// 1️⃣ Window Always Represents a Valid Substring

// We maintain invariant:

// map.size() <= k
// 2️⃣ Each Character Is Processed Maximum Twice

// Once when right moves

// Once when left moves

// So total time = O(n)

// That is why sliding window is O(n), not O(n²).

// 🎯 The Real Insight

// We are not randomly shrinking.

// We shrink just enough to restore validity.

// That’s the key.

// We never restart from scratch.

// 💡 Important Principle

// Sliding Window works when:

// Problem involves contiguous subarray/substr

// Condition can be maintained incrementally

// Condition can be fixed by moving left pointer

// 🧠 Mental Model

// Think like this:

// Expand → Break Rule → Shrink → Fix Rule → Expand Again

// That’s the entire sliding window philosophy.
     static void optimized(String s, int k) {

        int n = s.length();
        int start = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < n; end++) {

            char rightChar = s.charAt(end);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // Shrink window if distinct > k
            while (map.size() > k) {

                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        System.out.println("Optimized Answer = " + maxLen);
    }


    
    
    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;
        bruteForce(str, k);

    }
    
}




