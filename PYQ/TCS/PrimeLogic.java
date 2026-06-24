package PYQ.TCS;
// Problem Statement

// Write a program that performs the following steps:

// Take two positive integers m and n as input.

// Find the m-th prime number and the n-th prime number.

// For each of these two prime numbers:

// Calculate the sum of its digits.

// If the result has more than one digit, repeat the digit-sum process until the result becomes a single-digit number (i.e., less than 10).

// Let the final single-digit results be:

// m1 → result derived from the m-th prime

// n1 → result derived from the n-th prime

// Finally, print the value of:

// m * m1
// Example

// Input:

// m = 5
// n = 6

// Explanation:

// 5th prime number = 11
// Digit sum → 1 + 1 = 2
// So, m1 = 2

// 6th prime number = 13
// Digit sum → 1 + 3 = 4
// So, n1 = 4

// Final Output:

// 5 * 2 = 10

public class PrimeLogic {

    // Efficient Prime Check

    // let numb = 6, factor - 1,2,3 , half o fthe number , we have to check wih only
    // facotr

    // Why i += 2 Instead of i++

    // You asked a very good question.

    // Important Observation

    // After checking:

    // num % 2 == 0

    // we already know the number is not divisible by 2.

    // So all even numbers can be skipped.
    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // Find nth prime number
    static int findNthPrime(int n) {
        int count = 0;
        int num = 2; // starting point of prime number -

        while (true) {
            if (isPrime(num)) {
                count++;
                if (count == n) {
                    return num;
                }
            }
            num++;
        }
    }

    // Reduce number to single digit (digital root logic)
    static int reduceToSingleDigit(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    static void solve(int m, int n) {

        int mthPrime = findNthPrime(m);
        int nthPrime = findNthPrime(n);

        int m1 = reduceToSingleDigit(mthPrime);
        int n1 = reduceToSingleDigit(nthPrime);

        System.out.println(m * m1);
    }


   
    public static void main(String[] args) {
        // int m = 5, n = 6;
        // solve(m, n);

        
    }
}