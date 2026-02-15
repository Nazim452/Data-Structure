package PYQ.String;

import java.util.HashSet;

public class LongestSubstringWithoutRept {
  static int betterBrute(String s) {

    int n = s.length();
    int maxLen = 0;

    for (int i = 0; i < n; i++) {

        HashSet<Character> set = new HashSet<>();

        for (int j = i; j < n; j++) {

            char ch = s.charAt(j);

            if (set.contains(ch)) break;

            set.add(ch);
            maxLen = Math.max(maxLen, j - i + 1);
        }
    }

    return maxLen;
}
    public static void main(String[] args) {

        String str = "abcddabac";
        System.out.println(betterBrute(str));; //4
        
    }
}
