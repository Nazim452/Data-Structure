package Array2D;

// import java.util.Scanner;

public class MatrixSum {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void MyMatrixSum(int[][] matr1, int r1, int c1, int[][] matr2, int r2, int c2) {
        if (r1 != r2 || c1 != c2) {
            System.out.println("Wrong input , cant add of this matrix");
            return;
        }

        int[][] sum = new int[r1][c1];

        for (int i = 0; i < r1; i++) { // row no // neeed two traverse row$col bcz initially fill
            for (int j = 0; j < c1; j++) { // column no // with 0
                sum[i][j] = matr1[i][j] + matr2[i][j];
            }
        }

        printMatrix(sum);

    }

    public static void main(String[] args) {
        int [][] arr ={{1,2,3},
                        {4,5,6},};
        int[][]arr2={{11,12,13},
                      {14,15,16},};
        MyMatrixSum(arr, 2, 3, arr2, 2, 3);



        // Taking Inout From the user_____________________________________________________




        //  Scanner sc= new Scanner(System.in);

        // System.out.println("Enter no of row in matrix 1");
        // int r1 = sc.nextInt();

        // System.out.println("Enter no of column in matrix 1");
        // int c1 = sc.nextInt();

        // int[][] matr1 = new int[r1][c1];

        // System.out.println("Enter the value of matrix");

        // for(int i =0; i<r1; i++){
        //     for(int j = 0; j<c1; j++){
        //         matr1[i][j] = sc.nextInt();

        //     }
        // }

        // System.out.println("Enter no of rows in second matrix");

        // int r2 = sc.nextInt();

        // System.out.println("ENter no of column in second matrix");

        // int c2 = sc.nextInt();

        // int[][] matr2 = new int[r1][c1];

        // System.out.println("Enter the vlaue of matrix 2");

        // for(int i = 0; i<r2; i++){
        //     for(int j = 0;  j<c2; j++){
        //         matr2[i][j] = sc.nextInt();
        //     }
        // }
        // System.out.println("Matrix 1");
        // printMatrix( matr1);

        // System.out.println("Matrix 2");
        // printMatrix(matr2);

        // System.out.println("Sum of matrix 1 & matrix 2");

        // MyMatrixSum(matr1, r1, c1, matr2, r2, c2);


    }

}
