package Array;

import java.util.LinkedHashSet;
import java.util.Set;


//Not getting Clear Idea_____________________________________________________

public class RemoveDuplicate {

    static void removeSDuplicate(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[j] != arr[i]) {
                j++;
                arr[j] = arr[i];

            }
        }


        for (int i = 0; i < j + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }


     static void removeDuplicates(int[] arr) {
        // LinkedHashSet maintains insertion order and removes duplicates
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        // Printing the result
        for (int num : set) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
        public static void main(String[] args) {
        // int[]arr = {1,1,2,2,3,4,5,6};
        int[] arr = { 2, 2, 2, 2, 2, 2 }; 
        removeSDuplicate(arr);

    }

}
