package TCS.Array;

public class SlidingWindw {

    static int[] slidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int l = 0;

        for (int i = 0; i < n - k + 1; i++) {

            int max = Integer.MIN_VALUE;

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }

            ans[l] = max;
            l++;

        }

        return ans;
    }

       public static void main(String[] args) {
        int[] a = { 2, 4, 7, 1, 6, 3 };
        int k = 3;
        // Max  [2,4,7] = 7
        // [4,7,1] = 7
        // [7,1,6] = 7
        // [1,6,3]= 6

        // Output - [7,7,7,6]

        int[] ans = slidingWindow(a, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
