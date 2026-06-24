package PYQ.TCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintPairExceptParticualNum {
    static void queston(int l , int r,int [] exclude){
       
        Set<Integer> set = new HashSet<>();

        for(int num:exclude) set.add(num);
        
        

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = l; i<=r; i++){

            // System.out.println("list   "+list);
           
               if (!set.contains(i)){
                list.add(i);
               }
               if(set.contains(i)){
                if(list.size()==1) System.out.println(list.get(0)+"  "+list.get(0));

                else{
                    System.out.println(list.get(0)+"  "+list.get(list.size()-1));
                }
                list.clear();
               
               }
               
                
            
        }


        System.out.println(list.get(0)+"  "+list.get(list.size()-1));
    }
   
    static void printRangesOptimal(int L, int R, int[] exclude) {

        Arrays.sort(exclude);

        int start = L;

        for(int num : exclude){

            if(num > start){
                System.out.println(start + " " + (num - 1));
            }

            start = num + 1;
        }

        if(start <= R){
            System.out.println(start + " " + R);
        }
    }
   
   
   
   
    public static void main(String[] args) {
      int l =1, r  = 10 ;   // [3,4], [6,7] [9,10]
      int[] exclude = {2,5,9};

    //   int l = 3, r  = 10 ;   // [3,4], [6,7] [9,10]
    //   int[] exclude = {5,8};
      printRangesOptimal
      (l, r, exclude);
        
    }
    
}
