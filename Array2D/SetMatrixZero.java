package Array2D;

public class SetMatrixZero {

     static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void question (int[][] matrix){
         boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // Check if the first row contains a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Check if the first column contains a zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Mark zeros on first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark the corresponding row
                    matrix[0][j] = 0;  // Mark the corresponding column
                }
            }
        }
        
        // Zero out marked rows (except first row)
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out marked columns (except first column)
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out first row if needed
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Zero out first column if needed
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    
    
    public static void main(String[] args) {
        int[][] matrix5 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Test Case 5:");
        printMatrix(matrix5);
        question(matrix5);
        System.out.println();
        printMatrix(matrix5);


        //   int[][] matrix6 = {{1, 2, 3}, {4, 0, 6}};
        // System.out.println("Test Case 6:");
        // printMatrix(matrix6);
        // question(matrix6);
        // System.out.println();
        // printMatrix(matrix6);

        //   int[][] matrix3 = {{1, 2}, {3, 4}};
        // System.out.println("Test Case 3:");
        // printMatrix(matrix3);
        // question(matrix3);
        // System.out.println();
        // printMatrix(matrix3);
        
    }
}
