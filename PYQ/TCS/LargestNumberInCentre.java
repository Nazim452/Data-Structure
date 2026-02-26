package PYQ.TCS;

public class LargestNumberInCentre {
      static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    static void solve(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find largest element
        int max = matrix[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        int originalRow = maxRow;
        int originalCol = maxCol;

        int centerRow = rows / 2;
        int centerCol = cols / 2;

        int swaps = 0;

        // Move vertically
        while (maxRow != centerRow) {
            if (maxRow > centerRow) {
                swap(matrix, maxRow, maxCol, maxRow - 1, maxCol);
                maxRow--;
            } else {
                swap(matrix, maxRow, maxCol, maxRow + 1, maxCol);
                maxRow++;
            }
            swaps++;
        }
      
        // Move horizontally
        while (maxCol != centerCol) {
            if (maxCol > centerCol) {
                swap(matrix, maxRow, maxCol, maxRow, maxCol - 1);
                maxCol--;
            } else {
                swap(matrix, maxRow, maxCol, maxRow, maxCol + 1);
                maxCol++;
            }
            swaps++;
        }

        // Print Results
        System.out.println("Matrix after moving largest element to center:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

        System.out.println("Largest element: " + max);
        System.out.println("Original position: (" + originalRow + "," + originalCol + ")");
        System.out.println("Total swaps (shortest path): " + swaps);
    }


     static void solve2(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find largest element
        int max = matrix[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        int originalRow = maxRow;
        int originalCol = maxCol;

        int centerRow = rows / 2;
        int centerCol = cols / 2;

        // Calculate shortest path (Manhattan Distance)
        int swaps = Math.abs(originalRow - centerRow)
                  + Math.abs(originalCol - centerCol);

        // 🔹 Only ONE direct swap (preserve others)
        int temp = matrix[centerRow][centerCol];
        matrix[centerRow][centerCol] = matrix[originalRow][originalCol];
        matrix[originalRow][originalCol] = temp;

        // Output
        System.out.println("Matrix after moving largest element to center:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

        System.out.println("Largest element: " + max);
        System.out.println("Original position: (" + originalRow + "," + originalCol + ")");
        System.out.println("Total swaps (shortest path): " + swaps);
    }

    public static void main(String[] args) {

        // =========================
        // ✅ ACTIVE TEST CASE
        // =========================

        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {9, 8, 7}
        // };

        // solve2(matrix);

        // =========================
        // ❌ COMMENTED TEST CASES
        // =========================

        
        // int[][] matrix = {
        //     {10, 2, 3},
        //     {4, 15, 6},
        //     {7, 8, 9}
        // };
        // solve2(matrix);
       

        /*
        int[][] matrix = {
            {1, 20, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        solve(matrix);
        */

        /*
        int[][] matrix = {
            {5, 1, 2},
            {3, 4, 6},
            {7, 8, 20}
        };
        solve(matrix);
        */

        
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 25, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 99}
        };
        solve2(matrix);
       

    }
}