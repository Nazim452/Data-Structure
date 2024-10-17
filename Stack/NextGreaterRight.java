package Stack;

import java.util.Stack;

public class NextGreaterRight {
    static void printArray(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            
        }
    }

    static void next_GreaterElem(int[]arr){
        int[] res = new int[arr.length];

        for(int i = 0; i<res.length; i++){
            res[i] = -1;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]>arr[i]) {
                    res[i] = arr[j];
                    break;

                }
            }
        }
        printArray(res);
        // return res;
    }
    public static int[] next_Greater(int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[arr.length];

        res[n-1] = -1;

        st.push(arr[n-1]);

        for(int i = n-2;i>=0; i--){
            while( st.size()>0&&st.peek()<arr[i]  ){
                st.pop();
            }
            if(st.size()==0) res[i] = -1;

            else res[i] = st.peek();
            st.push(arr[i]);

            
        }



        return res;
    }
   
    public static int[] next_GreateCircular(int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[arr.length];

        // res[n-1] = -1;

        st.push(arr[n-1]);

        for(int i = 0; i<n; i++){
            if(arr[i]>res[n-1]) res[n-1] = arr[i];

        }

        for(int i = n-2;i>=0; i--){
            while( st.size()>0&&st.peek()<arr[i]  ){
                st.pop();
            }
            if(st.size()==0) res[i] = -1;

            else res[i] = st.peek();
            st.push(arr[i]);

            
        }



        return res;
    }
   
    public static void main(String[] args) {
        int []arr = {1,5,3,2,1,6,3,4};
        int [] res= next_Greater(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
            
        }    
        System.out.println();
        int [] res2= next_GreateCircular(arr);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i]+" ");
            
        }    
        System.out.println();
       
        
    }
    
}
