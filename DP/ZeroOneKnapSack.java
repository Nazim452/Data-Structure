package DP;

public class ZeroOneKnapSack {


    static void print(int dp[][]){
        for(int  i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int knapSackRecur(int val[], int[] wt, int cap, int n) {
        if (cap == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= cap) { // valid

            // include
            int ans1 = val[n - 1] + knapSackRecur(val, wt, cap - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSackRecur(val, wt, cap, n - 1);
            return Math.max(ans1, ans2);
        }

        else { // invalid
            return knapSackRecur(val, wt, cap, n - 1);
        }
    }

    // MemoIzation_______________________________________

    static int knapSackMemoization(int val[], int[] wt, int cap, int n, int dp[][]) {
        if (cap == 0 || n == 0)
            return 0;

        if (dp[n][cap] != 0)
            return dp[n][cap];

        if (wt[n - 1] <= cap) { // valid

            // include
            int ans1 = val[n - 1] + knapSackMemoization(val, wt, cap - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapSackMemoization(val, wt, cap, n - 1, dp);
            dp[n][cap] = Math.max(ans1, ans2);
            return dp[n][cap];
        }

        else { // invalid
            dp[n][cap] = knapSackMemoization(val, wt, cap, n - 1, dp);
            return dp[n][cap];
        }
    }



    // Tabulation________________________________________________________

    static int knapScakTabulation(int[]val, int[]wt, int cap){
        int n = val.length;
        int[][]dp = new int[n+1][cap+1];
        // Initilization

        for(int i= 0; i<dp.length; i++) dp[i][0]=0;     // 0th column
        for(int j = 0;  j<dp[0].length; j++) dp[0][j]=0; // 0th row

        for(int i =1; i<n+1; i++){
            for(int j = 1; j<cap+1; j++){
                int value = val[i-1];    //ith  item value
                int capicity = wt[i-1];     //ith item weight

                if(capicity<=j){   //valid
                   int  inclProfit = value+dp[i-1][j-capicity];
                    int  exluProfit = dp[i-1][j];
                    dp[i][j] = Math.max(inclProfit,exluProfit);
                }

                else{  //invalid
                    int excluProfit = dp[i-1][j];
                    dp[i][j] = excluProfit;

                }

            }
        }

        print(dp);

        return dp[n][cap];


    }

    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int cap = 7;
        // System.out.println( knapSackRecur(val, wt, cap, val.length));;
    
        // Memoization___________

        // int dp[][] = new int[val.length+1][cap + 1];

        // System.out.println(knapSackMemoization(val, wt, cap, val.length, dp));


        // Tabulation_________

        System.out.println(knapScakTabulation(val, wt, cap));
    }

}
