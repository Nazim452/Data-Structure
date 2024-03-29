package Array;

import java.util.Arrays;

public class FIndUnique {
    
    static int unique(int [] arr){
        Arrays.sort(arr);
       
        for(int i = 0; i<arr.length; i++){
            for(int j= i+1; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    arr[i] = -2;    // kuch bhi - me man  sakte hai
                    arr[j] = -2;
                }
            }
        }
        int ans = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]!= -2)
            ans = arr[i];

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { 1,1,5,5,6,11,6,1};
        System.out.println(unique(arr));
        
    }
    
}
