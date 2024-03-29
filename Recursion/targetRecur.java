package Recursion;

public class targetRecur {
    
    static int  searchArray1 (int[]arr, int n , int target, int index){
        if(index>=n){
            return -1;
        }

        if(arr[index]==target){
            return index;
        }

       return searchArray1(arr, n, target, index+1);
    }

    public static void main(String[] args) {
        
    }
    
}
