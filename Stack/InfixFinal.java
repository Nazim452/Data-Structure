package Stack;

import java.util.Stack;

public class InfixFinal {

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

    static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    static int calculateInfix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') continue;

            // Multi-digit number handling
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - 48);
                    i++;
                }
                val.push(num);
                i--; // Adjusting the index after reading digits
            } else if (ch == '(') {
                opr.push(ch);
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    operation(val, opr);
                }
                opr.pop(); // Remove the '('
            } else {
                // While the precedence of the current operator is less than or equal to
                // the precedence of the operator on top of the stack, evaluate the top operator.
                while (!opr.isEmpty() && precedence(opr.peek()) >= precedence(ch)) {
                    operation(val, opr);
                }
                opr.push(ch); // Push the current operator
            }
        }

        // Perform remaining operations in the stack
        while (!opr.isEmpty()) {
            operation(val, opr);
        }

        return val.peek();
    }

    public static void main(String[] args) {
        // String str = "9-10+15-3";
        String str = "67+90-10*2/6";

        System.out.println(calculateInfix(str)); // Should output 11
        System.out.println(67+90-(10*2)/6);
    }
}

