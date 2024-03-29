package BackTracking;

public class RatInMaze2Dir {
    static int maze(int sr, int sc, int er, int ec) {
        if (sr > er || sc > ec)
            return 0;
        if (sr == er && sc == ec)
            return 1;

        int downWays = maze(sr + 1, sc, er, ec);
        int rightWays = maze(sr, sc + 1, er, ec);

        int totalWays = downWays + rightWays;
        return totalWays;
    }

    // Print Path_________________________________________________________________________________
    
    static void mazePath(int sr, int sc, int er, int ec, String s) {
        if (sr > er || sc > ec) return ;
           
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        mazePath(sr + 1, sc, er, ec, s + "R");
        mazePath(sr, sc + 1, er, ec, s + "D");

    }

    public static void main(String[] args) {
        int row = 4;
        int col = 4;

        // int count = maze(0, 0, row - 1, col - 1);
        // System.out.println(count);
        mazePath(0, 0, row-1, col-1, " ");

    }

}
