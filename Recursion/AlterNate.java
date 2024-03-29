package Recursion;

public class AlterNate {

    // given a number n . find sum of natural no till n but with alternatre sign

    // given series = 1-2+3-4+5......________________________________
    // input n = 10 || output = -5
    // input n = 3 output = 2

    static int alternateSeriesSum(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 2 == 0) {
            return alternateSeriesSum(n - 1) - n;

        } else {
            return alternateSeriesSum(n - 1) + n;
        }
    }

    public static void main(String[] args) {
        System.out.println(alternateSeriesSum(10));

    }

}
