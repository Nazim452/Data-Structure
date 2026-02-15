package PYQ.Zoho;
// Problem: Equilibrium Index in Array

// Find an element such that:

// Sum of elements on left = Sum of elements on right


// Example:

// Input:  1, 2, 3, 7, 6
// Output: 7
// Explanation:
// Left sum = 1 + 2 + 3 = 6
// Right sum = 6
public class EquilibriumIndex {
    static void question(int[]arr){
      int totalSum = 0;
      for(int i = 0;i<arr.length; i++){
        totalSum+=arr[i];
      }

      int leftSum = 0;
      for(int i = 0; i<arr.length; i++){
        int rightSum = totalSum-leftSum-arr[i];

        if(leftSum==rightSum){
            System.out.println(arr[i]);
        }
        leftSum+=arr[i];
      }
    }
    public static void main(String[] args) {
        // int[] arr = {1,2,3,7,6}; //7
        int[] arr = {3,4,8,2,5}; //7
        question(arr);
        
    }
    
}
