import java.util.*;

public class Problem50OPtimized {

    // Interview-Ready Explanation

// Since the digits are only 0 and 5, for divisibility by 90 we need at least
//  one 0 and the number of 5s 
//  must be a multiple of 9. To maximize the number,
//   we use the maximum such group of 5s, followed by all zeros.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count5 = 0, count0 = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            if (d == 5) count5++;
            else if (d == 0) count0++;
        }

        // Must have at least one 0
        if (count0 == 0) {
            System.out.println(-1);
            return;
        }

        // Max multiple of 9 we can take
        int usable5 = (count5 / 9) * 9;

        // If no valid group of 9 fives, we can only print 0
        if (usable5 == 0) {
            System.out.println(0);
            return;
        }

        // Print largest number
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < usable5; i++) sb.append('5');
        for (int i = 0; i < count0; i++) sb.append('0');

        System.out.println(sb.toString());
    }
}
