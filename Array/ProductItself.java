package Array;

//Error - Not underStandable

public class ProductItself {
   
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] product(int[]arr){
        int n = arr.length;
        int l[] = new int[n];
        l[0] = 1;
        for(int i =1; i<n; i++){
            l[i] =l[i-1]*arr[i-1];
        }

        int r[]= new int[n];
        r[n-1] =1;
        for(int i = n-2; i>=0; i--){
            r[i] =r[i+1]*arr[i+1];
        }

        int[]ans = new int[n];
        for(int i= 0; i<n; i++){
            ans[i] =l[i]*r[i];

          
        }
        System.out.print("Left arrays"+"   ");
        printArray(l);
        System.out.println();
        System.out.print("Right arrays    ");
        printArray(r);
        System.out.println();
        
          return ans;
     
    }
    
    public static void main(String[] args) {
        int[]arr = { 1,2,3,4};

        int[] res = product(arr);
         printArray(res);
        
    }
}
