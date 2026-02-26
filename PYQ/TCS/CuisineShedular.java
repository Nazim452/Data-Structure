package PYQ.TCS;

import java.util.*;

// Tasks:

// A A A B B B

// Total tasks = 6

// Cooling period = 2

// Meaning:

// If you cook A at time t,
// you cannot cook A again at:

// t+1
// t+2

// You can cook A again at:

// t+3

// So there must be at least 2 units gap between same cuisine.

// 🟢 Let’s Simulate Step-by-Step

// We have:

// 3 A

// 3 B

// n = 2

// 🔹 Step 1: Start Cooking

// Time = 1
// Cook A

// Now A must wait for 2 time units.

// 🔹 Step 2

// Time = 2
// We cannot cook A.

// So cook B.

// Now B must wait for 2 time units.

// 🔹 Step 3

// Time = 3
// A is still cooling
// B is cooling

// No other task available.

// So we must:

// 👉 idle

// 🔹 Step 4

// Time = 4
// Now A cooling is finished.

// Cook A.

// 🔹 Step 5

// Time = 5
// Cook B.

// 🔹 Step 6

// Time = 6
// Both cooling again.

// No other tasks.

// Idle.

// 🔹 Step 7

// Time = 7
// Cook A.

// 🔹 Step 8

// Time = 8
// Cook B.

// ✅ Total Timeline
// Time: 1 2 3 4 5 6 7 8
//       A B I A B I A B

// Total time = 8

public class CuisineShedular {

    public static void main(String[] args) {

        // ✅ ACTIVE TEST CASE 
        // char[] tasks = {'A','A','A','B','B','B'};
        // int n = 2;

         char[] tasks = {'A','A','A','B','C','D'};
         int n = 2;
        // char[] tasks = { 'A', 'A', 'A', 'A' };
        // int n = 3;
        /*
         * // ❌ Other test cases
         * 
         * 
         * char[] tasks = {'A','A','B','B'};
         * int n = 1;
         * 
         */

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);

        // Step 2: Find maximum frequency
        int maxFreq = 0;
        for (int val : map.values())
            maxFreq = Math.max(maxFreq, val);

        // Step 3: Count how many have max frequency
        int maxCount = 0;
        for (int val : map.values())
            if (val == maxFreq)
                maxCount++;

        // Step 4: Calculate result - “I count the frequency of each cuisine, find the most frequent one, calculate the minimum required blocks using cooling interval, and compare it with total tasks to determine the minimum time.”
        /*
         * 
         * (maxFreq - 1) blocks
         * Each block size = n + 1
         * Add last max tasks
         * 
         */
        int part = (maxFreq - 1) * (n + 1) + maxCount;

        int answer = Math.max(tasks.length, part);

        System.out.println("Minimum time required: " + answer);
    }
}

/*

Can You Apply This Formula To Other CPU Scheduling Problems?

⚠ Important: Not always.

This formula works ONLY when:

Every task takes exactly 1 unit time

Cooling interval is fixed

No priority differences

No arrival times

No deadlines

No preemption

🚫 When You CANNOT Use This Formula

If problem includes:

Different execution times

Task arrival times

Priority scheduling

Preemptive scheduling

Round Robin

Deadline scheduling

Weighted tasks

Variable cooldown

Then ❌ this formula will NOT work.

You must use simulation or priority queue.

*/