package Array2D;

public class MatrixMultplcatn {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void MatrixMultiplication(int[][] matr1, int r1, int c1, int[][] matr2, int r2, int c2) {
        if (c1 != r2) {
            System.out.println("Multiplication is not possible");
            return;
        }
        int[][] ans = new int[r1][c2];
        for (int i = 0; i < r1; i++) { // row
            for (int j = 0; j < c2; j++) { // column
                for (int k = 0; k < c1; k++) { // k -loop multiplication &add of matrix elem ke liye
                    ans[i][j] += (matr1[i][k] * matr2[k][j]);
                }
            }
        }
        System.out.println("Multiplication of  2 matrices");
        printMatrix(ans);

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 },
                { 3, 4 }, };
        int[][] arr2 = { { 5, 6 },
                { 7, 8 }, };

        MatrixMultiplication(arr, 2, 2, arr2, 2, 2);

        // Taking input form the user___________________________________________________

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no of row in Matrix 1");
        // int r1 = sc.nextInt();

        // System.out.println("Enter no of column in matrix 1");
        // int c1 = sc.nextInt();

        // int[][] matr1 = new int [r1][c1];

        // System.out.println("Enter the vlaue of matrix 1");

        // for(int i = 0; i<r1; i++){
        // for(int j =0; j<c1; j++){
        // matr1[i][j] = sc.nextInt();
        // }
        // }

        // System.out.println("Enter the vlaue of row in matrix 2");
        // int r2 = sc.nextInt();

        // System.out.println("Enter the value of column in matrix 2");
        // int c2 = sc.nextInt();

        // int[][] matr2 = new int [r2][c2];

        // System.out.println("Enter the value of matrix 2");

        // for(int i =0; i<r2; i++){
        // for(int j= 0; j<c2; j++){
        // matr2[i][j] = sc.nextInt();
        // }
        // }
        // System.out.println("Matrix 1");
        // printMatrix(matr1);

        // System.out.println("Matrix 2");
        // printMatrix(matr2);
        // //System.out.println("Multiplication of matrix is");

        // MatrixMultiplication(matr1, r1, c1, matr2, r2, c2);

    }

}
