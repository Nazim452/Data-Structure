import java.util.*;

public class RotatedNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input as INTEGER
        long n = sc.nextLong();

        // Convert to string ONLY for processing digits
        String s = String.valueOf(n);
        int len = s.length();

        String rotated = s;

        for (int i = 1; i < len; i++) {
            // Left rotate by one digit
            rotated = rotated.substring(1) + rotated.charAt(0);

            // Convert back to integer to ignore leading zeros
            long value = Long.parseLong(rotated);

            //  int value = Integer.parseInt(rotated);

            System.out.print(value);

            if (i != len - 1) {
                System.out.print(" ");
            }
        }
    }
}
