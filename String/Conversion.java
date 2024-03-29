package String;

public class Conversion {
    static void conversion(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) (ch);
            if (ch == ' ')
                continue;

            if (ascii >= 97) {
                ascii = ascii - 32;
                char dh = (char) (ascii);
                str.setCharAt(i, dh);
            } else {
                ascii = ascii + 32;
                char dh = (char) (ascii);
                str.setCharAt(i, dh);
            }

        }
        System.out.println(str);
    }

    public static void main(String[] args) {

    }
}
