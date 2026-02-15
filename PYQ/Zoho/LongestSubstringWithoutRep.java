package PYQ.Zoho;

public class LongestSubstringWithoutRep {

    public static int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256]; // Reset for each start index
 
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);

                if (visited[ch]) {
                    break; // Duplicate found, stop expanding
                }

                visited[ch] = true;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "ABCABCBB";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Longest substring length: " + result);
    }
}
