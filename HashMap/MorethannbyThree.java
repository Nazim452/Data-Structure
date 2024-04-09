package HashMap;
import java.util.*;
public class MorethannbyThree {
    static void morethanthreeee(int[]arr){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]+1));
            }
            else map.put(arr[i], 1);
        }

        // ----------------------OR---------------------------------------------------

        // for(int  i = 0; i<arr.length; i++){
        //     map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        // }

        Set<Integer> keyset =map.keySet();

        for(Integer key:keyset){
            if(map.get(key)>arr.length/3) System.out.println(key);
        }

    }
    public static void main(String[] args) {
        int[]arr={1,3,2,5,1,3,1,5,1};
        morethanthreeee(arr);
        
    }
    
}
