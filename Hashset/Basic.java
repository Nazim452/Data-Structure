package Hashset;
import java.util.*;

public class Basic {
    public static void main(String[] args) {
        Set<Integer>  set = new HashSet<>();
        set.add(12);
        set.add(13);
        set.add(14);

        // System.out.println(set);

        // terate on HashSet
        for(Integer k:set){
            System.out.print(k +" ");
        }
    }
}
