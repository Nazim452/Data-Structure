package PYQ.TCS;
// “Delivery Efficiency Problem”

// A delivery company records the number of packages delivered each day for N consecutive days.

// The manager wants to find the maximum number of packages delivered in any consecutive K days.

// Your task is to help the manager find:

// 👉 The maximum total deliveries in any continuous window of exactly K days.

// If K > N, print -1.

// 📌 Input Format

// First line → Integer N (number of days)

// Second line → N space-separated integers (deliveries per day)

// Third line → Integer K (window size)

// 📌 Output Format

// Print a single integer → maximum deliveries in any consecutive K days.
// If not possible → print -1.

// 🧪 Example 1

// Input:

// 7
// 2 5 1 8 2 9 1
// 3

// Output:

// 19
// 🧪 Example 2

// Input:

// 5
// 4 2 3 7 1
// 2

// Output:

// 10
// 🧪 Example 3

// Input:

// 4
// 5 3 2 6
// 5

// Output:

// -1

public class SlidingWindowType {
    static void question(int[] arr, int k) {

        int n = arr.length;
        int ans = 0;

        for (int i = 0; i <= n - k; i++) {

            int sum = 0;

            // I+k.... not j+k;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

    static void questionOptimizedSlidingWIndow(int[] arr, int k) {

        int n = arr.length;

        if (k > n) {
            System.out.println(-1);
            return;
        }

        int sum = 0;

        // Step 1: First window sum
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {

            // Add next element
            sum += arr[i];

            // Remove element leaving window
            sum -= arr[i - k];

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) {
         int[] arr = {2, 5, 1, 8, 2 ,9, 1};
           int k = 3;
           questionOptimizedSlidingWIndow(arr, k);

    }

}
