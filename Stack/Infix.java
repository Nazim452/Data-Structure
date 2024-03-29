package Stack;

import java.util.Stack;

public class Infix {

    static void operation(Stack<Integer> val, Stack<Character> opr) {
        int val2 = val.pop();
        int val1 = val.pop();

        if (opr.peek() == '+')
            val.push(val1 + val2);
        if (opr.peek() == '-')
            val.push(val1 - val2);
        if (opr.peek() == '*')
            val.push(val1 * val2);
        if (opr.peek() == '/')
            val.push(val1 / val2);
        opr.pop();

    }

    static int calculateInfix(String str) {

        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch==' ') continue;

            int ascii = (int) ch; // ch = 5
            if (ascii >= 48 && ascii <= 57) { // asci= 53
                val.push(ascii - 48);
            }
            //
            else if (opr.size() == 0 || ch == '(' || opr.peek() == '(') {
                opr.push(ch);
            }

            else if (ch == ')') {

                while (opr.peek() != '(') {
                   operation(val, opr);

                }
                opr.pop(); // '(' - remove
            } else {
                if (ch == '+' || ch == '-') {
                    operation(val, opr);
                    opr.push(ch);

                }
                if (ch == '*' || ch == '/') {
                    if (opr.peek() == '*' || opr.peek() == '/') {
                        operation(val, opr);
                        opr.push(ch);

                    } else
                        opr.push(ch);
                }

            }

        }


        
        while (val.size() > 1) {
            operation(val, opr);

        }
        return val.peek();

    }

    public static void main(String[] args) {
        // String str = "9-(5+3)*(4/6)";
        String str = "1 + 1";


        // String str = "6-(3+4)*(5/3)";
        System.out.println(calculateInfix(str));
        ;

    }

}
