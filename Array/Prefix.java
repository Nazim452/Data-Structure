package Array;

public class Prefix {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int[] prefixArray(int[] arr){
        int[] pref = new int[arr.length];
        pref[0] = arr[0];

        for(int i = 1; i<arr.length; i++){
            pref[i] =    + arr[i];
        }
        return pref;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7};
        int[]ans= prefixArray(arr);
        printArray(ans);
        
    }
    
}
