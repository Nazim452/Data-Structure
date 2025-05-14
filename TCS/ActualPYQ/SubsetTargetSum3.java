package TCS.ActualPYQ;

// Problem statemnet -  Subsequence finding in array.............

// You are given an array of integers and a target sum. Your task is to determine whether
// any subset of the given numbers can sum up to target. If a valid subset exist of
// given target sum then pprint this subset otherwirse print  no.

// Input - {3 5 7 2} , tar = 10....
// O/P - True - {3,7}


// ✅ Time Complexity: O(2^n)


public class SubsetTargetSum3 {

    public static boolean findSubset(int[] nums, int index, int target) {
        if (target == 0)
            return true;
        if (index >= nums.length || target < 0)
            return false;

        // Include current element
        if (findSubset(nums, index + 1, target - nums[index])) {
            return true;
        }

        // Exclude current element
        return findSubset(nums, index + 1, target);
    }


    static boolean question(int[] arr , int index , int target){
        if(target==0) return true;
        if(arr.length<=index || target<0) return false;

        if(question(arr, index+1, target-arr[index])) return true;

        else return question(arr, index+1, target);
    }
    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 2 }; // hardcoded array
        int target = 10; // hardcoded target

        boolean found = question(nums, 0, target);

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
