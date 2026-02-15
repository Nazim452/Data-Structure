import java.util.Arrays;

public class FirstKElemSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void question(int[] arr, int k ){
        int n = arr.length;

      

        for(int i = 0; i<k ; i++){
           for(int j = i; j<k; j++){
             if(arr[i]>arr[j]) swap(arr, i, j);
           }
        }

        // OR

        Arrays.sort(arr,0,k);

       

        printArray(arr);
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int k = 5;
        question(arr, k);
        
    }
}
