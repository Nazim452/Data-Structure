package ArrayList;

import java.util.ArrayList;

public class Swap {
    static void swap(ArrayList<Integer> list , int idx1, int idx2){

        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        System.out.println("Before Swapping"+list);
        swap(list, 0, 1);
        System.out.println("After Swapping"+list);

        
    }
    
}
