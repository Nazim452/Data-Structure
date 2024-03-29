// package Array2D;

// import java.util.Scanner;

// public class UserInput2DArray {
//     static void printMatrix(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
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
        
//     }
    
// }
