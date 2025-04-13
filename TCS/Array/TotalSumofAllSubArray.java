package TCS.Array;
  
public class TotalSumofAllSubArray {
    static void printtotalSum(int[]arr){
        int  n = arr.length;
        int totalSum = 0;
        for(int i = 0; i<arr.length; i++){
            int currSum = 0;

            for(int j = i; j<n;j++){
                currSum += arr[j];
                totalSum+=currSum;
            }

        }
        System.out.println(totalSum);
    }
 

    //  OPTIMIZED APPROACH - GFG

    public long subarraySum(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * (i + 1) * (n - i) % MOD;
            sum = (sum + contribution) % MOD;
        }
        
        return sum;
    }
 
 
    public static void main(String[] args) {
        int[]arr ={1,2,3};
        printtotalSum(arr);
        
    }
}
