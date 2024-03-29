package Array;

public class EvenOddArrange {
    
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void  EOsorting(int[] arr ){
        int left =0;
        int right = arr.length-1;
       // for(int i = 0; i<arr.length; i++){
            while(left<right){
                if(arr[left]%2 == 1 && arr[right]%2 == 0){
                    swap(arr, left, right);
                    left ++;
                    right--;
                }
                if(arr[left]%2 == 0){
                    left++;
                }
                if(arr[right]%2 ==1){
                    right--;
                }
            }
        }
    public static void main(String[] args) {
        int[]arr = {2,3,6,1,7,8,9,12};


        EOsorting(arr);
        printArray(arr);

    }
    
}
