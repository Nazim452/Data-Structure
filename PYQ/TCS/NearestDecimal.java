package PYQ.TCS;

import java.util.Scanner;

public class NearestDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();

        System.out.printf("%.2f", input);

        // I/p - 9.7854
        // O/p - 9.79  (nearst 2 digit)

        // I/P - 3.1421
        // O/P - 3.14
    }
}