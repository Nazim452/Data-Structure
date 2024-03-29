package Array;

public class StockCell2 {
    static int maxProfitII(int[]arr){
        
        int maxProf = 0;

        for(int i=1; i<arr.length; i++){

            if(arr[i]>arr[i-1]){
                maxProf+=arr[i]-arr[i-1];

            }
        }


        return maxProf;
    }
  
    public static void main(String[] args) {
        
        int []arr = { 5,2,6,1,4,7,3,6};
        System.out.println(maxProfitII(arr));

        
    }
    
}
