package PYQ.Zoho;

public class StringCountWord {
     static void question(String str) {

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < str.length()) {

            // Step 1: Get character
            char ch = str.charAt(i);
            i++;

            // Step 2: Read full number (can be multiple digits)
            int num = 0;
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                num = num * 10 + (str.charAt(i) - '0');
                i++;
            }

            // Step 3: Repeat character
            for (int j = 0; j < num; j++) {
                ans.append(ch);
            }
        }

        System.out.println(ans.toString());
    }
    public static void main(String[] args) {
        String str = "b3c6d8";
        question(str);
        
    }
}
