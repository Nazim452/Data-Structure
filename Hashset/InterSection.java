package Hashset;

import java.util.HashSet;

public class InterSection {
    static void intersectn(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);

        }
        int count = 0;

        for (int i = 0; i < b.length; i++) {
            if (set.contains(b[i])) {
                System.out.print(b[i] + " ");
                count++;
                // set.remove(b[i]);
            }

        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 3, 4, 6, 8 };
        intersectn(a, b);

    }
}
