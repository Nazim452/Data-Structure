package Practice;

import java.util.Stack;

public class Infix {

    static void operation(Stack<Integer> val, Stack<Character> opr) {
        int val2 = val.pop();
        int val1 = val.pop();

        char op = opr.pop(); // Get and remove the operator

        if (op == '+')
            val.push(val1 + val2);
        else if (op == '-')
            val.push(val1 - val2);
        else if (op == '*')
            val.push(val1 * val2);
        else if (op == '/')
            val.push(val1 / val2);
    }

    static int precednec(char opr) {
        if (opr == '+' || opr == '-')
            return 1;
        else if (opr == '*' || opr == '/')
            return 2;
        else
            return 0;
    }

    static int  calculateInfix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;

                }
                val.push(num);
                i--;

            }

            else if(ch=='(') opr.push(ch);
            else if(ch==')'){
                while (opr.peek()!='(') {
                    operation(val, opr);
                    
                }
                opr.pop();
            }

            else{
                while (!opr.isEmpty() && precednec(ch)<= precednec(opr.peek())) {
                    operation(val, opr);
                    
                }
                opr.push(ch);
            }
        }

        while (!opr.isEmpty()) {
            operation(val, opr);
            
        }
        return val.peek();
    }

    public static void main(String[] args) {
        String str = "980+786-(9+0)-90+56-3";
        System.out.println(calculateInfix(str));

        System.out.println("Print statement");
        System.out.println(980+786-(9+0)-90+56-3);

    }
}
