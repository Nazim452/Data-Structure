package Sorting;

public class StringSorting {

    static void printArr(String[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    static void  lexiCalSorting(String[]arr){
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {

            int minIdx = i;

            for(int j = i+1; j<n; j++){
                if(arr[j].compareTo(arr[minIdx])<0) minIdx = j;
            }
            // swap(arr[i], arr[minIdx]);
            String temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            
            
        }
        printArr(arr);
    }
    public static void main(String[] args) {
        
        String[]arr ={"papaya", "mango", "apple", "orange"};
        lexiCalSorting(arr);

    }
}
