package Array2D;

public class Transpose2 {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void TransposeMatrix2(int[][] matrix , int r , int c){

        for(int i= 0; i<c; i++){       // first we go to upto column  then traverse row, bcz transpose
            for(int j = i; j<r ; j++){ //  here j loop start with i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        TransposeMatrix2(arr, 3, 3);
        printMatrix(arr);
        
    }
}
