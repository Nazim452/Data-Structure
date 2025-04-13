package HashMap;
import java.util.*;
public class Basic {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "X");
        map.put(2, "Y");
        map.put(3, "Z");

        // System.out.println(map.remove(1)); //x
        // System.out.println(map);

        //1.  Iterate over the key______________________

        for(var i:map.keySet()){
            System.out.print(i+" ");
        }

        // 2. Iterate over the Value___________________

        // for(var e: map.entrySet()){
        //     System.out.print(e.getValue()+" ");
        // }


        // 3. 

     

    }
    
}
