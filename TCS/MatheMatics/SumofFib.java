package TCS.MatheMatics;

public class SumofFib {

    static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        // Fib series - 1 1 2 3 5 8.........
        // Input , n = 5 ,
        // O/P = 7
        int  n  = 5;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum+=fib(i);

            // System.out.print(fib(i)+" ");

        }
        System.out.println(sum);


    }

}
