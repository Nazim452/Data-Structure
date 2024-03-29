package Recursion;

public class power {
    // CLACULATE P TO THE POWER Q USING RECURSION - --- ALTERNATE APPROACH --- BEST
    // RUNTCOMP

    static int pow1(int p, int q) {

        int ans = pow2(p, q / 2);

        if (q % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * p;
        }
    }

    // t c = O(log q)

    // TIME COMP - O(q) ---OREDER OF Q PE DEPENT KAR RAHA HAI MERA RUNTCOMP

    // SPACE COMP - O(q) -- q KA JITNA VLAUW HOGA UTNA STACK FRAME BANEGA

    static int pow2(int p, int q) {
        if (q == 0) {
            return 1;
        }

        // recursive work

        int ans = pow2(p, q - 1);

        // self work

        int finalAns = ans * p;

        return finalAns;
    }

    // POwerFul Power________________________________________________________
    
    
    static int pow(int p, int q) {
        if (q >= 0) {
            return positive(p, q);
        } else
            return negative(p, q);

    }

    static int positive(int p, int q) {
        if (q == 1)
            return p;

        int ans = pow(p, q / 2);
        if (q % 2 == 0) {
            return ans * ans;
        }
        return ans * ans * p;
    }

    static int negative(int p, int q) {
        if (q == -1)
            return 1 / p;

        int smallAns = negative(p, q / 2);
        if (q % 2 == 0) {
            return smallAns * smallAns;
        }
        return 1 / p * smallAns * smallAns;
    }
  

    public static void main(String[] args) {
        System.out.println(pow(2, -1));

    }

}
