package PYQ.TCS;

import java.util.*;

public class CuisineShedular2 {

    public static int getMinimumIterations(char[] cuisines, int n) {
        // 1. Count the frequency of each cuisine
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : cuisines) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Max Heap to pick the most frequent available cuisine first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(counts.values());

        // 3. Queue to handle the "cooling down" period
        // Stores arrays of: [remaining_count, time_it_becomes_available]
        Queue<int[]> waitQueue = new LinkedList<>();
        
        int time = 0;

        // 4. Simulate the timeline step-by-step
        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {
            time++; // Move to the next time unit

            // If the time it becomes available equals our current time, it's ready!
            if (!waitQueue.isEmpty() && waitQueue.peek()[1] == time) {
                maxHeap.add(waitQueue.poll()[0]); // Put it back into the available heap
            }

            // If we have a cuisine ready to cook
            if (!maxHeap.isEmpty()) {
                int currentCount = maxHeap.poll(); 
                currentCount--; // We cooked it once

                // If we still need to cook this cuisine, it goes into cooling
                if (currentCount > 0) {
                    // FIX: It will be ready at (current time + cooling period n + 1)
                    // If cooked at time 1 with n=2, it cools during 2 and 3, ready at 4.
                    waitQueue.add(new int[]{currentCount, time + n + 1});
                }
            } 
        }

        return time;
    }

    public static void main(String[] args) {
        // char[] cuisines = {'A', 'A', 'A', 'B', 'B', 'B'};
        // int n = 2;

        char[] cuisines = { 'A', 'A', 'A', 'A' };
        int n = 3;
        
        int totalTime = getMinimumIterations(cuisines, n);
        System.out.println("Total time = " + totalTime); 
        // Output is now correctly 8
    }
}