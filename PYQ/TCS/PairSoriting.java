package PYQ.TCS;

import java.util.*;

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class PairSoriting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of pairs
        int n = sc.nextInt();

        List<Pair> list = new ArrayList<>();

        // Input pairs
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Pair(a, b));
        }

        // Custom Sorting (Lexicographical)
        // Collections.sort(list, (p1, p2) -> {

        //     if (p1.a == p2.a) {
        //         return p1.b - p2.b;   // sort by second
        //     }

        //     return p1.a - p2.a;       // sort by first
        // });

        Collections.sort(list, (p1,p2)->{
            if(p1.a==p2.a) return p1.b-p2.b;

            return p1.a-p2.a;

        });

        // Print result
        for (Pair p : list) {
            System.out.println(p.a + " " + p.b);
        }

        sc.close();
    }
}

  