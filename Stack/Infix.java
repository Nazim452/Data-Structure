package Stack;

import java.util.Stack;


// Not wroking for all the test cases______________________





public class Infix {

    static int calculateInfix(String str) {

        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

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
                opr.pop(); // '(' - remove
            } else {
                if (ch == '+' || ch == '-') {
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
                    opr.push(ch);

                }
                if (ch == '*' || ch == '/') {
                    if (opr.peek() == '*' || opr.peek() == '/') {
                        int val2 = val.pop();
                        int val1 = val.pop();

                        // if(opr.peek()=='+') val.push(val2+val1);
                        // if(opr.peek()=='-') val.push(val2-val1);
                        if (opr.peek() == '*')
                            val.push(val1 * val2);
                        if (opr.peek() == '/')
                            val.push(val1 / val2);
                        opr.pop();
                        opr.push(ch);

                    } else
                        opr.push(ch);
                }

            }

        }
        while (val.size() > 1) {
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
        return val.peek();

    }

    public static void main(String[] args) {
        String str = "5-4+3";
        // String str = "6-3+4*(5/3)-(8+9)";
        System.out.println(calculateInfix(str));
        ;

    }

}
