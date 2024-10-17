package Practice;

import java.util.Stack;

public class Prefix {

    static void operation(Stack<Integer> val, char op) {
        int val1 = val.pop();
        int val2 = val.pop();

        if (op == '+')
            val.push(val1 + val2);
        else if (op == '-')
            val.push(val1 - val2);
        else if (op == '*')
            val.push(val1 * val2);
        else if (op == '/')
            val.push(val1 / val2);
    }

    static int calculatePrefix(String str) {
        Stack<Integer> st =  new Stack<>();

        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) st.push(ch-'0');

            else {
                operation(st, ch);

            }
        }

        return st.peek();

    }

    public static void main(String[] args) {
        String str = "-9/*+4356";
        System.out.println(calculatePrefix(str));

    }

}
