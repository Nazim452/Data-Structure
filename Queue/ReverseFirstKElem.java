package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElem {
    public static void main(String[] args) {
        

        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        //int n =st.size();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;   // 3 2 1 4 5
        System.out.println(q);

        while(q.size()>=k){
            st.push(q.remove());
        }

        while(st.size()>0){
            q.add(st.pop());
        }
        for(int i = 0; i<q.size()-k; i++){
            q.add(q.remove());
        }

       
       

        System.out.println(q);



    }
    
}
