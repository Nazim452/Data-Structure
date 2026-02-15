
import java.util.*;

public class Divisibleby90 {
    // 🔷 Why Are We Dividing by 9?

// The number must be divisible by 90.

// A number is divisible by 90 if:

// 1️⃣ Divisible by 10

// → Must end with 0
// → So we need at least one 0

// 2️⃣ Divisible by 9

// → Sum of digits must be divisible by 9

// 🔷 Important Observation

// Digits allowed:

// 0 and 5 only


// Now ask yourself:

// What contributes to digit sum?

// 0 contributes nothing.

// 5 contributes 5.

// So if we use k number of 5s:

// Digit sum = 5 × k


// To be divisible by 9:

// 5k must be divisible by 9

// 🔷 Solve This Mathematically

// We need:

// 5k % 9 == 0


// Since 5 and 9 are co-prime (no common factor),

// This happens only when:

// k is multiple of 9


// So:

// k = 9, 18, 27, 36...

// 🔥 That’s Why We Do This
// int usableFives = (count5 / 9) * 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count0 = 0;
        int count5 = 0;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == 0)
                count0++;
            else if (val == 5)
                count5++;
        }

        if (count0 == 0) {
            System.out.println(-1);
            return;
        }

        int usableFives = (count5 / 9) * 9;

        if (usableFives == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < usableFives; i++)
            System.out.print(5);

        for (int i = 0; i < count0; i++)
            System.out.print(0);
    }
}
