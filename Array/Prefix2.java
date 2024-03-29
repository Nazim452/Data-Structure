package Array;

public class Prefix2 {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    

    static int[] prefixArray2(int[] arr){
        
        for(int i = 1; i<arr.length; i++){
            arr[i] = arr[i-1]+ arr[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7};
        int[]ans= prefixArray2(arr);
        printArray(ans);
        
    }
    
}
