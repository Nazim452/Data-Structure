package Recursion;

public class Subsequence {
    static void printSubSeq(String s) {
        helper(s, 0, "");
    }

    static void helper(String s, int index, String curr) {

        // Base case: reached end of string
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }

        // 1️⃣ Include current character
        helper(s, index + 1, curr + s.charAt(index));

        // 2️⃣ Exclude current character
        helper(s, index + 1, curr);
    }

     public static void main(String[] args) {
        printSubSeq("abc");
    }
}
