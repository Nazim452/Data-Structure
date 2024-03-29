package Array;

//Error - Not underStandable

public class ProductItself {
    static int[] productExItself(int[]arr){
        int n = arr.length;

        int[] prefix_Prod_st = new int[n] , prefix_Prod_End = new int [n];
        int [] res = new int [n];


        prefix_Prod_st[0] = arr[0];
        for(int i =1; i<n; i++){
            prefix_Prod_st[i]= prefix_Prod_st[i-1]*arr[i];
        }


        prefix_Prod_End[n-1] = arr[n-1];
        for(int i=n-2; n>=0; i--){
            prefix_Prod_End[i]= prefix_Prod_End[i+1]*arr[i];
        }



        res[0] = prefix_Prod_End[1];
        res[n-1] = prefix_Prod_st[n-2];

        for(int i =1; i<=n-1; i++){
            res[i] = prefix_Prod_st[i-1]* prefix_Prod_End[i+1];
        }

        return res;
    }

    
    public static void main(String[] args) {
        int[]arr = { 3,4,5,6};

        int[] res = productExItself(arr);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        
    }
}
