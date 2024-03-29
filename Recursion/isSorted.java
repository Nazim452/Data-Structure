package Recursion;

public class isSorted {
    static boolean isSoretd(int [] arr , int index){
        if(index == arr.length-1){
            return true;
        }

        // self work

        if(arr[index]<arr[index+1]){
            return isSoretd(arr, index+1);

        }else{
            return false;
        }




      
       
    }
    public static void main(String[] args) {
        int[]arr = {1,2,5,8};
        
    if(isSoretd(arr, 0)){
        System.out.println("yes");
    }
    else{
        System.out.println("No");
    }
        
    }
}
