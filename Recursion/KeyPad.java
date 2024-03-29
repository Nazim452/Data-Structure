package Recursion;

public class KeyPad {
    static void keyPadSolving(String digit, String[] keyPad, String currAns) {
        if (digit.length() == 0) {
            System.out.println(currAns);
            return;
        }
        int currChar = digit.charAt(0) - '0';
        String currString = keyPad[currChar];

        for (int i = 0; i < currString.length(); i++) {
            keyPadSolving(digit.substring(1), keyPad, currAns + currString.charAt(i));
        }

    }
    public static void main(String[] args) {
        String[] kp = {"", " ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        keyPadSolving("23", kp, " ");
        
    }
}
