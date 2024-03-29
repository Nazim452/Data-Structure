package String;

public class ReverseString {
    static String revers_String(String s, int index) {
        if (index == s.length())
            return "";

        return revers_String(s, index + 1) + s.charAt(index);

    }
    public static void main(String[] args) {
        
    }
}
