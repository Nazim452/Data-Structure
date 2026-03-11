package DP;

public class LongestCommonSubSeqActualStr {
   static String lcsTabulation(String str1, String str2) {

    int n = str1.length();
    int m = str2.length();

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

        }
    }

    // Backtracking to build LCS
    int i = n, j = m;
    StringBuilder lcs = new StringBuilder();

    while (i > 0 && j > 0) {

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            lcs.append(str1.charAt(i - 1));
            i--;
            j--;
        }

        else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        }

        else {
            j--;
        }
    }

    return lcs.reverse().toString();
}    public static void main(String[] args) {
        String str1 ="abcdge";
        String str2 ="abedg";
      


        System.out.println(lcsTabulation(str1, str2));
        
    }
    
}
