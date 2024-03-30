package Queue;

import java.util.PriorityQueue;

// Time complexity -  nlogk-------------------better tha nlogn

public class kthLargestNum {
    static int kthlargestttt(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[]arr = {10,45,5,33,16,50};
        System.out.println(kthlargestttt(arr, 4));

    }
}
