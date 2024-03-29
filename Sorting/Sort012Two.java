package Sorting;

public class Sort012Two {
    
    static void sort012(int[] arr) {
        int count_0 = 0, count_1 = 0, count_2 = 0;

        for (int i : arr) {
            if (i == 0) {
                count_0++;
            } else if (i == 1) {
                count_1++;
            } else {
                count_2++;
            }
        }
        int k = 0;
        while (count_0 > 0) {
            arr[k++] = 0;
            count_0--;

        }
        while (count_1 > 0) {
            arr[k++] = 1;
            count_1--;
        }
        while (count_2 > 0) {
            arr[k++] = 2;
            count_2--;

        }

        // but it take TC - O(n) & SC - O(1)
        // it occurs in 2 pass not best
        // 2nd way is discussed above in only one pass

    }
    public static void main(String[] args) {
        int[] arr = { 0, 2, 2, 1, 1, 0, 2, 1, 0 };
        sort012(arr);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        
    }
}
