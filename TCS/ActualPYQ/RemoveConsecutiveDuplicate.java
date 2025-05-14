package TCS.ActualPYQ;

public class RemoveConsecutiveDuplicate {

   
    public static String question(String str) {
        if (str.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        char prevChar = str.charAt(0);
        result.append(prevChar);

        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar != prevChar) {
                result.append(currChar);
                prevChar = currChar;
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String str = "222223455533222";
        System.out.println(question(str));   
    }
}
