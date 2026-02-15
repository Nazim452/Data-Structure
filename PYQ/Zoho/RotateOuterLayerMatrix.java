package PYQ.Zoho;

import java.util.Scanner;
// Understanding the Problem

// The question says:

// Rotate the matrix by ‘N’ elements in clockwise direction.

// Given input:

// 1 2 3
// 4 5 6
// 7 8 9


// Number of Rotations = 1

// Output:

// 4 1 2
// 7 5 3
// 8 9 6

// 🔹 What Does This Mean?

// This is not a 90-degree rotation.

// It means:

// 👉 Rotate the outer boundary elements of the matrix clockwise by 1 step.

// Let’s see the outer layer elements:

// 1 2 3
// 4   6
// 7 8 9


// Outer elements in order (clockwise):

// 1 → 2 → 3 → 6 → 9 → 8 → 7 → 4


// After 1 clockwise rotation:

// 4 → 1 → 2 → 3 → 6 → 9 → 8 → 7


// Now place them back into matrix:

// 4 1 2
// 7 5 3
// 8 9 6


// Notice:

// Middle element 5 remains unchanged.

// Only the boundary moves.;

public class RotateOuterLayerMatrix {

    public static void rotateMatrix(int[][] matrix, int n, int rotations) {

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (rotations-- > 0) {

            int prev = matrix[top + 1][left];

            // Top row
            for (int i = left; i <= right; i++) {
                int temp = matrix[top][i];
                matrix[top][i] = prev;
                prev = temp;
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                int temp = matrix[i][right];
                matrix[i][right] = prev;
                prev = temp;
            }
            right--;

            // Bottom row
            for (int i = right; i >= left; i--) {
                int temp = matrix[bottom][i];
                matrix[bottom][i] = prev;
                prev = temp;
            }
            bottom--;

            // Left column
            for (int i = bottom; i >= top; i--) {
                int temp = matrix[i][left];
                matrix[i][left] = prev;
                prev = temp;
            }
            left++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 3;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rotations = 1;

        rotateMatrix(matrix, n, rotations);

        System.out.println("Rotated Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
