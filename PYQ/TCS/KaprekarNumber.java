package PYQ.TCS;
// Problem: Kaprekar Number
// 🧾 Problem Statement

// You are given a positive integer N.

// Your task is to determine whether N is a Kaprekar Number.

// 📘 Definition of Kaprekar Number

// A number N is called a Kaprekar number if:

// Compute the square of N → square = N × N

// Split the square into two parts (left part and right part).

// Add those two parts.

// If their sum equals the original number N, then N is a Kaprekar number.

// ⚠ Important Conditions

// The split must form two valid numbers.

// The right part can have leading zeros (like 01, 002, etc.).

// Neither part should be empty.

// If the right part becomes 0, it is allowed (but splitting must be valid).

// 📌 Example 1

// Input:

// 45

// Step 1:

// 45² = 2025

// Step 2: Split into two parts

// 20 and 25

// Step 3: Add them

// 20 + 25 = 45

// Since the sum equals the original number,

// Output:

// Yes
// 📌 Example 2

// Input:

// 9

// Step 1:

// 9² = 81

// Split:

// 8 and 1

// Add:

// 8 + 1 = 9

// Output:

// Yes
public class KaprekarNumber {
    static int digitCount(int n){
        if(n==0) return 0;

        int ans = 0;
        while (n>0) {
            ans++;
            n = n/10;

            
        }
        return ans;
    }
    static void question(int n){
        int square = n*n;
        int dCount = digitCount(square);

        String value = String.valueOf(square);
        String UpHalf = "", lowHalf =  "";
        for(int i = 0; i<dCount/2; i++){
            UpHalf+=value.charAt(i);


        }
        for(int i = dCount/2; i<dCount; i++){
            lowHalf+=value.charAt(i);
        }
        int Upper = Integer.parseInt(UpHalf);
        int lower = Integer.parseInt(lowHalf);
        System.out.println(Upper);
        System.out.println(lower);

        if(Upper+lower==n){
            System.out.println("Yes");

        }
        else{
            System.out.println("No");
        }

    }


     static void OptimiedBetterForAllTeztCase(int n){

        if(n == 1){
            System.out.println("Yes");
            return;
        }

        long square = (long)n * n;

        int digits = digitCount(n);

        long divisor = (long)Math.pow(10, digits);

        long right = square % divisor;
        long left = square / divisor;

        if(right != 0 && (left + right == n)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }



    public static void main(String[] args) {
        int n = 45;
        question(n);
        
    }
    
}
