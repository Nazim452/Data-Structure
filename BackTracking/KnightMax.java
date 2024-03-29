package BackTracking;

public class KnightMax {
    static int maxKnight= 0;
    static int number = 5;
    static void printBoard(char[][] board){
        System.out.println("-----Knight-------");
        for(int i= 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("______________________");

    }
   static  boolean isSafe(char[][]board, int row, int col){
        int n = board.length;
       
        int i,j;

        // 2up 1right
        i = row-2;
        j = col+1;
       if(i>=0&& j<n&&board[i][j]=='K')  return false;
      

       //2 up 1 left

       i = row-2;
       j = col-1;
       if(i>=0&&j>=0&&board[i][j]=='K') return false;
      

       // 2right 1 up

       i = row-1;
       j =col+2;
       if(i>=0&&j<n&&board[i][j]=='K')return false;
      

       // 2right 1 down

       i = row+1;
       j = col+2;
       if(i<n&&j<n&&board[i][j]=='K')return false;
      
       // 2 left 1 up
       i = row-1;
       j =  col-2;
       if(i>=0&&j>=0&&board[i][j]=='K') return false;
       
       // 2left 1 down
       i =row+1;
       j = col-2;

       if(i<n&&j>=0&&board[i][j]=='K')return false;
      

       // 2down 1 right
        i = row+2;
        j = col+1;
        if(i<n&&j<n&&board[i][j]=='K')return false;
       

        // 2down 1 left

        i = row+2;
        j = col-1;
        if(i<n&&j>=0&&board[i][j]=='K')return false;
       
        return true;
        
    }

    static void knight_helper(char[][] board ,int row, int col, int num){
        int n = board.length;

        //base case

        if(row==n){
            
            maxKnight=Math.max(maxKnight,num);

            return;
        }

       else if(isSafe(board, row, col)) {
            board[row][col] ='K';
            if(col!=n-1) knight_helper(board, row, col+1, num+1); 
            else knight_helper(board, row+1, 0, num+1); 
            //backTracking
            board[row][col] = '.';

        }
        if(col!=n-1) knight_helper(board, row, col+1, num); 
        else knight_helper(board, row+1, 0, num); 



    }

    public static void main(String[] args) {
        int n=2;
        char[][] board = new char[n][n];

        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j]='.';
            }
        }
        knight_helper(board, 0, 0, 0);
        System.out.println(maxKnight);
        
    }
}
