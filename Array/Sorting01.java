package Array;

public class Sorting01 {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    static void sorting(int[] arr){
        int zeroes = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] ==0){
                zeroes++;
            }
        }
        for(int i = 0; i<arr.length; i ++){
            if(i<zeroes){
                arr[i] =0;
            }else{
                arr[i] = 1;
            }
        }
    }
    public static void main(String[] args) {
        
        int[]arr = {1,1,0,0,1,1,0};
        sorting(arr);
        printArray(arr);

    }
    
}
