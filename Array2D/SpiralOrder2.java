package Array2D;

public class SpiralOrder2 {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void spiral(int[][]matrix, int r, int c){
        int topRow =0, bottomrow =r-1, leftColumn = 0, rightColumn  = c-1;

        int totalElemnt = 0;

        while(totalElemnt<r*c){

            // toprow-> leftcol to right col

            for(int j = leftColumn; j<=rightColumn   && totalElemnt<r*c; j++ ){
               System.out.print(matrix[topRow][j]+" ");
               totalElemnt++;

            }
            topRow++;

            

            //right col -> toprow to bottomrow

            for(int i =topRow; i<=bottomrow&&totalElemnt<r*c; i++){
                System.out.print(matrix[i][rightColumn]+" ");
                totalElemnt++;
            }
            rightColumn--;


            //bottom row-> right col to left col

            for(int j =rightColumn; j>=leftColumn&& totalElemnt<r*c; j--){
                System.out.print(matrix[bottomrow][j]+" ");
                totalElemnt++;
            }
            bottomrow--;


            // leftcol-> bottom row to top raw

            for(int i =bottomrow; i>=topRow&& totalElemnt<r*c; i--){
                System.out.print(matrix[i][leftColumn]+" ");
                totalElemnt++;
            }
            leftColumn++;

        }
    }


    public static void main(String[] args) {
        int[][]martix = {{1,2,3},
                          {4,5,6 },
                          {7,8,9}};

        spiral(martix, 3, 3);

        
    }
    
}
