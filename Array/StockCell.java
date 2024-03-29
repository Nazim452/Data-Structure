package Array;

// tc = o(n) , space constant = o(1)

public class StockCell {
    static int maxProfit(int[]arr){
        int maxProf = 0;

        int minBuy = arr[0];

        for(int i =0; i<arr.length; i++){
            minBuy = Math.min(minBuy, arr[i]);

            int profit = arr[i]- minBuy;

            maxProf = Math.max(maxProf, profit);
        }

        return maxProf;
    }
    public static void main(String[] args) {
        int[]arr = { 5,2,6,1,4};
        System.out.println(maxProfit(arr));
        
        
    }
    
}
