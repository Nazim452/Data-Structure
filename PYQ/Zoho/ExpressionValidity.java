package PYQ.Zoho;
// if (!(isOperand(prev) || prev == ')'))(a)
//     return false;

// if (!(isOperand(next) || next == '('))
//     return false;
// Let’s understand why these are needed.

// 🔷 What This Code Is Checking
// This code runs when the current character is an operator like:

// +  -  *  /
// We are checking whether the operator is placed correctly.

// 🔷 Rule of a Valid Operator
// In a valid expression:

// An operator must:

// 👉 Have a valid left side
// 👉 Have a valid right side

// Meaning:

// LEFT  OPERATOR  RIGHT
// Where:

// LEFT can be:

// an operand (like a)

// or a closing bracket )

// RIGHT can be:

// an operand (like b)

// or an opening bracket (

// 🔷 First Line Explanation
// if (!(isOperand(prev) || prev == ')'))
//     return false;
// What it means:
// The character BEFORE the operator must be:

// either a letter (operand)

// or a closing bracket

// ✅ Valid Example
// a + b
// For +:

// prev = a

// isOperand(a) → true
// ✔ Valid

// (a+b) * c
// For *:

// prev = )

// prev == ')' → true
// ✔ Valid

// ❌ Invalid Example
// +a
// For +:

// prev does not exist
// ❌ Invalid

// ( + a )
// For +:

// prev = (

// Not operand

// Not )
// ❌ Invalid

// That is why we need this check.

// 🔷 Second Line Explanation
// if (!(isOperand(next) || next == '('))
//     return false;
// What it means:
// The character AFTER the operator must be:

// an operand

// or an opening bracket

// ✅ Valid Example
// a + b
// For +:

// next = b
// ✔ Valid

// a * (b+c)
// For *:

// next = (
// ✔ Valid

// ❌ Invalid Example
// a +
// For +:

// no next character
// ❌ Invalid

// a + )
// For +:

// next = )

// Not operand

// Not (
// ❌ Invalid
import java.util.*;

public class ExpressionValidity {

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    static boolean isValidExpression(String expr) {

        Stack<Character> stack = new Stack<>();

        int n = expr.length();

        if (n == 0) return false;

        for (int i = 0; i < n; i++) {

            char ch = expr.charAt(i);

            // Check parentheses
            if (ch == '(') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }

            // Check operator rules
            if (isOperator(ch)) {

                // Cannot be first or last
                if (i == 0 || i == n - 1)
                    return false;

                char prev = expr.charAt(i - 1);
                char next = expr.charAt(i + 1);

                // Operator cannot follow another operator
                if (isOperator(prev) || isOperator(next))
                    return false;

                // Operator must have valid operand or ')'
                if (!(isOperand(prev) || prev == ')'))
                    return false;

                if (!(isOperand(next) || next == '('))
                    return false;
            }
        }

        // Parentheses must be balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isValidExpression(input))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}

