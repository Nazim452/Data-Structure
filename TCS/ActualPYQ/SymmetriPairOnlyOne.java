package TCS.ActualPYQ;

import java.util.*;
public class SymmetriPairOnlyOne {
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
                // Add only the symmetric pair (b, a) to avoid duplicates
                result.add(symmetricPair);
                // Remove the symmetric pair from seen to prevent adding it again
                // seen.remove(symmetricPair);
            } else {
                seen.add(currentPair);
            }
        }

        return result;
    }


    static List<List<Integer>> quesion(int[][] arr){
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> seen = new HashSet<>();

        for(int[] elem:arr){
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(elem[0]);
            currentPair.add(elem[1]);

            List<Integer> symmetrricPair = new ArrayList<>();
            symmetrricPair.add(elem[1]);
            symmetrricPair.add(elem[0]);

            if(seen.contains(symmetrricPair)){
               ans.add(symmetrricPair);
            //    seen.remove(symmetrricPair);

            }
            seen.add(currentPair);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] pairs1 = {{1, 2}, {2, 1}, {3, 4}, {4, 5}, {5, 4}};
        System.out.println(quesion(pairs1));

        int[][] pairs2 = {{1, 5}, {2, 3}, {4, 2}, {5, 1}, {2, 4}};
        System.out.println(quesion(pairs2));
    }
}