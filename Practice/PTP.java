package Practice;

import java.util.Stack;

public class PTP {

     static String postToPre(String str) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(Character.isLetter(ch)){
                int actualDigit = ch-'0';
                st.push(actualDigit+"");
            }
            else{
                String val2 = st.pop();
                String val1 = st.pop();
                char opr = ch;
                String t= opr+val1+val2;
                st.push(t);
            }
        }
        
        return st.peek();
    }
    public static void main(String[] args) {
        String str = "953+4*6/-";
        System.out.println(postToPre(str));

        
    }
}
