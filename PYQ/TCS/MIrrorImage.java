package PYQ.TCS;

import java.util.HashMap;

public class MIrrorImage {

    static void mirrorImage(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char opposite = (char) ('A' + 'Z' - ch);
            map.put(ch, opposite);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);

            char value = map.get(ch);
            sb.append(value);

        }
        System.out.println(sb.toString());

    }


     static void mirrorImage2(String str) {

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < str.length(); i++){

        char ch = str.charAt(i);

        char opposite = (char)('A' + 'Z' - ch);

        sb.append(opposite);
    }
     }
    public static void main(String[] args) {

        String str = "ABCDEF";
        mirrorImage(str);
        
    } 
    
}
