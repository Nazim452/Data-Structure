package PYQ.TCS;
// STEP 1: What is the Operation Actually?

// You are given:

// N (length of string)

// String A (original string)

// String B (target string)

// You want to convert A → B.

// But you are allowed only ONE TYPE of operation:

// Operation:

// Choose any group of positions (subset of indices).

// Look at the characters at those positions.

// Find the smallest character among them (alphabetically).

// Replace ALL chosen positions with that smallest character.

// Important:
// You can only make characters smaller or equal, never bigger.

// Because you replace everything with the smallest one.

// ✅ STEP 2: Very Small Example (Super Easy)
// Example 1

// N = 3
// A = "cba"
// B = "aaa"

// Let’s see if possible.

// We want:

// c → a
// b → a
// a → a

// Operation:

// Choose indices {0,1,2}
// Characters = {c, b, a}
// Smallest = a

// Replace all → "aaa"

// Done in 1 operation.

// Answer = 1

// ✅ STEP 3: Impossible Case

// Example:

// N = 2
// A = "ab"
// B = "ba"

// Check position 0:

// a → b

// This means increasing a to b.

// But operation only makes characters smaller.

// So impossible.

// Answer = -1

// ✅ STEP 4: Now Let’s Understand the Confusing Example

// N = 4
// A = "abab"
// B = "abaa"

// Let’s write with index:

// Index	0	1	2	3
// A	a	b	a	b
// B	a	b	a	a

// We only need to change index 3:

// b → a

// Now operation rule:

// We must choose a subset.

// If we choose only index 3:
// Subset = {b}
// Smallest = b
// Replace → still b

// So nothing changes.

// ❌ That doesn’t help.

// So we need to include at least one 'a' in subset.

// Let’s choose indices {2,3}

// Subset = {a, b}
// Smallest = a

// Replace both with 'a'

// New string becomes:

// a b a a

// Which is exactly B.

// So 1 operation.

// Answer = 1

// ✅ STEP 5: Why We Must Check A[i] < B[i]

// Very important rule:

// If at any position:

// A[i] < B[i]

// It means you need to increase character.

// But operation never increases.

// So immediately return -1.

// ✅ STEP 6: One More Clear Example

// Example:

// N = 5
// A = "edcba"
// B = "aacba"

// Let’s compare:

// Index	A	B
// 0	e	a
// 1	d	a
// 2	c	c
// 3	b	b
// 4	a	a

// Only index 0 and 1 need change.

// If we choose subset {0,1}:

// Characters = {e, d}
// Smallest = d

// After replace → "ddcba"

// Still not correct.

// We need 'a'.

// So include index 4 too (because it has 'a').

// Choose subset {0,1,4}

// Characters = {e, d, a}
// Smallest = a

// Replace all → "aacba"

// Done in 1 operation.

// Answer = 1
import java.util.*;

public class StringConversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String A = sc.next();
        String B = sc.next();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int operations = 0;

        // Step 1: Feasibility Check
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Try converting from highest character to lowest
        for (char ch = 'z'; ch >= 'a'; ch--) {

            // Collect indices that need change
            List<Integer> indices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (a[i] == ch && a[i] != b[i]) {
                    indices.add(i);
                }
            }

            // If no such character, continue
            if (indices.size() == 0)
                continue;

            // Find smallest target character among those positions
            char minChar = 'z';
            for (int index : indices) {
                if (b[index] < minChar) {
                    minChar = b[index];
                }
            }

            // If interviewer asks:

            // Why are we taking minimum from B instead of A?

            // You can say:

            // Since our goal is to convert A into B, we must reduce characters only to
            // values that match the required target. Among all positions with the same
            // current character, we compute the minimum required target character from B.
            // This ensures that in one operation, all those positions move to the lowest
            // valid state without causing incorrect reductions.

            // Apply operation (replace all with minChar)
            for (int index : indices) {
                a[index] = minChar;
            }

            operations++;
        }

        // Step 3: Final Check
        String finalString = new String(a);

        if (finalString.equals(B)) {
            System.out.println(operations);
        } else {
            System.out.println(-1);
        }

        // Example Where Output = 2
        // A = "dcba"
        // B = "abba"

        // Step 1:
        // Fix d → a
        // Choose subset {0,3}
        // Replace → "acba"

        // Step 2:
        // Fix c → b
        // Choose subset {1,2}
        // Replace → "abba"

        // Answer = 2

        // ------------------------------------------------------------
        // ✅ Optimized
        // ------------------------------------------------------------

        // Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // String A = sc.next();
        // String B = sc.next();

        // int operations = 0;

        // char[] a = A.toCharArray();
        // char[] b = B.toCharArray();

        // // Feasibility check
        // for (int i = 0; i < n; i++) {
        // if (a[i] < b[i]) {
        // System.out.println(-1);
        // return;
        // }
        // }

        // for (char ch = 'z'; ch >= 'a'; ch--) {

        // List<Integer> list = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        // if (a[i] == ch && b[i] != ch) {
        // list.add(i);
        // }
        // }

        // if (!list.isEmpty()) {

        // char minChar = 'z';

        // for (int idx : list) {
        // minChar = (char) Math.min(minChar, b[idx]);
        // }

        // for (int idx : list) {
        // a[idx] = minChar;
        // }

        // operations++;
        // }
        // }

        // System.out.println(operations);
    }
}

// The Core Idea

// The algorithm processes characters from 'z' to 'a', meaning:

// First fix all 'z'

// Then fix all 'y'

// Then fix all 'x'

// …

// Finally fix 'a'

// So at each iteration:

// for (char ch = 'z'; ch >= 'a'; ch--)

// We are saying:

// 👉 “Now I will try to fix only character ch.”

// That is the whole strategy.

// ❗ What Happens If You Remove a[i] == ch?

// If you only write:

// if (a[i] != b[i])

// Then you will collect all mismatched indices at once.

// That completely breaks the logic.

// Why?

// Because the operation rule says:

// You must choose a subset and replace ALL of them with the smallest character
// in that subset.

// If you mix different characters in the same operation,
// you may accidentally reduce characters that should not be reduced yet.

// 🧠 Example Where It Breaks

// Consider:

// A = "dcba"
// B = "abba"

// We must do:

// Step 1: d → a
// Step 2: c → b

// Correct answer = 2 operations.

// ❌ If you use only a[i] != b[i]

// Initially:

// A = d c b a
// B = a b b a

// Mismatched indices:

// 0 (d → a)
// 1 (c → b)

// So your list will contain:

// {0, 1}

// Now:

// Characters at these indices = {d, c}
// Smallest = c

// After operation:

// c c b a

// But now index 0 became c,
// and we still need a.

// You created an unnecessary extra reduction step.

// Now you'll need more operations.

// So the greedy order breaks.

// ✅ Why a[i] == ch Is Necessary

// Because we want:

// 👉 Fix ONE character type at a time.

// When ch = 'd', we ONLY collect indices where:

// a[i] == 'd' AND a[i] != b[i]

// So we only fix all 'd' that need change.

// Then move to 'c'.

// Then to 'b'.

// This guarantees:

// Larger characters are handled first

// We never disturb already processed characters

// We avoid accidental over-reduction

// 🎯 Real Reason in One Line

// a[i] == ch ensures that:

// In one iteration, we only process one specific character group.

// Without it:

// You lose control of the greedy structure.

// ________________________________________________________________

// ________________________________________________________________

// Why Smallest From B?

// Let’s understand using logic.

// Suppose:

// A = edcba
// B = aacba

// We are at:

// ch = 'e'

// Indices needing change:

// 0 (e → a)

// Now question:

// What should we reduce 'e' to?

// If we choose smallest from A subset:

// Subset contains only 'e'.

// Smallest = 'e'

// Nothing changes.

// ❌ That won’t help.

// 💡 The Trick

// To reduce 'e' to 'a', we must include at least one 'a' in the subset.

// Where do we know 'a' must exist?

// In B.

// Because B tells us the final target.

// So we look at:

// b[index]

// And find the smallest target character required.
