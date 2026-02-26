
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
        // 5 × count5 % 9 == 0

        // Now here comes the smart thinking.

        // Since 5 and 9 are co-prime (they don’t share factors),

        // For 5 × count5 to be divisible by 9,
        // 👉 count5 must be divisible by 9.

        // 🔥 Smart Thinking Shortcut

        // Instead of checking repeatedly, we directly make:

        // count5 = largest multiple of 9 ≤ count5

        // That is exactly what:

        // (count5 / 9) * 9

        // does.

        // 💡 Why This Works?

        // Integer division:

        // If count5 = 17

        // 17 / 9 = 1 (integer division)
        // 1 * 9 = 9

        // So usable5 = 9

        // We removed extra 8 fives because they break divisibility by 9.

        // If count5 = 25

        // 25 / 9 = 2
        // 2 * 9 = 18

        // Largest valid block of 9s.

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
