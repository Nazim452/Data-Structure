package Pattern;

public class Pattern6 {
    static void number(int n) {
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(counter);
                counter++;
            }
            counter = 1;
            System.out.println();
        }
    }
    public static void main(String[] args) {

    }
}
