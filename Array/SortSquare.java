package Array;

public class SortSquare {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] sortSquare(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int[] ans = new int[n];
        int k = 0;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k++] = arr[left] * arr[left];
                left++;
            } else {
                ans[k++] = arr[right] * arr[right];
                right--;
            }
        }
        return ans;
    }

    static void solutions(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // Arrays.sort(arr, Collections.reverseOrder());
        printArray(arr);
    }

    // Q12. Squares of a Sorted Array
    // Given an integer array nums sorted in nondecreasing order, return an array of
    // the squares of
    // each number sorted in non-decreasing order.
    // Example 1:
    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    // Explanation: After squaring, the array becomes
    // [16,1,0,9,100].
    // After sorting, it becomes [0,1,9,16,100].
    // Example 2:
    // Input: nums = [-7,-3,2,3,11]
    // Output: [4,9,9,49,121]

    static void question(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int left = 0, right = n - 1;
        int k = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                ans[k] = leftSquare;
                left++;
            } else {
                ans[k] = rightSquare;
                right--;
            }
            k--;
        }

        printArray(ans);
    }

    public static void main(String[] args) {
        // int[] arr = { -10, -5, -2, 1, 4, 9 };
        int[] arr = { -4, -1, 0, 3, 10 };

        int[] ans = sortSquare(arr);
        // printArray(ans);

        question(arr);

    }

}
