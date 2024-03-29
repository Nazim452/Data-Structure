package Recursion;

public class MaxELem {
    // PRINT MAX ELEM FROM ARRAY

   static int maxArray(int [] arr, int index){

    // base case

    if(index == arr.length-1){
        return -1;
    }

    // recursive work - small prob

    int ans = maxArray(arr, index+1);



    // self work 

   return Math.max(ans, arr[index]);
   }
    public static void main(String[] args) {
        int [] arr = {1,2,3,45,78,56};
        System.out.println(maxArray(arr, 0));
        
    }
}
