package PYQ.Zoho;

import java.util.ArrayList;
// ❌ Your Code Analysis  (Why My logic fail)
import java.util.Arrays;

// Your core logic:

// for(int j = 0; j < str.length(); j++){
//     if(!list.contains(str.charAt(j))) {
//         Anagram = false;
//         break;
//     }
// }

// You are checking:

// “Are all characters of arr[i] present in the target word?”

// ⚠️ That is NOT sufficient to check anagram.

// ❌ Why Your Code Is Incorrect
// Problem 1 — No Length Check

// Example:

// word = "ate"
// arr[i] = "eatx"

// Your logic:

// e ✔

// a ✔

// t ✔

// x ❌

// So this fails correctly.

// But consider:

// word = "ate"
// arr[i] = "eattt"

// Your logic:

// e ✔

// a ✔

// t ✔

// t ✔

// t ✔

// All characters exist in list.

// So your code will print:

// eattt

// ❌ But that is NOT an anagram.

// Problem 2 — Frequency Not Checked

// Example:

// word = "aab"
// arr[i] = "abb"

// Your logic:

// a ✔

// b ✔

// b ✔

// You will print it.

// ❌ But character counts differ.

// Problem 3 — Case Sensitivity

// Problem input contains:

// Pat, tap

// Your code does not normalize case.

// So:

// Pat

// will fail even though it's an anagram of "tap".

// Problem 4 — You Never Reset Character List

// You created:

// ArrayList<Character> list

// But you never remove used characters per word.

// So repeated characters are not handled correctly.
public class FIndAllAnagram {
    static void question(String[] arr, String word) {
        int n = arr.length;

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            boolean Anagram = true;

            for (int j = 0; j < str.length(); j++) {
                if (!list.contains(str.charAt(j))) {
                    Anagram = false;
                    break;
                }
            }
            if (Anagram)
                System.out.println(arr[i]);
        }
    }

    static void questionOptimized(String[] arr, String word) {

        char[] target = word.toCharArray();
        Arrays.sort(target);
        String sortedTarget = new String(target);

        for (String str : arr) {
            if (str.length() != word.length())
                continue;

            char[] temp = str.toCharArray();
            Arrays.sort(temp);

            if (sortedTarget.equals(new String(temp))) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = { "catch", "got", "tiger", "eat", "tea" };
        String word = "ate";
        questionOptimized(arr, word);

    }

}
