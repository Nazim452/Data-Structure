package PYQ.Zoho;

import java.util.*;

public class SpiralFibonacciMatrix {

    // Generate first k Fibonacci numbers
    static List<Integer> generateFibonacci(int k) {
        List<Integer> fib = new ArrayList<>();

        int a = 0, b = 1;

        fib.add(a);
        fib.add(b);

        for (int i = 0; i < k; i++) {
            int c = a + b;
            fib.add(c);
            
            a = b;
            b = c;
        }

        return fib;
    }

    static void fillSpiral(int m, int n) {

        int[][] matrix = new int[m][n];

        int total = m * n;
        List<Integer> fib = generateFibonacci(total);

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        int index = 0;

        while (top <= bottom && left <= right) {

            // Move Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = fib.get(index++);
            }
            top++;

            // Move Down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = fib.get(index++);
            }
            right--;

            // Move Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = fib.get(index++);
                }
                bottom--;
            }

            // Move Up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = fib.get(index++);
                }
                left++;
            }
        }

        // Print matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        fillSpiral(3, 4);
    }
}
