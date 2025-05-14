package TCS.ActualPYQ;

import java.util.*;

public class SymmetryPair {

  public static List<List<Integer>> findSymmetricPairs(int[][] pairs) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();

        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(a);
            currentPair.add(b);

            List<Integer> symmetricPair = new ArrayList<>();
            symmetricPair.add(b);
            symmetricPair.add(a);

            if (seen.contains(symmetricPair)) {
                result.add(currentPair);
                result.add(symmetricPair);
            } else {
                seen.add(currentPair);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] pairs1 = {{1, 2}, {2, 1}, {3, 4}, {4, 5}, {5, 4}};
        System.out.println("Symmetric pairs in pairs1: " + findSymmetricPairs(pairs1));
//{2,1},{5,4} - their symmetry pattern available.
        int[][] pairs2 = {{1, 5}, {2, 3}, {4, 2}, {5, 1}, {2, 4}};
        System.out.println("Symmetric pairs in pairs2: " + findSymmetricPairs(pairs2));
        

    }
    
}
