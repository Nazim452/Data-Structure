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

public class Problem248Optimized{

  static final long MOD = 1000000007;
    static String N;
    static Long[][][][][][] dp;

    static long solve(int pos, int c2, int c4, int c8, boolean tight, boolean started) {
        if (pos == N.length()) {
            if (started && c2 == c4 && c4 == c8 && c2 >= 1) return 1;
            return 0;
        }

        if (!tight && started && dp[pos][c2][c4][c8][0][1] != null)
            return dp[pos][c2][c4][c8][0][1];

        if (!tight && !started && dp[pos][c2][c4][c8][0][0] != null)
            return dp[pos][c2][c4][c8][0][0];

        long res = 0;
        int limit = tight ? N.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean ntight = tight && (d == limit);
            boolean nstart = started || d != 0;

            int nc2 = c2, nc4 = c4, nc8 = c8;

            if (nstart) {
                if (d == 2) nc2++;
                else if (d == 4) nc4++;
                else if (d == 8) nc8++;
                else continue;   // only {2,4,8} allowed
            }

            res = (res + solve(pos + 1, nc2, nc4, nc8, ntight, nstart)) % MOD;
        }

        if (!tight) {
            if (started) dp[pos][c2][c4][c8][0][1] = res;
            else dp[pos][c2][c4][c8][0][0] = res;
        }

        return res;
    }

    


       public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.next();

        int len = N.length();
        dp = new Long[len + 1][20][20][20][2][2];

        System.out.println(solve(0, 0, 0, 0, true, false));
        
    }
    
}
