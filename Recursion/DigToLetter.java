package Recursion;

public class DigToLetter {
    static void digitToletter(int n) {
        if (n == 0)
            return;

        String digit[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };

        digitToletter(n / 10);
        System.out.print(digit[n % 10] + " ");

    }
    public static void main(String[] args) {
        int n = 123;
        digitToletter(n);
        
    }
}
