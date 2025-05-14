package TCS.ActualPYQ;

public class SubSetTargetSumDP {

    public static boolean findSubset(int[] nums, int index, int target, Boolean[][] dp) {
        // Base conditions
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        // If already computed
        if (dp[index][target] != null) return dp[index][target];

        // Include or exclude current element
        boolean include = findSubset(nums, index + 1, target - nums[index], dp);
        boolean exclude = findSubset(nums, index + 1, target, dp);

        dp[index][target] = include || exclude;
        return dp[index][target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 2}; // hardcoded array
        int target = 10; // hardcoded target

        // Initialize dp array with nulls
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        boolean found = findSubset(nums, 0, target, dp);

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
