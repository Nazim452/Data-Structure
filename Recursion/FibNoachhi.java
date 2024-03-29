package Recursion;

public class FibNoachhi {

    static int fib(int n) {
        // base condition

        if (n == 0 || n == 1) {
            return n;
        }

        // recursive work - smalller prob

        int prev = fib(n - 1);
        int prevPrev = fib(n - 2);

        // self work

        return prev + prevPrev;
    }

    // RUN TIME COMP - O(2^K)

    // SPACE COMP - O(N)

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            System.out.print(fib(i)+" ");

        }
    }
}
