package Array;

public class Partition {
    
    static int ArraySum(int[] arr){
        int TotSum = 0;
        for(int i = 0; i<arr.length ; i++){
            TotSum = TotSum+ arr[i];

        }
        return TotSum;
    }
    static boolean PartitionSumArr(int[] arr){

        int TotSum = ArraySum(arr);

        int prefsum = 0; 
        for(int i = 0; i < arr.length; i++){
            prefsum = prefsum + arr[i];

            int suffSum = TotSum - prefsum;

            if(suffSum == prefsum){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {15,5,6,4,8,2};
        System.out.println("Equal partition of array possible -  " + PartitionSumArr(arr));
        
    }
    
}
