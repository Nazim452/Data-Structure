// QUESTION 3: Layoff Based on Performance Ratio
// 🔷 Clean Problem Statement

// A company has n employees.

// Each employee has:

// experience[i]

// projects[i]

// An employee is underperforming if:

// projects < experience × k


// Where:

// k is initial performance ratio.

// Company must remove at least R underperforming employees.

// If current k is not enough:

// Increase k by 1 repeatedly

// Until at least R employees are underperforming.

// Return:

// k is increased by X

// 🔷 Sample Test Case

// Input:

// 5
// 2 4 3 5 1
// 3 5 2 6 1
// 1
// 2


// Output:

// k is increased by 1
import java.util.*;

public class LayOff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] exp = new int[n];
        int[] proj = new int[n];

        for(int i = 0; i < n; i++)
            exp[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            proj[i] = sc.nextInt();

        int k = sc.nextInt();
        int R = sc.nextInt();

        int originalK = k;

        while(true) {
            int count = 0;

            for(int i = 0; i < n; i++) {
                if(proj[i] < exp[i] * k)
                    count++;
            }

            if(count >= R)
                break;

            k++;
        }

        System.out.println("k is increased by " + (k - originalK));
    }
}
