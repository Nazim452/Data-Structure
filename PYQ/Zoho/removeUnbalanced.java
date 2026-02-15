package PYQ.Zoho;

import java.util.*;

public class removeUnbalanced {

     static String question(String s) {

        Stack<Integer> st = new Stack<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == '(') {
                st.push(i);
            }
            else if (ch[i] == ')') {
                if (st.isEmpty()) {
                    ch[i] = '*';  // mark invalid ')'
                } else {
                    st.pop();     // matched
                }
            }
        }

        // remove unmatched '('
        while (!st.isEmpty()) {
            ch[st.pop()] = '*';
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '*') {
                sb.append(ch[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // String str = "((abc)((de))";
        String str = "(((ab)";
        System.out.println(question(str));;
    }
}


