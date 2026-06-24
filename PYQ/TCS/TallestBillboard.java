package PYQ.TCS;

public class TallestBillboard {
     static int maxHeight =0;

    static int question(int[] arr){
         backtrack(arr, 0 ,0,0);
         return maxHeight;
    }

    static void backtrack(int[] arr , int index , int left , int right){
        if(index==arr.length){
            if(left==right){
                maxHeight = Math.max(maxHeight,right);
            }
            return;
        }

 // option 1: skip rod  
        backtrack(arr, index+1, left, right);
        // option 2: add to left support
        backtrack(arr, index+1, left+arr[index], right);
                // option 3: add to right support
                

        backtrack(arr, index+1, left, right+arr[index]);

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        question(arr);
        System.out.println(maxHeight);
        
    }
    
<<<<<<< HEAD
}
=======
}
>>>>>>> 7d1ba78 (ALL file done)
