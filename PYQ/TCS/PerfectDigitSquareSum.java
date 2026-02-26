package PYQ.TCS;
// We are given an integer N.

// We must find the smallest N-digit number such that:

// Condition 1:

// The number must NOT contain digit 0

// Allowed digits:

// 1,2,3,4,5,6,7,8,9
// Condition 2:

// The sum of the squares of its digits must be a perfect square

// Perfect square means:

// 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, ...

// Example:
// If number = 122

// Digits:

// 1,2,2

// Square of each digit:

// 2^2 + 1^2 + 2^2 = 9

// 9 is a perfect square (3²)

// So valid.

// Condition 3:

// Among all valid N-digit numbers,
// return the smallest one numerically.

// ✅ Step 2: Understand Test Cases Clearly
// 🔹 Case 1: Input = 3

// We need smallest 3-digit number (no zero).

// Smallest 3-digit number without 0:

// 111

// Check:

// 1² + 1² + 1²
// = 1 + 1 + 1
// = 3

// 3 is NOT a perfect square ❌

// Next number:

// 112

// 1² + 1² + 2²
// = 1 + 1 + 4
// = 6 ❌

// Next:

// 113

// 1 + 1 + 9 = 11 ❌

// Next:

// 114

// 1 + 1 + 16 = 18 ❌

// Next:

// 115

// 1 + 1 + 25 = 27 ❌

// Next:

// 121

// 1 + 4 + 1 = 6 ❌

// Eventually we reach:

// 212

// 2² + 1² + 2²
// = 4 + 1 + 4
// = 9

// 9 = 3² ✔

// So valid.

// Now question:

// Is there any smaller valid 3-digit number?

// We already checked all before 212 → none valid.

// So answer = 212

// 🔹 Case 2: Input = 4

// Try smallest 4-digit without zero:

// 1111

// 1²+1²+1²+1²
// = 4

// 4 is perfect square (2²)

// So immediately valid.

// Since it is smallest 4-digit number possible → answer = 1111

// No smaller exists.
public class PerfectDigitSquareSum {

    // For more info look at notebook>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static boolean isPerfectSquare(int x) {
        int r = (int)Math.sqrt(x);
        return r * r == x;
    }

  
    public static String smallestNumber(int N) {

        for (int k = 0; k <= N; k++) {

            int sum = N + 3 * k;

            if (isPerfectSquare(sum)) {

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < N - k; i++)
                    sb.append('1');

                for (int i = 0; i < k; i++)
                    sb.append('2');

                return sb.toString();
            }
        }

        return "-1";
    }


    public static void main(String[] args) {
        
    }


}