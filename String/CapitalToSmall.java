package String;

// import java.util.Scanner;

public class CapitalToSmall {
    static void capital(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            boolean flag = true; // capital
            char ch = str.charAt(i);
            // if(ch ='') continue;

            int ascii = (int) ch;
            if (ascii >= 97)
                flag = false; // small

            if (flag == true) {
                ascii += 32;
                char dh = (char) ascii;
                str.setCharAt(i, dh);
            } else {
                ascii -= 32;
                char dh = (char) ascii;
                str.setCharAt(i, dh);
            }
        }
    }

    static void capital3(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int ascii = (int) ch;
            if (ascii >= 97 && ascii <= 122) {
                ascii -= 32;
                char dh = (char) ascii;

                sb.setCharAt(i, dh);
            }
            else{
                ascii+=32;
                char dh = (char) ascii;
                sb.setCharAt(i, dh);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // StringBuilder str = new StringBuilder("PhySiCs");
        String str = "PhySiCs";
        capital3(str);

    }
}
