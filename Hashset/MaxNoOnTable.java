package Hashset;

import java.util.HashSet;

public class MaxNoOnTable {
       static int maxNumberOnTable(int[]bag){
        int max = 0;
        HashSet<Integer> st = new HashSet<>(); // table


        for(int i = 0; i<bag.length; i++){
            int num = bag[i];

            if(st.contains(num)){
                st.remove(num);
            }else{
                st.add(num);
            }
            max = Math.max(max,st.size());
        }


        return max;

    }


    public static void main(String[] args) {
        int[] arr = {2,1,1,3,2,3};
        System.out.println(maxNumberOnTable(arr));
        
    }
}
