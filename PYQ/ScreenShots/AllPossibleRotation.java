import java.util.ArrayList;

public class AllPossibleRotation {

    static void question(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int j = i;
            int count = 0;

            while (count < n) {
                list.add(arr[j]);
                j++;

                if (j == n) { // jump back to start
                    j = 0;
                }

                count++;

            }
            System.out.println(list);
        }

    }

    public static void main(String[] args) {
         int[] arr = { 5, 6, 7, 4, 3 };
        question(arr);

        // O/P - 
// [5, 6, 7, 4, 3]
// [6, 7, 4, 3, 5]
// [7, 4, 3, 5, 6]
// [4, 3, 5, 6, 7]
// [3, 5, 6, 7, 4]
    }

}
