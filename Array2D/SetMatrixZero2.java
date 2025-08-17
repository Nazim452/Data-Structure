package Array2D;

public class SetMatrixZero2 {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void question(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean[] zeroRows = new boolean[rows]; // Tracks rows to be zeroed
        boolean[] zeroCols = new boolean[cols]; // Tracks columns to be zeroed
        
        // Step 1: Identify rows and columns with zeros
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        
        // Step 2: Zero out marked rows

        //  if zeroRows value find then - [row][] row - fixed and column change so iterate on the column
        for (int i = 0; i < rows; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            } 
        }
        
        // Step 3: Zero out marked columns
        for (int j = 0; j < cols; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    static void myPractice(int[][]matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] zeroRows = new boolean[row];
        boolean[] zeroCols = new boolean[col];

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){

                if(matrix[i][j]==0){
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }

            }
        }

        for(int i = 0; i<row; i++){
            if(zeroRows[i]){

                for(int j = 0; j<col; j++){
                    matrix[i][j] = 0;
                }

            }
        }
        for(int i = 0; i<col; i++){
            if(zeroCols[i]){

                for(int j = 0; j<row; j++){
                    matrix[j][i] = 0;
                }

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

        // int[][] matrix6 = {{1, 2, 3}, {4, 0, 6}};
        // System.out.println("Test Case 6:");
        // printMatrix(matrix6);
        // ques1(matrix6);
        // System.out.println();
        // printMatrix(matrix6);

        // int[][] matrix3 = {{1, 2}, {3, 4}};
        // System.out.println("Test Case 3:");
        // printMatrix(matrix3);
        // question(matrix3);
        // System.out.println();
        // printMatrix(matrix3);
    }
}