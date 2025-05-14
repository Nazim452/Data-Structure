package TCS.ActualPYQ;

import java.lang.reflect.Array;
import java.util.Arrays;

// We have three integers: a, b, c.

// We can select any two numbers and:

// Increase both selected numbers by 1.

// Decrease the remaining number by 1.

// The goal is to check whether we can make all three numbers equal.

// Problem Statement: Making Triplets Equal
// You are given a triplet of integers (a,b,c)(a, b, c). You can perform the following operation any
// number of times:
// Select any two numbers from the triplet. 1.
// Add 1 to both selected numbers. 2.
// Subtract 1 from the remaining number. 3.
// Your task is to determine whether it is possible to make all three numbers equal using the
// given operations.
// Input:
// A single integer TT representing the number of test cases.
// Each test case consists of three integers a,b,ca, b, c.
// Output:
// For each test case, print "YES" if it is possible to make all three numbers equal; otherwise,
// print "NO".
// Constraints:
// Example:
// Input:
// 3  
// 1 2 3  
// 4 4 4  
// 3 3 7 
// Output:No
// Yes  
// Yes

public class MakingTripletEqual {

    // public static boolean canMakeEqualMy(int a, int b, int c) {
    // int[] arr = { a, b, c };
    // Arrays.sort(arr);

    // if (arr[0] == arr[1] && arr[1] == arr[2])
    // return true;
    // int steps = 0;

    // while (true) {
    // arr[0] += 1;
    // arr[1] += 1; // Smallest me 1 add , large me 1 substract to make equal
    // arr[2] -= 1;

    // steps += 1;
    // Arrays.sort(arr);
    // if (arr[0] == arr[1] && arr[1] == arr[2]) {
    // System.out.println("Steps Taken " + steps);
    // return true;

    // }

    // // Edge cases

    // if (arr[0] == arr[1] && arr[1] + 1 == arr[2])
    // return false;

    // // This condtion also can be added - [2,3,3]

    // // || arr[1]==arr[2] && arr[0]+1 == arr[1]

    // }

    // }

    public static boolean canMakeEqual(int a, int b, int c) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        int steps = 0;

        // Check if already equal first
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println("Steps Taken " + steps);
            return true;
        }

        while (true) {
            arr[0] += 1;
            arr[1] += 1;
            arr[2] -= 1;
            steps += 1;
            Arrays.sort(arr);

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Steps Taken " + steps);
                return true;
            }

            // Edge case checks
            if (arr[0] == arr[1] && arr[1] + 1 == arr[2]) {
                return false;
            }
            // if (arr[1] == arr[2] && arr[0] + 1 == arr[1]) {
            //     return false;
            // }
        }
    }


 
    public static void main(String[] args) {

        System.out.println(canMakeEqual(1, 2, 3));// No
        System.out.println(canMakeEqual(4,4,4));// Yes
        System.out.println(canMakeEqual(3,3,7)); //yes
       

    }

}
