package RealPYQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Task:
// Given an array of integers where each integer represents the size of a bull, determine the surviving bulls after all collisions.

// The sign of the integer indicates the bull's direction:

// Positive (+): Moves to the right.

// Negative (-): Moves to the left.

// All bulls move at the same speed (collisions only occur between opposite directions).

// Collision Rules:

// If two bulls collide, the one with the smaller absolute size is defeated.

// If their sizes are equal, both are defeated.

// Input:
// An array of integers representing bulls (e.g., [-3, 5, -8, 6, 7, -4, -7]).

// Output:
// An array of surviving bulls after all collisions (e.g., [-3, -8, 6]).

// Example
// Input:
// -3 5 -8 6 7 -4 -7

// Output:
// -3 -8 6

// Explanation:

// -3 moves left → no collision → survives.

// 5 moves right, collides with -8 → 5 (size 5) vs -8 (size 8) → 5 is defeated.

// 6 moves right → no collision → survives.

// 7 moves right, collides with -4 → 7 wins; -4 is defeated.

// 7 then collides with -7 → both are defeated (equal size).

// Note: Order matters! Collisions only occur between adjacent bulls moving in opposite directions.


// Dry run ________________________________________________________________






// Bull Index: 0    1    2    3    4    5    6
// Value:    -3    5   -8    6    7   -4   -7
// Direction: ←    →    ←    →    →    ←    ←






// Now step-by-step for your example:
// Array = [-3, 5, -8]
// Step 1 → -3
// Goes left

// Nothing before it

// No collision

// Stack = [-3]

// Step 2 → 5
// Goes right

// No one to collide with (next bulls not arrived yet)

// Stack = [-3, 5]

// Step 3 → -8
// Going left (from position 2)

// Check top of stack: it's 5, which is going right

public class Bullfighting {
     public static List<Integer> bullsAfterCollisions(int[] bulls) {
        Stack<Integer> stack = new Stack<>();

        for (int bull : bulls) {
            boolean bullSurvived = true;

        // Jub  bhi current bull - negative and stck ke peek par positive then colllison hoga

            while (!stack.isEmpty() && bull < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (Math.abs(bull) > Math.abs(top)) {
                    stack.pop(); // right-moving bull defeated
                } else if (Math.abs(bull) == Math.abs(top)) {
                    stack.pop(); // both bulls are defeated
                    bullSurvived = false;// so that current element no get  added in stack
                    break;
                } else {
                    bullSurvived = false; // so that current element no get  added in stack
                    break;
                }
            }

            if (bullSurvived) {
                stack.push(bull);
            }
        }

        // Convert stack to list
        return new ArrayList<>(stack);
    }


    static List<Integer> question(int[]arr){
        int n = arr.length;

        Stack<Integer> stack= new Stack<>();
        for(int i = 0; i<n; i++){

            boolean isServived = true;

            while(!stack.isEmpty() && arr[i]<0 && stack.peek()>0){
                int top = stack.peek();


                if(Math.abs(arr[i])> Math.abs(top)) stack.pop();

                else if  (Math.abs(arr[i]) == Math.abs(top)){
                    stack.pop();
                    isServived = false;
                    break;
                }

                else{
                     isServived = false;
                     break;
                }
            }

            if(isServived){
                stack.push(arr[i]);
            }



        }

        return new ArrayList<>(stack);
    }
    public static void main(String[] args) {
          int[] bulls = { -3, 5, -8, 6, 7, -4, -7 };
        List<Integer> result = question(bulls);
        System.out.println(result); // Output: [-3, -8, 6]
    }

    
}
