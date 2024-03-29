package Recursion;

public class PalindromeRec {
    static boolean palindrome2(int[] arr, int leftIndx, int rightIndx) {
        if (leftIndx >= rightIndx)
            return true;

        return (arr[leftIndx] == arr[rightIndx] && palindrome2(arr, leftIndx + 1, rightIndx - 1));
    }

    static boolean palindrome(String s, int l, int r) {
        if (l >= r)
            return true;

        return (s.charAt(l) == s.charAt(r)) && palindrome(s, l + 1, r - 1);

    }

    public static void main(String[] args) {
        String s="dadf";
        System.out.println(palindrome(s, 0, s.length()-1));
        int[]arr = { 1,2,2,1 };
 
        System.out.println(palindrome2(arr, 0, arr.length-1));
     

    }
}
