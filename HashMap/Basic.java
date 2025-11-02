package HashMap;
import java.util.*;
public class Basic {
    public static void main(String[] args) {
        // Map<Integer, String> map = new HashMap<Integer, String>();

        // map.put(1, "X");
        // map.put(2, "Y");
        // map.put(3, "Z");





       int[] arr = { 2, 4, 2, 4, 2, 4 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // For Below (Java 10 version ) only this iteration work - (VVI)


        // for (Map.Entry<Integer, Integer> data : map.entrySet()) {

        for (var entry : map.entrySet()) {

            int value = entry.getValue();
            int key = entry.getKey();
           
        }
      


















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
