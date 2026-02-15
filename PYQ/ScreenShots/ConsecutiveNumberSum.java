import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumberSum {
    static void question(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += j;

                if (sum == n) {
                    List<Integer> seq = new ArrayList<>();

                    for (int k = i; k <= j; k++) {
                        seq.add(k);
                    }
                    result.add(seq);
                }
                if (sum > n)
                    break;

            }
        }

        // -------- BRUTE FORCE SORT BY SIZE (Bubble Sort) --------
        int m = result.size();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (result.get(j).size() > result.get(j + 1).size()) {
                    List<Integer> temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                }
            }
        }
        // --------------------------------------------------------

        // Print result
        for (List<Integer> list : result) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        System.out.println(result.size());
    }

    public static void main(String[] args) {
        question(15);

        // My O/p -

        // 1 2 3 4 5 - consecutive number that make 20
        // 4 5 6
        // 7 8
        // 3

        // Need -

        // 7 8 // smaaller size
        // 4 5 6
        // 1 2 3 4 5
        // 3

        // Where your code fails ❌ (Important)
        // ❌ 1. Output order is WRONG (violates problem rules)

        // The problem clearly states:

        // The number of elements in
        // 𝑀
        // 𝑖
        // M
        // i
        // ​

        // is less than
        // 𝑀
        // 𝑖
        // +
        // 1
        // M
        // i+1
        // ​

        // .
        // Thus, sets must be printed in increasing order of size.

        // But your code prints sets in this order:

        // Smaller starting number first

        // Larger starting number later

        // Example for n = 15

        // Your output:

        // 1 2 3 4 5 (5 elements)
        // 4 5 6 (3 elements)
        // 7 8 (2 elements)
        // 3

        // Expected output:

        // 7 8
        // 4 5 6
        // 1 2 3 4 5
        // 3

    }

}
