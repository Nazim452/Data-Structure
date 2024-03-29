package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSorting {
    public static void main(String[] args) {
        Integer [] arr = {3,4,45,2,17,32};
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i :arr){
            System.out.print(i+" ");
        }
    
    }
}
