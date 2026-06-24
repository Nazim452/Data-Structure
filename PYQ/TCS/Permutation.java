package PYQ.TCS;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    static void permute(int[] arr, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == arr.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int num : arr) {

            // Can't choose single eleem twize
            if (temp.contains(num))
                continue;
            temp.add(num);
            permute(arr, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        permute(arr, res, new ArrayList<>());
        return res;

    }

    public static void main(String[] args) {

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 7d1ba78 (ALL file done)
