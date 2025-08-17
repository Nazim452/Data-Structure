package Array2D;

class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {

        int row = arr.length;
        int col = arr[0].length;
        // Why j = col - 1?
        // The algorithm starts from the top-right corner to leverage the matrix's
        // sorted properties:

        // Rows are sorted left-to-right.

        // Columns are sorted top-to-bottom.


        //VVI ********************____________________

        
        //  Start searching from top right corner - so if hte target is bigger then goes
        // down else goes back in the same row.
        int i = 0, j = col - 1;

        while (i < row && j >= 0) {
            if (arr[i][j] == tar)
                return true;
            else if (arr[i][j] < tar)
                i++;
            else
                j--;
        }

        return false;

    }
}