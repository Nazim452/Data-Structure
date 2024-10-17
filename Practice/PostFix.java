package Practice;

import java.util.Stack;

public class PostFix {
      static void operation(Stack<Integer> val, char op) {
        int val2 = val.pop();
        int val1 = val.pop();

        if (op == '+')
            val.push(val1 + val2);
        else if (op == '-')
            val.push(val1 - val2);
        else if (op == '*')
            val.push(val1 * val2);
        else if (op == '/')
            val.push(val1 / val2);
    }

    static int calculatePostfix(String str){
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(Character.isDigit(c)) st.push(c-'0');
            else {
                operation(st, c);
            }

        }

        return st.peek();
    }
    public static void main(String[] args) {
        String str = "953+4*6/-";

        System.out.println(calculatePostfix(str));
        
    }
}
