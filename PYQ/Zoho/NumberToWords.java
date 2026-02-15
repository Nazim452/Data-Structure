package PYQ.Zoho;

import java.util.Scanner;

public class NumberToWords {

    static String[] units = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convertToWords(int num) {

        if (num < 0 || num > 999) {
            return "Number out of range";
        }

        if (num < 20) {
            return units[num];
        }

        if (num < 100) {
            return tens[num / 10] + 
                   (num % 10 != 0 ? " " + units[num % 10] : "");
        }

        // For 100–999
        String result = units[num / 100] + " Hundred";

        if (num % 100 != 0) {
            result += " and " + convertToWords(num % 100);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number (0-999): ");
        int number = sc.nextInt();

        System.out.println("Output: " + convertToWords(number));
        sc.close();
    }
}

