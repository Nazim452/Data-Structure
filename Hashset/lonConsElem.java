package Hashset;

import java.util.HashSet;

public class lonConsElem {
    
    public static int consecutive(int[]arr){
        int maxStreak = 0;

        HashSet<Integer> st = new HashSet<>();
        for(int num:arr) st.add(num);
       

        for(var num:st ){
             
            if(!st.contains(num-1)){
                int currNum = num;

                int currStreak = 1;  // length of consecutive seq

                while(st.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                
                }
                maxStreak = Math.max(currStreak, maxStreak);
                
            }
           
        }
        return maxStreak;
    }


    public static void main(String[] args) {
        int[]arr = {100,4,200,1,3,2};
        System.out.println(consecutive(arr));
        
    }
}
