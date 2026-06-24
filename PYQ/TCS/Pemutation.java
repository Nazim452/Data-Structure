package PYQ.TCS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pemutation {
    static int count = 0;

    static int findFactorial(int n) {
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * i;
            count++;
        }
        return ans;
    }

    static void question(int n, int r) {

        int f = findFactorial(r);
        List<Integer> list = new ArrayList<>();
        list.add(n);

        while (count > 1) {
            list.add(n - 1);
            count--;
            n--;

        }
        int numr = 1;

        for (int num : list)
            numr = numr * num;
        System.out.println(numr / f);
    }

    static void nCr(int n, int r) {

        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < r; i++) {
            numerator *= (n - i);
            denominator *= (i + 1);
        }

        System.out.println(numerator / denominator);
        ;
    }

    
   

   public static void main(String[] args) {
        

    }
}
