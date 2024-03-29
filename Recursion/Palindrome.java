package Recursion;

public class Palindrome {
    // reverse of string

    static String reverse(String s, int index) {
        if (index == s.length())
            return " ";

        String smallAns = reverse(s, index + 1);

        // self work

        return smallAns + s.charAt(index);
    }

    // CHECK PALINDROME OR NOT withoout reverse

    static boolean checkPalindrome(String s, int l, int r) {
        if (l >= r)
            return true;

        return (s.charAt(l) == s.charAt(r)) && checkPalindrome(s, l + 1, r - 1);
    }

    // CHECK PALINDROME OR NOT

    static String revers_Palindrome(String s, int index) {
        if (index == s.length())
            return " ";

        String smallAns = reverse(s, index + 1);

        // self work

        return smallAns + s.charAt(index);
    }

    public static void main(String[] args) {

    }
}
