package PYQ.Propel;
// Problem 1: Split String Into THREE Valid Dictionary Words
// Problem Statement

import java.util.HashSet;

// Have the function ArrayChallenge(strArr) read an array of strings which contains:

// strArr[0]: a continuous string

// strArr[1]: a comma-separated dictionary of words

// Determine whether the string can be split into exactly three words, such that all three words exist in the dictionary.

// Return the three words separated by commas.
// If not possible, return not possible.

// There will be only one valid way to split the string.

// Example 1

// Input

// ["applebananacat", "apple,banana,cat,dog,pen"]


// Output

// apple,banana,cat

// Example 2

// Input

// ["helloworldcode", "hello,world,java,python"]


// Output

// not possible

// DSA Skills Tested

// Nested substring splitting

// HashSet lookup

// String indexing

// Time complexity awareness
public class q5 {
    static String ArrayChallenge(String[] strArr) {

        String s = strArr[0];

        // Required variable name
        String[] varFiltersCg = strArr[1].split(",");

        HashSet<String> set = new HashSet<>();

        // Trim dictionary words to avoid space issues
        for (String word : varFiltersCg) {
            set.add(word.trim());
        }

        int n = s.length();

        // Try all ways to split into 3 parts
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                String first = s.substring(0, i);
                String second = s.substring(i, j);
                String third = s.substring(j);

                if (set.contains(first) && set.contains(second) && set.contains(third)) {
                    return first + "," + second + "," + third;
                }
            }
        }

        return "not possible";
    }
    public static void main(String[] args) {
        String[] arr = {"applebananacat", "apple,banana,cat,dog,pen"};
        System.out.println(ArrayChallenge(arr));

    }
    
}
