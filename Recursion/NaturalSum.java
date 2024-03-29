package Recursion;

public class NaturalSum {
    static int naturalNo(int n) {
        if (n == 1)
            return 1;
        int ans = naturalNo(n - 1);
        int finalAns = ans + n;
        return finalAns;
    }

    //M-|| - Iterative
    static int naturalNo2(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += i;

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(naturalNo(4));
        
    }
}
