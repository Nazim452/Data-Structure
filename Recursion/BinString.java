package Recursion;

public class BinString {

    static void binaryStirng(int n, int lastPlace, String ans) {
        if (n == 0) {
            System.out.println(ans);

            return;
        }
        binaryStirng(n - 1, 0, ans + "0");
        if (lastPlace !=1) {
            binaryStirng(n - 1, 1, ans + "1");
        }

    }

    public static void main(String[] args) {
        binaryStirng(3, 0, " ");

    }
}
