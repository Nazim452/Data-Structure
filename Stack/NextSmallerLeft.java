package Stack;

import java.util.Stack;

public class NextSmallerLeft {

    static void prinArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            
        }
        System.out.println();
    }
    static void NextSmallerIndex(int[]arr){
        int n = arr.length;

        int[]ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        ans[n-1] = n;

        for(int i = n-2; i>=0; i--){
            while (st.size()>0 && arr[st.peek()]>=arr[i]) {
                st.pop();
                
            }
            if(st.size()==0) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        prinArr(ans);


       

    }
    static void NextSmallerElement(int[]arr){
        int n = arr.length;

        int[]ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        ans[0] = -1;

        for(int i = 1; i<n;i++){
            while (st.size()>0 && arr[st.peek()]>=arr[i]) {
                st.pop();
                
            }
            if(st.size()==0) ans[i] = -1;
            else ans[i] = arr[st.peek()];
            st.push(i);
        }
        prinArr(ans);


       

    }
    public static void main(String[] args) {
        int[]arr = {5,2,4,6,3,5};
        NextSmallerElement(arr);

       
        
       
        
    }
    
}
