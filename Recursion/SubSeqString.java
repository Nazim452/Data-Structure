package Recursion;

import java.util.ArrayList;

public class SubSeqString {

    // print sub set sequence of string -- best way

    static void string_Sub_Sequqence2(String s, String cuurrentAns) {

        // bas e casae

        if (s.length() == 0) {
            System.out.println(cuurrentAns);
            return;
        }

        char curr = s.charAt(0);

        String remainingString = s.substring(1);

        string_Sub_Sequqence2(remainingString, cuurrentAns + curr); // add current element

        string_Sub_Sequqence2(remainingString, cuurrentAns); // do not add current elem
    }

    // Second Way__________________________________________

    // RETURN SUB STRING SEQUENCE USING ARRAYLIST
    // //SC - 2^n  -- take more space bcz exponential- where n is 3 for abc

    static ArrayList<String> string_Sub_Sequqence(String s) {

        ArrayList<String> ans = new ArrayList<>();
        // base case
        if (s.length() == 0) {
            ans.add(" ");
            return ans;
        }

        char current = s.charAt(0);

        ArrayList<String> smallAns = string_Sub_Sequqence(s.substring(1));
        // smallAns = "Bc", b , c, " "
        // Ans = "Bc", b , c, " " + abc , ab , ac, a

        for (String ss : smallAns) {
            ans.add(ss); // smallAns = "Bc", b , c, " "

            ans.add(current + ss); // Ans = "Bc", b , c, " " + abc , ab , ac, a
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ans = string_Sub_Sequqence(s);
        for(String ss:ans){
           System.out.println(ss);
        }

        // --Second way______

        
        // string_Sub_Sequqence2(s, " ");

    }
}