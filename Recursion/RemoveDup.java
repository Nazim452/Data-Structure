package Recursion;

public class RemoveDup {
    static void removeDup(String str, int index, StringBuilder newStr, boolean[] track) {
        if (index == str.length()) {
            System.out.println(newStr);
            return;
        }
        char curr = str.charAt(index);
        if (track[curr - 'a'] == true)
            removeDup(str, index + 1, newStr, track);
        else {
            track[curr - 'a'] = true;
            removeDup(str, index + 1, newStr.append(curr), track);
        }

    }
    public static void main(String[] args) {
        String st = "abbcefebfff";
        removeDup(st, 0, new StringBuilder(" "), new boolean[st.length()]);
    }
}
