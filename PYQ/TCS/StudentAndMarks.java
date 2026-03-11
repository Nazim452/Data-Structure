package PYQ.TCS;

public class StudentAndMarks {
    static void question(int[][] matrix) {
        int row = matrix.length;
        int pass = 0;

        for (int i = 0; i < row; i++) {
            double marks = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                marks += matrix[i][j];

            }
            marks = marks / matrix[i].length;

            if (marks >= 50)
                pass++;
        }
        System.out.println(pass);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 60, 70, 80 },
                { 40, 50, 60 },
                { 30, 40, 50 } };
        question(matrix);

    }

}
