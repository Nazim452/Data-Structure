package PYQ.TCS;

import java.util.*;

public class MagicPrime {

    static boolean isPrime(int num) {

        if(num <= 1) return false;

        for(int i=2;i*i<=num;i++){
            if(num % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 50;

        List<Integer> primes = new ArrayList<>();

        for(int i=2;i<=n;i++){
            if(isPrime(i))
                primes.add(i);
        }

        int sum = 0;

        for(int p : primes){

            sum += p;

            if(sum > n)
                break;

            if(sum >= 3 && isPrime(sum))
                System.out.print(sum + " ");
        }
    }
}