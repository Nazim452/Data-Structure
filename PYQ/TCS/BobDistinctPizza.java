package PYQ.TCS;

import java.util.*;
// Problem: Bob’s Pizza Diet

// Alice ordered N pizzas arranged in a sequence.

// Each pizza has a flavor number.

// There are at most K different flav
// ors possible.

// The i-th pizza has flavor A[i] where 1 ≤ A[i] ≤ K.

// Bob is on a diet and can eat pizzas containing at most K-1 distinct flavors.

// He wants to eat maximum number of pizzas in a contiguous sequence such that:

// The selected pizzas form a continuous subarray.

// The number of distinct flavors in that subarray is ≤ K-1.

// 📌 Input Format

// First line: Two integers N and K

// Second line: N space-separated integers representing flavors

// 📌 Output Format

// Print a single integer — the maximum number of pizzas Bob can eat.

// 📌 Constraints

// 1 ≤ N ≤ 10^5

// 1 ≤ K ≤ 10^5

// 1 ≤ A[i] ≤ K

// 🔎 Important Observation

// Bob can eat at most K-1 distinct flavors.

// So this becomes:

// Find the longest subarray with at most (K-1) distinct elements

// This is a classic Sliding Window problem.

// 🧪 Test Cases
// ✅ Test Case 1

// Input:

// 9 4
// 6 5 1 2 3 2 1 4 5

// Here K = 4
// Bob can eat at most 3 distinct flavors.

// Longest subarray with ≤ 3 distinct flavors:

// 1 2 3 2 1

// Length = 5

// Output:

// 5
// ✅ Test Case 2

// Input:

// 7 3
// 1 2 1 2 3 3 4

// Bob can eat at most 2 distinct flavors.

// Longest valid subarray:

// 1 2 1 2

// Length = 4

// Output:

// 4
// ✅ Test Case 3

// Input:

// 5 2
// 1 1 1 1 1

// Bob can eat at most 1 distinct flavor.

// Entire array valid.

// Output:

// 5
// ✅ Test Case 4

// Input:

// 6 3
// 1 2 3 4 5 6

// Bob can eat at most 2 distinct flavors.

// Longest valid subarray:
// Any two adjacent elements.

// Output:

// 2
public class BobDistinctPizza {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int allowedDistinct = K - 1;

        int maxLength = 0;
        int bestStart = 0;
        int bestEnd = 0;

        // Brute Force
        for (int i = 0; i < N; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < N; j++) {

                set.add(arr[j]);

                if (set.size() > allowedDistinct) {
                    break;
                }

                int currentSize = j-i+1;

                if (currentSize > maxLength) {
                    maxLength = currentSize;
                    bestStart = i;
                    bestEnd = j;
                }
            }
        }

        // Print maximum length
        System.out.println("Maximum Length: " + maxLength);

        // Print actual subarray
        System.out.print("Subarray: ");
        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}