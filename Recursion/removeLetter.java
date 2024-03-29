package Recursion;

public class removeLetter {
    // REMOVE "A" FROM STRING BY CUTTING THE STRING ,WITHOURT PASSING INDEX

    static String removeA2(String s) {
        if (s.length() == 0)
            return "";

        /// recursive work

        String smallAns = removeA2(s.substring(1)); // removing a feom the index 1 to last

        // t c of substrin - n

        if (s.charAt(0) != 'a') {
            return s.charAt(0) + smallAns; // ---nz

        } else {
            return smallAns;
        }

    }

    // Second way____________________________________________________________________________
    
    static String removeA(String s, int index){
        // base case


        if(index==s.length()) return " ";

        // recursive work

        String smallAns = removeA(s, index+1);

        // self work

        if(s.charAt(index)!='a'){
            return s.charAt(index)+smallAns;    // CONCANITAION ME TIME O(n)
        }else{
            return smallAns;
        }
    }


//  T C = n*n = O(n^2)         n - length of string



    public static void main(String[] args) {
        
        String s = "abcax";

        // System.out.println(removeA(s, 0));
        // System.out.println(removeA2(s));
        System.out.println(s.substring(1));



    }
}
