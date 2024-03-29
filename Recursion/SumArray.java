package Recursion;

public class SumArray {
    
// SUM OF ARRAY

static int sumOfArray(int[] arr, int index){

    // base case

    if(index == arr.length-1){
        return arr[index];
    }

    // recursive work


    int ans =sumOfArray(arr, index+1);


    //self work

    return ans+arr[index];


}
   public static void main(String[] args) {
    int [] arr = {1,2,3};
    System.out.println(sumOfArray(arr, 0));
    
   } 
}
