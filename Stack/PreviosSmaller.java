package Stack;

import java.util.Stack;

public class PreviosSmaller {
    static void prinArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    static void PreviosSmallerIndex(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = -1;

        for (int i = 1; i<ans.length; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();

            }
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        prinArr(ans);

    }
    

    public static void main(String[] args) {
        // int[]ar = {5,2,4,6,3,5};


    }

}
