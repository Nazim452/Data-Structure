package PYQ.TCS;

public class findCheckPoint {

    static int findTotalSUm(int[] arr){
        int sum   = 0;
        for(int num:arr) sum+=num;
        return sum;
    }
    
    static void question(int[] arr){
        int n = arr.length;

        int totalSUm = findTotalSUm(arr);
        int prefixSum = 0;
        for(int i = 0;i<n; i++){
            
            int suffixSUm  = totalSUm-prefixSum-arr[i];
            
            if(prefixSum==suffixSUm){
                System.out.println(i);
                return;
            }
            prefixSum = prefixSum+arr[i];
        }
    }


    static int findPartitionIndex(int[] arr){

        int totalSum = findTotalSUm(arr);

        // If total sum is odd, equal partition not possible
        if(totalSum % 2 != 0) return -1;

        int prefixSum = 0;

        for(int i = 0; i < arr.length - 1; i++){ 
            // arr.length - 1 because right side must not be empty
            prefixSum += arr[i];

            if(prefixSum == totalSum / 2){
                return i;   // partition happens after index i
            }
        }

        return -1;  // No partition found
    }


     static int findCheckpoint(int[] arr) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

   
    public static void main(String[] args) {
      
        // System.out.println(findCheckpoint(arr));;
      
        
    }
}
