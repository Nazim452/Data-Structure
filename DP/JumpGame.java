package DP;




// Problem - 

// You are given an integer array nums. You are initially positioned at the array's 
//first index, and each element in the array represents your maximum jump length at 
//that position.

// Return true if you can reach the last index, or false otherwise.


public class JumpGame {



    // No DP    DP DP    No DP


    static boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;

        for(int i = 0; i<=reach; i++){
            reach = Math.max(nums[i]+i , reach);
            if(reach>=n-1) return true;
        }

        return false;
        
    }








    public static void main(String[] args) {
        
    }
    
}
