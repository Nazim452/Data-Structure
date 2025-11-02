public class Rough {

    static void printArray(boolean[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int zeroneknapsackRecursively(int[] val, int[] wt, int cap, int n) {
        if (n == 0 || cap == 0)
            return 0;

        if (wt[n - 1] <= cap) {

            // Include
            int ans1 = val[n - 1] + zeroneknapsackRecursively(val, wt, cap - wt[n - 1], n - 1);

            // Exclude
            int ans2 = zeroneknapsackRecursively(val, wt, cap, n - 1);

            return Math.max(ans1, ans2);
        }

        else
            return zeroneknapsackRecursively(val, wt, cap, n - 1);
    }

    static int tabulation(int[] val, int[] wt, int cap) {
        int n = wt.length;
        int[][] dp = new int[n + 1][cap + 1];

        // Initializatio
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < cap + 1; j++) {

                int value = val[i - 1];
                int capacity = wt[i - 1];

                // Valide condtion
                // j - current capacity - hame fill current capcaity ke hisab se karna hai
                if (j >= capacity) {
                    // Include
                    int includeprofit = value + dp[i - 1][j - capacity];
                    // Exclude
                    int excludeprofit = dp[i - 1][j];

                    dp[i][j] = Math.max(includeprofit, excludeprofit);

                }

                // Invalid condition
                else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
       

        return dp[n][cap];
    }

    static boolean subsetTargetSummmm(int[] arr, int targetSum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        // for(int j = 0; j<dp[0].length; j++){dp[0][j] = false;}

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {

                // i - current value , j - target sum
                int val = arr[i - 1];

                // Valid

                if (val <= j) {

                    // Include or Exclude , agar dono me se kisi me true  aa jaye to true rakho
                    dp[i][j] = dp[i - 1][j - val] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        printArray(dp);

        return dp[n][targetSum];

    } 

    public static void main(String[] args) {
        // int[] wt = {2,5,1,3,4};
        // int[] val = {15,50,10,45,30};

        // // System.out.println(zeroneknapsackRecursively(val, wt, 8, val.length));
        // System.out.println("My Anser "+tabulation(val, wt, 7));

        int[] arr = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        System.out.println(subsetTargetSummmm(arr, targetSum));

    }
}
