package Array2D;

import java.util.ArrayList;

public class SetMatrixZero3 {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void question2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] zeroRows = new boolean[row];
        boolean[] zeroCol = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        // Set 0 to row

        for (int i = 0; i < row; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set 0 to column
        for (int j = 0; j < col; j++) {
            if (zeroCol[j]) {

                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
    }

    static void handleJaggedArray(ArrayList<ArrayList<Integer>> a) {
        int row = a.size() ;
        int maxCol = 0;
        for(int i =0; i<row; i++){
            maxCol = Math.max(maxCol,a.get(i).size());
        }
        boolean []zeroCol = new boolean[maxCol];
        boolean []zeroRow = new boolean[row];
        
        
        
        for(int   i = 0; i<row; i++){
            for(int j = 0; j<a.get(i).size(); j++){
                if(a.get(i).get(j) ==0){
                    zeroCol[j] = true;
                    zeroRow[i] = true;
                    
                }
            }
        }
        
        // Set zero in all row
        for(int i = 0; i<row; i++){
            if(zeroRow[i]){
                for(int j  = 0; j<a.get(i).size(); j++){
                    a.get(i).set(j,0);
                }
            }
        }
        // Set zero to column
        for(int j = 0; j<maxCol; j++){
            if(zeroCol[j]){
                for(int i = 0; i<row; i++){
                    a.get(i).set(j,0);
                }
            }
        }
        
      
        
	}

    static void setZeroes2(ArrayList<ArrayList<Integer>> a) {
        int row = a.size();
        int col = a.get(0).size();
        boolean[] zeroCol = new boolean[col];
        boolean[] zeroRow = new boolean[row];

        // Step 1: Mark zero rows and columns
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a.get(i).get(j) == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        // Step 2: Set rows to zero
        for (int i = 0; i < row; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < col; j++) {
                    a.get(i).set(j, 0);
                }
            }
        }

        // Step 3: Set columns to zero
        for (int j = 0; j < col; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < row; i++) {
                    a.get(i).set(j, 0); // ✅ FIXED: Correct row/col usage
                }
            }
        }

        // Print matrix for verification
        for (ArrayList<Integer> data : a) {
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if ((i == 0 && j == 1) || (i == 2 && j == 1)) {
                    row.add(0); // Special positions
                } else {
                    row.add(1); // All remaining positions
                }
            }
            matrix.add(row);
        }

        // Print the 2D ArrayList
        // for (ArrayList<Integer> row : matrix) {
        // System.out.println(row);
        // }

        // setZeroes2(matrix);

          int[][] matrix5 = {{1,0, 1}, {1, 1, 1}, {1, 1, 1}};
          question2(matrix5);

    }
}