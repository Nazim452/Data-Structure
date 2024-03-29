package BackTracking;

public class RatInMaze4Dir {

    private static void ratPrint(int sr, int sc, int er, int ec, String s, boolean isVisited[][]) {
        if (sr < 0 || sc < 0)
            return;
        if (sr > er || sc > ec)
            return;
        if (isVisited[sr][sc] == true)
            return;

        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        isVisited[sr][sc] = true;

        // go right
        ratPrint(sr, sc + 1, er, ec, s + "R", isVisited);
        // go down
        ratPrint(sr + 1, sc, er, ec, s + "D", isVisited);

        // go left
        ratPrint(sr, sc - 1, er, ec, s + "L", isVisited);
        // go up
        ratPrint(sr - 1, sc, er, ec, s + "U", isVisited);

        isVisited[sr][sc] = false;

    }

    public static void main(String[] args) {

        int row = 3;
        int col = 3;
        boolean[][] isVisited = new boolean[row][col];
        ratPrint(0, 0, row - 1, col - 1, " ", isVisited);

    }

}