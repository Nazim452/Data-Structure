package TCS.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindNumOfMinm{

    static void findMinm(int[]arr , int n){
        Arrays.sort(arr);


        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

   
    // Second  Way TC - O(n^2)..............................................


    static void findMinm2(int[] arr, int n) {
        if (n > arr.length) {
            System.out.println("Not enough elements!");
            return;
        }

        boolean[] used = new boolean[arr.length]; // Track used elements
        for (int k = 0; k < n; k++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the smallest unused element
            for (int i = 0; i < arr.length; i++) {
                if (!used[i] && arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }

            // Mark the found element as used
            used[minIndex] = true;
            System.out.print(min + " ");
        }
    }
  

    // Total complexity: O(n log n)

    // We insert all n elements into a Min Heap, which takes O(n log n) in the worst case.


     static void findMinmHeap(int[] arr, int n) {
        if (n > arr.length) {
            System.out.println("Not enough elements!");
            return;
        }

        // Min Heap to store elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements into the Min Heap
        for (int num : arr) {
            minHeap.add(num);
        }

        // Extract the 'n' smallest elements
        for (int i = 0; i < n; i++) {
            System.out.print(minHeap.poll() + " "); // Extract and print smallest element
        }
    }
  

    static void findMinmHeap2(int[]arr , int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:arr) pq.add(num);


       for(int i = 0 ; i<n; i++){
         System.out.print(pq.poll()+" ");
       }
    }
    public static void main(String[] args) {
        int[]arr = {12,45,60,70,20,18,};
        int n = 4;
        

        findMinmHeap2(arr, n);
    }

}



