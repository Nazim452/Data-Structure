package Recursion;

public class TIlingProb {
    static int tilingProb(int n) {
        if (n == 0 || n == 1)
            return 1;

        // verticla chouice
        int ver = tilingProb(n - 1);
        int hor = tilingProb(n - 2);
        int totalwahy = ver + hor;
        return totalwahy;
    }

    public static void main(String[] args) {
        System.out.println(tilingProb(3));

    }
}
