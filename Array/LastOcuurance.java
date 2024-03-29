package Array;

public class LastOcuurance {
    static int lastOccurance(int[] arr, int x){
        int lastIndex = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==x){
                lastIndex = i;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args) {
        int [] arr =  { 12, 3,4, 56, 3,12, 12, 12};
        System.out.println("Last occurasnce of x is  " + lastOccurance( arr, 3));
        
    }
    
}
