package Array;

public class PreviosSum {
    static void prevSum(int[]arr){
        
        for(int i =1; i<arr.length; i++){
            arr[i]= arr[i]+arr[i-1];

        }
    }
    public static void main(String[] args) {
        int[]arr ={ 4,5,6,7};
        prevSum(arr);
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
    
}
