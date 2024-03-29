package Array2D;

public class TransPose {

    // PRINT THE MATRIX

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // TRANSPOSE OF MATRIX

    // only aplicable for sqaure matrix

    static int[][] TransposeMatrix(int[][] matrix, int r, int c) {
        int[][] ans = new int[c][r]; // in transpose row is convertwd into column

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        printMatrix(ans);
        return ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        TransposeMatrix(arr, 3, 3);

    }

}
