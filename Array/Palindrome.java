package Array;

public class Palindrome {
    static boolean isPalindrome(int num) {
        int palindrome = num;
        int rev = 0;
        while (num != 0) {
            int lasdigit = num % 10;
            rev = rev * 10 + lasdigit;
            num = num / 10;

        }
        if (palindrome == rev)
            return true;
        return false;

    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
