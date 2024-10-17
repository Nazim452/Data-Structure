package Array;

public class hcfLCM {

    static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }

        return gcd;
    }

    static int lcm(int x, int y) {

        // Method 1 - a*b= gcd*lcm
        int lcm = 1;
        int max = Math.max(x, y);
        for (int i = max; i < x * y; i += max) {
            if (i % x == 0 && i % y == 0) {
                lcm = i;
                break;
            }

        }
        return lcm;

    }

    public static void main(String[] args) {

        // System.out.println(gcd(14, 8));
        // System.out.println(lcm(14, 8));

        Long num1 = 10L;
        Long num2 = -10L;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

    }
}
