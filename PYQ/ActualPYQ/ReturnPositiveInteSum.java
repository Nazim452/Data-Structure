package PYQ.ActualPYQ;

import java.util.*;

public class ReturnPositiveInteSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Set<Integer> sums = new HashSet<>();

        // Generate all 3-element sums
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    sums.add(A[i] + A[j] + A[k]);
                }
            }
        }

        // Minimum possible sum
        int minSum = Integer.MAX_VALUE;
        for (int val : sums) {
            minSum = Math.min(minSum, val);
        }

        System.out.println(sums);
      

        // Find smallest missing positive integer
        int candidate = minSum;
        while (true) {
            if (!sums.contains(candidate)) {
                System.out.println(candidate);
                return;
            }
            candidate++;
        }


        // M-II (Optimized)__________________

        // Arrays.sort(A);
        // Set<Integer> sums = new HashSet<>();

        // for (int i = 0; i < N; i++) {
        //     for (int j = i + 1; j < N; j++) {
        //         for (int k = j + 1; k < N; k++) {
        //             sums.add(A[i] + A[j] + A[k]);
        //         }
        //     }
        // }

        // int candidate = A[0] + A[1] + A[2];

        // while (sums.contains(candidate)) {
        //     candidate++;
        // }

        // System.out.println(candidate);










        // Optimized - 3 O(n^2)______________________________



        // Arrays.sort(A);
        // Set<Integer> sums = new HashSet<>();

        // for (int i = 0; i < N - 2; i++) {
        //     int left = i + 1;
        //     int right = N - 1;

        //     while (left < right) {
        //         int sum = A[i] + A[left] + A[right];
        //         sums.add(sum);

        //         // Move both pointers to cover all pairs
        //         left++;
        //         right--;
        //     }
        // }

        // int minSum = A[0] + A[1] + A[2];
        // while (sums.contains(minSum)) {
        //     minSum++;
        // }

        // System.out.println(minSum);
    }
}
