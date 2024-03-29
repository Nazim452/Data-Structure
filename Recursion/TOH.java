package Recursion;

public class TOH {
    static void toh(int n, String src, String help, String dest) {
        if (n == 1) {
            System.out.println("TransFer disk:-  " + n + " from " + src + " to " + dest);
            return;

        }
        toh(n - 1, src, dest, help);

        System.out.println("TransFer disk:-  " + n + " from " + src + " to " + dest);
        // toh(1, src, help, dest);
        toh(n - 1, help, src, dest);
    }
    public static void main(String[] args) {
        toh(3, "S", "H", "D");
        
    }
}
