package DP;

public class RodCutting {
    static int rodCut(int length[], int price[], int totRod){
        int n = price.length;
        int dp[][] = new int[n+1][totRod+1];

        for(int  i = 1; i<n+1; i++){
            for(int j  =1; j<totRod+1; j++){

                if(length[i-1]<=j){
                   int include = price[i-1]+dp[i][j-length[i-1]];
                   int exclude = dp[i-1][j];

                   dp[i][j] = Math.max(include, exclude);

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
    public static void main(String[] args) {

        int []length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int totRod = 8;

        System.out.println(rodCut(length, price, totRod));;

        
    }
}
