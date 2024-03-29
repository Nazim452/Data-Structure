package Recursion;

public class Factorial {

    static int factorial(int n) {

        // base case
        if (n == 1 || n == 0) {

            return 1;
        }

        // smaller problem - recursive work

        int smallAns = factorial((n - 1));

        // self work

        int ans = n * smallAns;

        return ans;

    }

    // RUN TIME COMP - O(n)
    // SPACE COMP - 0(N)

    public static void main(String[] args) {
        System.out.println(factorial(4));

    }
}
