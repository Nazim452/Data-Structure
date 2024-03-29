package Array2D;

public class Rotate90Deg {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void TransposeMatrix2(int[][] matrix, int r, int c) {

        for (int i = 0; i < c; i++) { // first we go to upto column then traverse row, bcz gdfgtranspose
            for (int j = i; j < r; j++) { // here j loop start with i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }
    // REVERSE OF ARRAY

    static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // ROTATING OF AMTRIX INTO 90 DEGREE CLOCKWISE

    // only aplicable for sqaure matrix

    static void rotatingMatrix(int[][] matrix, int n) {
        // 1st find transpose

        TransposeMatrix2(matrix, n, n); // yahan bina swapping wala transppose hi pass hoga

        // then reverse - now we find rotated matrix

        for (int i = 0; i < n; i++) { // n- row/column --- square matrix
            reverseArray(matrix[i]);
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotatingMatrix(arr, 3);
        printMatrix(arr);

    }

}
