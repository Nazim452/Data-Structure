package Recursion;

public class MultiplyKtimes {

    // GIVEN A NUMBER AND A VLAUE K , PRINT K MULTIPLES OG NUM

    static void multiples(int num, int k) {
        if (k == 1) {
            System.out.println(num);
            return;

        }
        // recursive work

        multiples(num, k - 1);

        // self work
        System.out.println(num * k);

        // t c & s c = O(k) bcz tc depend on k vlaue

    }

    public static void main(String[] args) {
        multiples(15, 10);

    }
}
