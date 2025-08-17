package Array2D;

import java.util.*;


// 1380. Lucky Numbers in a Matrix

// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

// Example 1:

// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]
// Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 2:

// Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
// Output: [12]
// Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
// Example 3:

// Input: matrix = [[7,8],[1,2]]
// Output: [7]
// Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

public class LuckyNumber {

    static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


    //  Not run for all the test cases___________________________________________
    static List<Integer>  compareList(List<Integer> list1 , List<Integer> list2){
        List<Integer>  ans = new ArrayList<>();

        for(int i = 0; i<list1.size(); i++){
            for(int j = 0; j<list2.size(); j++){
                if(list1.get(i)==list2.get(j)) ans.add(list1.get(i));
            }
        }
        return ans;
    }

    static void luckyNumbers(int[][] matrix) {
        List<Integer> minRow = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

      

            for (int i = 0; i < row; i++) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < col; j++) {
                    min = Math.min(min, matrix[i][j]);

                }
                minRow.add(min);
            }

            // printList(minRow);

            // Finding max in each column
            for (int j = 0; j < col; j++) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < row; i++) {
                    max = Math.max(max, matrix[i][j]); //VVI -  yahan par i change ho raha hai siki wajah se column change hoga
                }
                maxCol.add(max);
            }

        // printList(maxCol);

    

    }



    // Run for all the test cases________________ Still Need to Revise_____

     static List<Integer> luckyNumbersRealk(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // Step 1: Find min in the row
            int minVal = Integer.MAX_VALUE;
            int minColIdx = -1;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minColIdx = j;
                }
            }

            // Step 2: Check if that value is the max in its column
            boolean isLucky = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minColIdx] > minVal) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(minVal);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 },
                           { 9, 11, 13 },
                           { 15, 16, 17 } 
                         };

      luckyNumbers(matrix);

    }

}
