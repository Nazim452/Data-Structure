import java.util.Scanner;

public class Problem50 {

// Jeff has N cards.
// Each card has either 0 or 5 written on it.

// Jeff can pick some or all of the cards and arrange them in any order to make a number.

// The number:

// Must not have leading zeroes (except the number 0 itself)

// Must be divisible by 90

// Jeff wants to create the largest possible number using the cards.

// If it is not possible to form any number divisible by 90, print -1.

// Input Format

// An integer N (number of cards)

// N integers (0 or 5) — digits on the cards

// Output Format

// Print the largest number divisible by 90 that can be formed using the cards.
// If it is not possible, print -1.

// 🧠 What does divisible by 90 mean?

// A number is divisible by 90 if:

// Divisible by 9  AND  Divisible by 10

// Rule 1 — Divisible by 10

// The last digit must be 0 → so at least one 0 card is required

// Rule 2 — Divisible by 9

// The sum of digits must be divisible by 9

// Since digits are only 0 and 5:

// sum = 5 × (number of 5s)


// So:

// number of 5s must be a multiple of 9

// Example
// Input
// 4
// 5 0 5 0


// Digits → {5, 0, 5, 0}

// Number of 5s = 2
// 2 is not divisible by 9 → cannot use both 5s

// But we have at least one 0, so we can make:

// 0


// Which is divisible by 90

// So output:

// 0


// “No leading zero” means:

// The number must not start with the digit 0, unless the entire number is just 0.

// Let’s see with simple examples 👇

// ❌ Invalid (has leading zero)
// 0123
// 0050
// 00090


// These are wrong because the number starts with 0 but has other digits after it.

// ✅ Valid (no leading zero)
// 123
// 50
// 900


// These start with a non-zero digit, so they are valid.

// ✅ Special case
// 0


// This is allowed because it is a single digit.
// There is nothing “before” or “after” it, so it has no leading zero.



// Brute Force Approach (for understanding)

// Try all permutations of the digits, then:

// Check if the number has no leading zero

// Check if divisible by 90

// Keep the maximum valid number

// This is very slow and works only for small N.

static String best = "-1";
  static void permute(char[] arr, int l) {
        if (l == arr.length) {
            String s = new String(arr);
            if (isValid(s)) {
                if (best.equals("-1") || s.compareTo(best) > 0) {
                    best = s;
                }
            }
            return;
        }

        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1);
            swap(arr, l, i);
        }
    }

    static boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false; // no leading zero
        if (s.charAt(s.length() - 1) != '0') return false;    // divisible by 10

        int sum = 0;
        for (char c : s.toCharArray())
            sum += c - '0';

        return sum % 9 == 0;
    }

    static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String digits = "";
        for (int i = 0; i < n; i++)
            digits += sc.next();

        permute(digits.toCharArray(), 0);
        System.out.println(best);
    
}
}
