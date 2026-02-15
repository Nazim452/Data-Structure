package PYQ.Zoho;




public class SOrtingOnFactor {
    static int NoofFactor(int n){
        int count = 0;
        for(int i = 1; i<n; i++){
            if(n%i==0) count++;

        }
        return count;
    }
    static void swap(int []arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void question(int[]arr){

        int  n= arr.length;
        int[] factor = new int[n];

        for(int i = 0;i<n; i++){
            factor[i] =NoofFactor(arr[i]);
        }


        for(int i = 0; i<n;i++){
            for(int j = i+1; j<n;j++){
                if(factor[i]<factor[j]){
                    swap(factor,i,j);
                    swap(arr, i, j);
                }
            }
        }

        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) { 
        int[]arr = {8,2,3,12,16};
        question(arr);
        
    }
    
}
