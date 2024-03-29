package Array;

// print square of array elemant in increasing order -- if array element in may be negative

public class SquareIncreasing {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    static int[]  square(int[] arr){
        int left = 0 , right = arr.length -1;

        int[] ans = new int[arr.length];
        int k = arr.length-1;


        while(left<=right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                ans[k--] = arr[left]* arr[left];
                left++;
            }else{
                ans[k--] = arr[right]*arr[right];
                right--;
            }
            
        }
    for(int i = 0; i<ans.length; i++){
          System.out.print(ans[i]+" ");
      }
    
        return ans;
    }
    public static void main(String[] args) {
        int[]arr ={-3,-2,-1,0,1,2,6,8};
        square(arr);
        // printArray(ans);
        
    }
    
}
