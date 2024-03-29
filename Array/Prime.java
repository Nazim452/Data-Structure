package Array;

public class Prime {
    static boolean isPrime(int n) {
        // if(n==0||n==1) return;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;

        }
        return true;
    }

    static void rangePrime(int n1,int n2) {
        for (int i = n1; i <= n2; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        // System.out.println(isPrime(6));

        rangePrime(5,12);
        
    }
}
