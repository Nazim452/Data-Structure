package TCS.ActualPYQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUnique {
    // O(n^2)
    
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


    static int uniqueUsingSorting(int[] arr) {
        Arrays.sort(arr);
        
        // Check first element
        if (arr.length == 1 || arr[0] != arr[1]) {
            return arr[0];
        }
        
        // Check middle elements
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i-1] && arr[i] != arr[i+1]) {
                return arr[i];
            }
        }
        
        // Check last element
        if (arr[arr.length-2] != arr[arr.length-1]) {
            return arr[arr.length-1];
        }
        
        return -1; // No unique element found
    }

    
// O(n)


static int map(int[]arr){
    int n = arr.length;
    HashMap<Integer , Integer> map = new HashMap<>();

    for(int i = 0;i<n; i++){
        map.put(arr[i], map.getOrDefault(arr[i],0)+1);

    }

    for(var data :map.entrySet()){
        int value = data.getValue();

        if(value==1) return data.getKey();

    }
    return -1;
}
    public static void main(String[] args) {
        // int[] arr = { 1,1,5,5,6,11,6};
        int[] arr = { 2,2,3,3,3,4,4,4,4,5,5,6};
        System.out.println(map(arr)); //1
        
    }
    
}
