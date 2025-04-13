package TCS.Array;

import java.util.HashMap;

// OPTIMIZED APPROACH REMAINING

public class FindSubArrWithTargetSum {

    static void findSubArray(int[] arr, int targetSum) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == targetSum) {
                    // Print the targeted subArray

                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                }

            }

        }
    }

    // 6th Iteration (i = 5):

    // sum = sum + arr[5] = 4 + 3 = 7
    // Check if sum == targetSum: Yes
    // Print the subarray: for(int st = 0; st <= 5; st++): prints 3 4 -7 1 3 3
    // Check if map.containsKey(7 - 7) (i.e., map.containsKey(0)): Yes
    // start = map.get(0) + 1 = 2 + 1 = 3
    // Print subarray: for(int j = 3; j <= 5; j++): prints 1 3 3
    // Update map: map.put(7, 5) → map = {3=0, 7=5, 0=2, 1=3, 4=4}

    static void findSubArrayOptimizedForAll(int[] arr, int targetSum) {
        int n = arr.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize the map with base case
        // map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == targetSum) {
                for (int st = 0; st <= i; st++) {
                    System.out.print(arr[st] + " ");
                }
                System.out.println();

            }

            // Check if there exists a prefix sum that forms a subarray with the target sum
            if (map.containsKey(sum - targetSum)) {
                int start = map.get(sum - targetSum) + 1;
                int end = i;

                // Print the subarray with the target sum
                for (int j = start; j <= end; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }

            // Store the current cumulative sum with its index
            map.put(sum, i);
        }
    }

    static void subArraySumLoop(int[] arr, int k) {
        int st = 0, end = 1, sum = arr[0], len = arr.length;

        while (end <= len) {
            while (sum > k) {
                sum = sum - arr[st];
                st++;
            }

            if (sum == k) {
                for (int i = st; i < end; i++) {
                    System.out.print(arr[i] + " ");

                }
                System.out.println();
            }
            if (end < len)
                sum = sum + arr[end];

            end++;
        }
    }

    static void subarrayPrintNazim(int[] arr, int tar) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum - tar == 0) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }

            if (map.containsKey(currSum - tar)) {
                int k = map.get(currSum - tar) + 1;

                for (int l = k; l <= i; l++) {
                    System.out.print(arr[l] + " ");

                }
                System.out.println();

            }

            map.put(currSum, i);
        }
    }

    static void practice(int[] arr, int tar) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == tar) {
                for (int st = 0; st <=i; st++) {
                    System.out.print(arr[st] + " ");
                }
                System.out.println();
            }

            if (map.containsKey(sum - tar)) {
                int st = map.get(sum - tar) + 1;
                int end = i;

                for (int j = st; j <= end; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }

            map.put(sum, i);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int targetSum = 7;
        // int[] arr = { 10,2,4,7 };
        // int targetSum = 13;

        practice(arr, targetSum);

        // if targetSum =7  then OUTPUT - [3,4] , [3,4,-7,1,3,3] , [1,3,3] , [3,3,1];

    }
}