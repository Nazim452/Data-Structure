package Pattern;

public class Pattern3 {
    static void box(int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1)
                    System.out.print("*");
                else
                    System.out.print(" ````````````");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
    }
}
