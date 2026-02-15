// What is a 248 number?

// A number is called a 248 number if it satisfies all three rules:

// 1️⃣ It contains digit 2
// 2️⃣ It contains digit 4
// 3️⃣ It contains digit 8
// 4️⃣ The number of 2s = number of 4s = number of 8s

// So:

// count(2) = count(4) = count(8) ≥ 1


// Only digits allowed → 2, 4, 8



// ❌ Examples (Not valid)
// Number	Why invalid
// 24	      has no 8 ❌
// 2488	      2=1, 4=1, 8=2 (not equal) ❌
// 2284	      2=2, 4=1, 8=1 ❌
// 12348	  contains digits other than 2,4,8 ❌



// ✅ Examples (Valid 248 numbers)
// Number	Count of 2	Count of 4	Count of 8	Valid?
// 248	         1	         1	         1	        ✅
// 284	         1	         1	         1	        ✅
// 824	         1	         1	         1	        ✅
// 248248	      2	      2	      2	                  ✅
// 🧩 What is the question asking?

// You are given a number N.

// You must count:

// How many 248 numbers exist between 1 and N

// Example
// N = 300


// Now list all valid 248 numbers ≤ 300

// The only 3-digit numbers using exactly one 2, one 4, and one 8 are:

// 248
// 284
// 428
// 482
// 824
// 842


// But we only want ≤ 300

// So valid ones are:

// 248
// 284


// Answer = 2


// You are given an integer N.
// You must count how many 248 numbers lie in the interval [1, N].

// Since the answer can be very large, print it modulo 1000000007.

// Key Observation

// A 248 number must:

// Use only digits {2,4,8}

// Have length divisible by 3

// And each of {2,4,8} must appear exactly k times

// For length = 3k, the number of valid permutations is:

// But we only count those ≤ N, so we must use Digit DP.

import java.util.Scanner;

public class Problem248 {

    static boolean bruteforce(long num){
         
                 int c2 = 0, c4 = 0, c8 = 0;

        while (num > 0) {
            int d = (int)(num % 10);

            if (d == 2) c2++;
            else if (d == 4) c4++;
            else if (d == 8) c8++;
            else return false;   // other digit found

            num /= 10;
        }

        return c2 >= 1 && c2 == c4 && c4 == c8;


    }
    public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        int count = 0;
        for (long i = 1; i <= N; i++) {
            if (bruteforce(i)) count++;
        }

        System.out.println(count);
        
    }
    
}
