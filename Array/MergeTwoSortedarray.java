package Array;

public class MergeTwoSortedarray {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void merge(int[] arr1, int m, int[] arr2, int n) {
        int[] temp = new int[m]; // Save original arr1 part
        for (int x = 0; x < m; x++) {
            temp[x] = arr1[x];
        }

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (temp[i] <= arr2[j]) {

                // Jisme dalna hai = jisko dalna hai
                arr1[k++] = temp[i++];
            } else {
                arr1[k++] = arr2[j++];
            }
        }

        while (i < m) {
            arr1[k++] = temp[i++];
        }

        while (j < n) {
            arr1[k++] = arr2[j++];
        }

        printArray(arr1);
    }


    static void merge2(int[] arr1 , int m , int[]arr2 , int n){
        int[]temp = new int[m];
        int x= 0;
        for(int i = 0; i<m; i++){
            temp[x++] = arr1[i];
            
        }
        int i = 0 , j = 0, k = 0;


        while(i<m && j<n){
            if(temp[i]<=arr2[j]){
                arr1[k++] = temp[i++];
            }
            else arr1[k++] = arr2[j++];

        }

        while (i<m) {
            arr1[k++] = temp[i++];
            
        }
        while (j<n) {
            arr1[k++] = arr2[j++];
            
        }
        printArray(arr1);

    }
    public static void main(String[] args) {
        int[] arr1 = new int[6]; // Allocate size = m + n
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        int[] arr2 = { 2, 4, 6 };

        merge2(arr1, 3, arr2, 3); // Correct m and n
        // System.out.println();
        // merge(arr1, 3, arr2, 3); // Correct m and n

    }
}
