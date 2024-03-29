// package Array2D;

// import java.util.Scanner;

// public class SpiralOrder {
//     static void printMatrix(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     static void printSpiralOrder(int[][] matrix, int r, int c) {
//         int topRow = 0, bottmRow = r - 1, leftColumn = 0, rightColumn = c - 1;

//         int totalElemnt = 0;

//         while (totalElemnt < r * c) { // loop jab tak chalega tab tak total elemnt matrix me hai

//             // top row ->leftcol to right column

//             for (int j = leftColumn; j <= rightColumn && totalElemnt < r * c; j++) {
//                 System.out.print(matrix[topRow][j] + " "); // only column change
//                 totalElemnt++;
//             }
//             topRow++;

//             // rightcol -> top row to bottom row

//             for (int i = topRow; i <= bottmRow && totalElemnt < r * c; i++) {
//                 System.out.print(matrix[i][rightColumn] + " "); // only row change
//                 totalElemnt++;
//             }
//             rightColumn--;

//             // bottom row ->right col to left column

//             for (int j = rightColumn; j >= leftColumn && totalElemnt < r * c; j--) { // opposite ja rahe hai right to
//                                                                                      // left
//                 System.out.print(matrix[bottmRow][j] + " ");
//                 totalElemnt++;
//             }
//             bottmRow--;

//             // left col -> bottom row to top row

//             for (int i = bottmRow; i >= topRow && totalElemnt < r * c; i--) {
//                 System.out.print(matrix[i][leftColumn] + " ");
//                 totalElemnt++;
//             }
//             leftColumn++;
//         }

//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no of row in Matrix ");
//         int r = sc.nextInt();

//         System.out.println("Enter no of column in matrix ");
//         int c = sc.nextInt();

//         int[][] matrix = new int[r][c];
//         int totalElemnt = r * c;

//         System.out.println("Enter " + totalElemnt + " values");

//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 matrix[i][j] = sc.nextInt();
//             }
//         }

//         System.out.println("Input matrix");
//         printMatrix(matrix);

//         System.out.println("spiral oreder");
//         printSpiralOrder(matrix, r, c);

//     }

// }
