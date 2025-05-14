package TCS.ActualPYQ;

public class RangeSumQuery {

    static void range(int a, int b) {

        int ans = 0;

        if (a >= 0 && b < 9999) {
            // for (int i = a; i <= b; i++) {
            // ans += i;
            // }

            // For a=5 and b=10:

            // Sum from 1 to 10: 10*11/2 = 55

            // Sum from 1 to 4: 4*5/2 = 10

            // Sum from 5 to 10: 55 - 10 = 45 (correct)

            // 5+6+7+8+9+10 = 45

            ans = (b * (b + 1) / 2) - (a * (a - 1)) / 2;

            System.out.println("Ans  " + ans);

        } else
            System.out.println("Inavalid Input");

    }

    public static void main(String[] args) {
        range(2, 6);
        
    }
    
}
