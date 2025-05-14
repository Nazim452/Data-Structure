package TCS.ActualPYQ;

public class NetworkMarketing {

    static  void question(int n , int profit , int profitPercent){
        if(n<=1) return;
        int ans = 0;
        int  i = 0;
        while(i<n-1){

            ans= (profit*profitPercent)/100;
            profit = ans;
            i++;
        }
 
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n =4 , profit = 2000, profitPercent = 50;  //250
        // int n = 3 , profit = 100, profitPercent = 10;   //1  - 

        // Explanation 100 ka 10 %  = 10 transfer to second person ,
        // Now 10 ka 10% - 1(Ans) , transfer to 1st person
        question(n,profit,profitPercent);
    }
}
