package PYQ.Zoho;

import java.util.Arrays;

public class SaddlePoint {
        
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
//     Why is it wrong?

// You are comparing:

// Every row minimum

// With every column maximum

// But a saddle point must satisfy:

// The element at position (i, j)
// must be:

// the smallest in its row i

// the largest in its column j

// Your code only checks values, not positions.

// It does not verify that the same element belongs to both that row and that column.

// This may give incorrect results in some matrices.

// 🔎 Example Where Your Code Fails

// Consider:

// 1 2 3
// 4 5 6
// 7 8 9


// Row minimums:

// 1 4 7


// Column maximums:

// 7 8 9


// Your logic compares:

// 1,4,7 with 7,8,9


// It finds 7 matches and prints it.

// This works here by coincidence, but logically it’s incorrect because it doesn’t check the actual matrix position.
    static void question(int[][] matrix){
        int row  = matrix.length;
        int col = matrix[0].length;

        int [] smallestInRow = new int[row];
        int [] largestInCol  = new int [col];
        int k = 0 ,l=0;

        for(int i = 0; i<row; i++){
            int minRow = Integer.MAX_VALUE;
            for(int j = 0; j<col; j++){
                minRow = Math.min(minRow, matrix[i][j]);

            }
            smallestInRow[k++] =minRow;
        }
        for(int i = 0; i<col; i++){
            int maxCol = Integer.MIN_VALUE;
            for(int j = 0; j<row; j++){

                maxCol = Math.max(maxCol, matrix[j][i]);

            }
            largestInCol[l++] =maxCol;
        }

       for(int i = 0; i<row; i++){
        for(int j = 0; j<col; j ++){
            if(largestInCol[i]==smallestInRow[j]){
                System.out.println(smallestInRow[j]);
                return;
            }
        }
       }
       
       System.out.println("NOt ");
       
    }


    static void findSaddlePoint(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {

            // Step 1: Find minimum in current row
            int min = matrix[i][0];
            int colIndex = 0;

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    colIndex = j;
                }
            }

            // Step 2: Check if this min is largest in its column
            boolean isSaddle = true;

            for (int k = 0; k < row; k++) {
                if (matrix[k][colIndex] > min) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("Saddle Point: " + min);
                return;
            }
        }

        System.out.println("No Saddle Point Found");
    }

    static void questioncolSm(int[][] matrix){

        int  row = matrix.length;

        for(int i = 0;i<row; i++){
            int sum = 0;
            for(int j = 0; j<matrix[i].length; j++){
                sum+=matrix[j][i];
                

            }
            System.out.println(sum);
            
        }
    }

    
    public static void main(String[] args) {
         int[][] matrix = {
                {3,1,2},
                {9,7,8},
                {5,6,4}
        };
        //  int[][] matrix = {
        //         {1, 2, 3},
        //         {4, 5, 6},
        //         {7, 8, 9}
        // };
        questioncolSm(matrix);
        
    }
}
