package Recursion;

public class EucLidGCD {

    static void gcdIterative(int x,int y ) {
        
        int gcd = 1;

        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }

        }
        System.out.println(gcd);
    }

    // GCD USING EUCLIDS ALGORITHM
    // GCD(X,Y) = GCD(Y, X%Y) & GCD(X,0) = X

    static int rGCD(int x, int y) {

        if (y == 0) {
            return x; // see above 2nd approach of comment
        }
        return rGCD(y, x % y);
    }

    // GCD USING RECURWION - LONG DIV_______________________________

    static int iGCD(int x, int y) {
        while (x % y != 0) {

            int rem = x % y;

            x = y;
            y = rem;

        }
        return y;
    }



    // Euclid  - Iterative


    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {

       gcdIterative(15, 24);;

        // System.out.println(rGCD(15, 24));

    }
}
