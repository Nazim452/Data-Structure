package Sorting;

//  Error - Not Working Properly__________________________________________________

public class NegPosSoritn {
    static void negPosSorting(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            while (arr[l] < 0)
                l++; // = means 0 consider in negative side
            while (arr[r] >= 0)
                r--;

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
    public static void main(String[] args) {
        int []arr = {-13,20,7,0,-4,-13,11,-5,-13};
        negPosSorting(arr);
        for(int elem:arr){
            System.out.print(elem+ " ");
        }
    }
    
}
