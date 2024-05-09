package Greedy;

import java.util.Arrays;
import java.util.Collections;

// Not desired output

public class ChocolaProb {
    static void chocolaProbbb(Integer[] costVer, Integer[] costHor) {
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0, hp = 1, vp = 1, cost = 0;

        while (h < costHor.length && v < costVer.length) {

            if (costVer[v] <= costHor[h]) { // horizonatal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }

            else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costVer = { 2, 1, 3, 1, 4 };  //m-1
        Integer[] costHor = { 4, 1, 2 };   //n-1

        chocolaProbbb(costVer, costHor);

    }
}
