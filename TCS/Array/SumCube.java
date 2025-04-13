package TCS.Array;

public class SumCube {
    static void calcSUmCUbe(int n, int m) {

        int cube = 0;

        for (int i = n; i <= m; i++) {
            int currentCube = i * i * i;
            cube += currentCube;

        }

        System.out.println("Cube" + cube);
    }

    static void calcSUmCUbe1(int n, int m) {

        int cube = 0;

        for (int i = n; i <= m; i++) {
            int currentCube = (int) Math.pow(i, 3);
            cube += currentCube;

        }

        System.out.println("Cube" + cube);
    }                                                                      

    public static void main(String[] args) {

        calcSUmCUbe(4, 9);

    }
}
