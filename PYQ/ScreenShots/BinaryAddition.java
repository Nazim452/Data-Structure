import java.util.Scanner;

public class BinaryAddition{
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += str1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += str2.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        System.out.println(result.reverse().toString());
        sc.close();
    }

}