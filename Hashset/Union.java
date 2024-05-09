package Hashset;

import java.util.HashSet;

public class Union {
    static void union(int[] a, int[] b) {
        HashSet<Integer> union = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            union.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            union.add(b[i]);
        }
        System.out.println("Size of union is "+union.size());
        System.out.println(union);

    }

    public static void main(String[] args) {
        int[]a ={1,3,5};
        int[]b = {1,2,4,5};


        union(a, b);// 1 2 3 4 5
    }
}
