package Pattern;

public class Pattern8 {
    static void ddo(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        
    }
    
}
