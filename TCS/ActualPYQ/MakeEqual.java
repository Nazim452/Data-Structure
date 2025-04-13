package TCS.ActualPYQ;

import java.util.Arrays;

// We have three integers: a, b, c.

// We can select any two numbers and:

// Increase both selected numbers by 1.

// Decrease the remaining number by 1.

// The goal is to check whether we can make all three numbers equal.

public class MakeEqual {

    public static boolean canMakeEqual(int a, int b, int c) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);

        if (arr[0] == arr[1] && arr[1] == arr[2])
            return true;
        int steps = 0;

        while (true) {
            arr[0] += 1;
            arr[1] += 1; // Smallest me 1 add , large me 1 substract to make equal
            arr[2] -= 1;

            steps += 1;
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Steps Taken " + steps);
                return true;

            }

            // Edge cases

            if (arr[0] == arr[1] && arr[1] + 1 == arr[2])
                return false;

            // This condtion also can be added - [2,3,3]

            // || arr[1]==arr[2] && arr[0]+1 == arr[1]

        }

    }

    static void range(int a, int b) {

        int ans = 0;

        if (a>= 0 && b < 9999) {
            // for (int i = a; i <= b; i++) {
            //     ans += i;
            // }

            ans = (b*(b+1)/2)-(a*(a-1))/2;

            System.out.println("ANs  " + ans);

        } else
            System.out.println("Inavalid Input");
 
    }

    public static void main(String[] args) {

        // System.out.println(canMakeEqual(1, 2, 3));
        // System.out.println(canMakeEqual(2, 3, 3));
       range(4, 8);

    }

}
