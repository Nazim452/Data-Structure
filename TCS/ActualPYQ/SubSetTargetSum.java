package TCS.ActualPYQ;

import java.util.ArrayList;
import java.util.List;
 
// Problem statemnet - 

// You are given an array of integers and a target sum. Your task is to determine whether
// any subset of the given numbers can sum up to target. If a valid subset exist of
// given target sum then pprint this subset otherwirse print  no.

// Input - {3 5 7 2} , tar = 10
// O/P Return any one of the set among them either -  {3,7} or {3, 5, 2}

public class SubSetTargetSum {

    public static boolean findSubset(int[] nums, int index, int target, List<Integer> current) {
        if (target == 0)
            return true;
        if (index >= nums.length || target < 0)
            return false;

        // include current number
        current.add(nums[index]);
        if (findSubset(nums, index + 1, target - nums[index], current)) {
            return true;
        }

        // backtrack and exclude the number
        current.remove(current.size() - 1);
        return findSubset(nums, index + 1, target, current);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 2 }; // hardcoded array
        int target = 10; // hardcoded target

        List<Integer> subset = new ArrayList<>();
        boolean found = findSubset(nums, 0, target, subset);

        if (found) {
            System.out.print("{");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("}");
        } else {
            System.out.println("No");
        }
    }

}
