package TCS.ActualPYQ;

public class PrimePposition {

    static boolean findPrime1(int a){
        for(int i =0; i<a; i++){
            if(a%i==0) return false;
        }
        return true;
    }
    public static int getPrimeAtPosition(int position) {
        // int count = 0;  // This keeps track of how many prime numbers we've found. 
        // If prime then increment the count

        int count = 0;
        int num = 2; // starting point of prime number -

        while (true) {
            if (isPrime(num)) {
                count++;
                if (count == position) {
                    return num;
                }
            }
            num++;
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        // ✅ If n has no factor from 2 to √n, then it has no factor at all. So it's prime.

        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }



    static void question(int a , int b){
        int temp1 = getPrimeAtPosition(a);
        int temp2 = getPrimeAtPosition(b);

        int ans = temp1*temp2-1;
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        question(a, b);
        
    }
}
