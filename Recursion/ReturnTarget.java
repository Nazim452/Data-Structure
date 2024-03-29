package Recursion;

import java.util.ArrayList;

public class ReturnTarget {

    // RETURN ALL INDEXES OF TARGET ---- SIMILAR TO NEXT QUESTUION ONLY DEFFERENCE
    // IS HERE , RETRUN -NO PRINT

    static ArrayList<Integer> returnINdex(int[] arr, int n, int targert, int index) {
        if (index >= n) {
            return new ArrayList<Integer>(); // return emoty list
        }

        // self work

        ArrayList<Integer> ans = new ArrayList<>();

        if (arr[index] == targert) {
            ans.add(index);

        }

        ArrayList<Integer> smallAns = returnINdex(arr, n, targert, index + 1);
        ans.addAll(smallAns);
        return ans;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,45,78,56,4,4};
        
   ArrayList<Integer> ans = returnINdex(arr, arr.length, 4, 0);

   for(Integer elem:ans){
       System.out.println(elem);
   }

    }
}
