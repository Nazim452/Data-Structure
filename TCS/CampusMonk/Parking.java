package TCS.CampusMonk;

import java.util.Scanner;

public class Parking {

    static void question(int[][]matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0  , max = Integer.MIN_VALUE;
        for(int i = 0; i<row ; i++){
            int count1 = 0;

            for(int j = 0; j<col; j++){
                if(matrix[i][j]==1) count1++;

            }
            if(count1>max){
                max = count1;
                ans = i+1;
            }
        }

        System.out.println(ans);
    }


    
    static void questionWithInput(){

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int  col = sc.nextInt();

        int[][] matrix   = new int[row][col];

        for(int  i = 0; i<row; i++){
            for(int j = 0; j<col; j++){

                matrix[i][j] = sc.nextInt();

            }
        }
      
        int ans = 0  , max = Integer.MIN_VALUE;
        for(int i = 0; i<row ; i++){
            int count1 = 0;

            for(int j = 0; j<col; j++){
                if(matrix[i][j]==1) count1++;

            }
            if(count1>max){
                max = count1;
                ans = i+1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 0, 1 },
                           { 1, 1, 0 },
                           { 1, 1, 1 } };   // maxm no of row in third row , so ans is 3.
        question(matrix);
    }

}
