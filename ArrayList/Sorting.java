package ArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(13);
        list.add(63);
        list.add(1);
        list.add(10);
        list.add(3);
       // Ascending order
        Collections.sort(list);

        //Descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        
    }
}
