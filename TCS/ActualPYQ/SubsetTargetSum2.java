package TCS.ActualPYQ;

import java.util.ArrayList;
import java.util.List;
// Problem statemnet - 

// You are given an array of integers and a target sum. Your task is to determine whether
// any subset of the given numbers can sum up to target. If a valid subset exist of
// given target sum then pprint this subset otherwirse print  no.

// Input - {3 5 7 2} , tar = 10
// O/P Return all of the set  -  {3,7} & {3, 5, 2}

public class SubsetTargetSum2 {

    public static void findAllSubsets(int[] nums, int index, int target, List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= nums.length || target < 0)
            return;

        // include current number
        current.add(nums[index]);
        findAllSubsets(nums, index + 1, target - nums[index], current, result);

        // backtrack
        current.remove(current.size() - 1);

        // exclude current number
        findAllSubsets(nums, index + 1, target, current, result);
    }

    static void question(int[] arr, int index, int tar, ArrayList<Integer> current,
            ArrayList<ArrayList<Integer>> result) {
        if (tar == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= arr.length || tar < 0)
            return;

        current.add(arr[index]);

        question(arr, index + 1, tar - arr[index], current, result);
        current.remove(current.size() - 1);

        question(arr, index + 1, tar, current, result);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 2 }; // hardcoded array
        int target = 10; // hardcoded target

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        question(nums, 0, target, new ArrayList<>(), result);

    
        if (result.isEmpty()) {
            System.out.println("No Suset Found");

        } else {
            for (int i = 0; i < result.size(); i++) {
                ArrayList<Integer> subset = result.get(i);
                System.out.print("{");
                for (int j = 0; j < subset.size(); j++) {
                    System.out.print(subset.get(j));
                    if (j < subset.size() - 1)
                        System.out.print(", ");
                }
                System.out.println("}");

            }
        }

    }
}
