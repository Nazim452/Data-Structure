package Array2D;
import java.util.ArrayList;

public class Pascal2LeetCode {
    static ArrayList<ArrayList<Integer>> pascalTr(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> result = pascalTr(n);
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}
