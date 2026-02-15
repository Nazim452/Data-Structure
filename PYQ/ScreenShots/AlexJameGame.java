import java.util.Arrays;
import java.util.Scanner;

public class AlexJameGame {
    // Alex and James compete in N rounds of a wrestling match.

    // For each round i:

    // If Alex wins the round, he gets Xi + Yi points

    // If James wins the round, he gets Xi points

    // After all N rounds, the wrestler with more total points is declared the
    // winner.

    // Alex is weak in mathematics and wants your help.

    // 👉 Your task is to determine the minimum number of rounds Alex must win so
    // that Alex is guaranteed to win the match, even if James wins all the
    // remaining rounds.

    // 🔹 Input Format

    // First line: integer N — number of rounds

    // Next N lines: two space-separated integers Xi Yi for each round

    // 🔹 Output Format

    // Print one integer — minimum number of rounds Alex must win

    // 🔹 Constraints

    // 1 ≤ N ≤ 10^5

    // 1 ≤ Xi, Yi ≤ 10^9

    // 🔄 Rewritten Test Cases (Corrected)
    // Example 1

    // Input

    // 4
    // 4 3
    // 7 5
    // 3 5
    // 4 4

    // Explanation

    // If Alex wins round 2:

    // Alex score = 7 + 5 = 12

    // If James wins all other rounds:

    // James score = 4 + 3 + 4 = 11

    // ✅ Alex still wins.

    // Output

    // 1

    // Example 2

    // Input

    // 3
    // 5 4
    // 5 4
    // 5 4

    // Explanation

    // If Alex wins 1 round:

    // Alex = 5 + 4 = 9

    // James = 5 + 5 = 10 ❌

    // If Alex wins 2 rounds:

    // Alex = 9 + 9 = 18

    // James = 5 ✅

    // Output

    // 2

    // Example 3 (Edge Case)

    // Input

    // 1
    // 10 1

    // Explanation

    // Alex must win the only round.

    // Output

    // 1

    // 🧠 Key Insight (Most Important)

    // Let’s analyze one round:

    // Winner Alex gains James gains
    // Alex Xi + Yi 0
    // James 0 Xi
    // 👉 Net advantage for Alex if he wins round i:
    // (Xi + Yi) - Xi = Yi

    // 💡 So Alex gains an advantage of Yi points by winning round i.

    // 🚀 Optimal Strategy (Greedy)

    // To minimize the number of wins, Alex should:

    // Win rounds with maximum Yi first

    // Because each Yi contributes directly to beating James.

    // 🧠 Algorithm (Optimized)

    // Compute totalX = sum of all Xi
    // → This is James’s score if he wins all rounds

    // Sort rounds by Yi in descending order

    // Start letting Alex win rounds with highest Yi

    // Maintain:

    // alexScore += Xi + Yi

    // jamesScore -= Xi

    // Stop when alexScore > jamesScore

    // ⏱ Complexity

    // Time: O(N log N)

    // Space: O(N)

    static class Round {
        long x, y;

        Round(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Round[] rounds = new Round[n];

        long jamesScore = 0;

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
               rounds[i] = new Round(x, y);
            jamesScore += x;
        }

        // Sort rounds by Y descending (max advantage first)
        // Arrays.sort(rounds, (a, b) -> Long.compare(b.y, a.y));

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (rounds[j].y < rounds[j + 1].y) {
                    Round temp = rounds[j];
                    rounds[j] = rounds[j + 1];
                    rounds[j + 1] = temp;
                }
            }
        }

        long alexScore = 0;

        for (int i = 0; i < n; i++) {
            alexScore += rounds[i].x + rounds[i].y;
            jamesScore -= rounds[i].x;

            if (alexScore > jamesScore) {
                System.out.println(i + 1);
                return;
            }
        }

    }
}
