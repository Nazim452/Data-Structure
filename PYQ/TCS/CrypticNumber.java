package PYQ.TCS;

// Cryptic Number — Rewritten Problem Statement (Clear Version)

// You are given two integers L and R, representing a range of numbers inclusive.

// Your task is to find all numbers within this range that satisfy all the following conditions. Such numbers are called Cryptic Numbers.

// A number is considered a Cryptic Number if:

// 1️⃣ The number is divisible by 7
// 2️⃣ The number is NOT divisible by 5
// 3️⃣ The number is NOT a palindrome
// 4️⃣ The number does NOT contain any repeated digits

// Example:

// 123 → valid (all digits unique)

// 121 → invalid (digit 1 repeats)

// Input Format

// A single line input containing two space-separated integers:

// L R

// Where:

// L → starting number of the range

// R → ending number of the range

// The range is inclusive, meaning you must check every number from L to R.

// Output Format

// Print all Cryptic Numbers in increasing order separated by a single space.

// If no such number exists, print:

// -1
// Sample Test Cases
// Test Case 1

// Input

// 10 50

// Output

// 14 21 28 42 49
// Test Case 2

// Input

// 70 80

// Output

// -1
// Test Case 3

// Input

// 100 150

// Output

// 126 147
// Expected Approach (Conceptual)

// For every number num in the range [L, R]:

// Check:

// 1️⃣ num % 7 == 0
// 2️⃣ num % 5 != 0
// 3️⃣ num is not palindrome
// 4️⃣ digits of num are unique

// If all conditions are satisfied → print the number.

public class CrypticNumber {
    static boolean checkPalindrom(int n){
        int originalNum = n;
        int rev = 0;

        while (n>0) {
            int ld = n%10;
            rev = rev*10+ld;
            n = n/10;
            
        }

        return rev==originalNum;
    }
   
    static boolean CheckReptative(int n){
      boolean[] flag = new boolean[10];

      while (n>0) {
        int ld = n%10;
        if(flag[ld]==true) return false;
        flag[ld] = true;
        n = n/10;
      }
      return true;
    }
    static void question(int n1 , int n2){
        boolean found = false;
        for(int i = n1; i<=n2; i++){

            if(((i%7==0 )&&( i%5!=0))){

                if(!checkPalindrom(i) && CheckReptative(i)){
                found = true;
                    System.out.println(i);
                }

            }

        }

        if(!found) System.out.println(-1);
    }
    public static void main(String[] args) {
        int n1 = 100;
        int n2  = 150;
        // int n1 = 10;
        // int n2  = 50;
        question(n1, n2);
        
    }
    
}
