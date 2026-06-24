package PYQ.ActualPYQ;

import java.util.Arrays;

public class MaximumProductOfThree {
    static void question(int[] arr){
        int n=arr.length;
       Arrays.sort(arr);

       int op1 = arr[0]*arr[1]*arr[n-1];

       int op2 = arr[n-1]*arr[n-2]*arr[n-3];

       int ans = Math.max(op1 , op2);
       System.out.println(ans);

    }
    public static void main(String[] args) {
        int[] arr = {3,-2,-8,4,1};

        // Find maximum product of 3 number that may contain negative number.

        /*
        1. Sort
        We can choose maximum 2 -ve number (from starting) ,mul - become +ve and then choose largest number (1)

        2. We can chooose only largest 3 postivive number and find who is maximum
        
        */

        question(arr);
        
    }
}
