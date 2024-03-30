package HashMap;

import java.util.HashMap;

public class IsomorPhic {

    public static boolean Isisomorphic(String s, String t) {


        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sCH = s.charAt(i);
            char tCH = t.charAt(i);

            if (mp.containsKey(sCH)) {

                if (mp.get(sCH) != tCH) {
                    return false;
                }

            } else if (mp.containsValue(tCH)) {
                return false;
            } else {

                mp.put(sCH, tCH);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabcbc";
        String t = "xxywyw";
        System.out.println(Isisomorphic(s, t));

    }
}
