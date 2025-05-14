package TCS.ActualPYQ;
// Imagine you have a list of tasks (like homework assignments), and each task takes a certain amount of time to complete. You have two friends (processors) who can help you complete these tasks at the same time.

// Rules:
// Task Assignment:

// You can split the list of tasks into two parts:

// The first part (prefix) goes to Friend 1.

// The remaining tasks (suffix) go to Friend 2.

// Example: If there are 3 tasks (Task 1, Task 2, Task 3), you can choose:

// Friend 1 gets none, Friend 2 does all 3 tasks.

// Friend 1 gets Task 1, Friend 2 does Tasks 2 & 3.

// Friend 1 gets Tasks 1 & 2, Friend 2 does Task 3.

// Friend 1 gets all 3 tasks, Friend 2 does nothing.

// Execution Time:

// Each friend works one task after another (sequentially).

// The total time taken is the maximum time between the two friends (since both work simultaneously).

// Example: If Friend 1 takes 5 seconds and Friend 2 takes 3 seconds, the total time is 5 seconds (the slower one).

// Goal:

// Find the best way to split the tasks between the two friends so that the total time taken is the smallest possible.
// Input:___________________________________

// Number of tasks (N) = 3

// Task times = [3, 1, 2] (Task 1 takes 3 sec, Task 2 takes 1 sec, Task 3 takes 2 sec)

// Possible Splits & Total Times:

// Friend 1: None | Friend 2: [3, 1, 2]

// Friend 2's time = 3 + 1 + 2 = 6 sec

// Total time = max(0, 6) = 6 sec

// Friend 1: [3] | Friend 2: [1, 2]

// Friend 1's time = 3 sec

// Friend 2's time = 1 + 2 = 3 sec

// Total time = max(3, 3) = 3 sec ✅ (Best)

// Friend 1: [3, 1] | Friend 2: [2]

// Friend 1's time = 3 + 1 = 4 sec

// Friend 2's time = 2 sec

// Total time = max(4, 2) = 4 sec

// Friend 1: [3, 1, 2] | Friend 2: None

// Friend 1's time = 3 + 1 + 2 = 6 sec

// Friend 2's time = 0 sec

// Total time = max(6, 0) = 6 sec

// Best Answer: 3 seconds (when Friend 1 takes Task 1 and Friend 2 takes Tasks 2 & 3).

// Input Format_______________________________________________

// 3   - Total task
// 3 1 2 - Time for each task
// 3 - Output

// Input 2:

// 3
// 2 3 1

// Explanation:
// Splits:
// [] | [2,3,1] → max(0, 6) = 6  
// [2] | [3,1] → max(2, 4) = 4  
// [2,3] | [1] → max(5, 1) = 5  
// [2,3,1] | [] → max(6, 0) = 6  
// Answer = **4**

// Output:
// 4

// Input:

// 4
// 2 2 2 2

// Explanation:
// Try splits: 
// []|[2,2,2,2] → 8  
// [2]|[2,2,2] → max(2,6)  
// [2,2]|[2,2] → max(4,4) ✅  
// [2,2,2]|[2] → max(6,2)  
// [2,2,2,2]|[] → 8  
// Answer = **4**

// Output:
// 4


// Split (i)	Processor 1 (prefix[i])	Processor 2 (suffix[i])	Max Time
// 0	                  0	                  6	                  6
// 1	                  3	                  3	                  3 (Best)
// 2	                  4	                  2	                  4
// 3	                  6	                  0	                  6



// Why took n+1 length for suffix array or prefix array ?

// . Handling All Possible Splits
// Problem Statement:

// You need to consider all possible ways to split the tasks between two processors.

// This includes the cases where:

// Processor 1 gets 0 tasks (all tasks go to Processor 2).

// Processor 1 gets N tasks (Processor 2 gets nothing).

// Example (N = 3):

// Possible splits: i = 0, 1, 2, 3
// (i = number of tasks assigned to Processor 1).
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Compute prefix sums
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        // Compute suffix sums
        int[] suffix = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + A[i];
        }

        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            int currentMax = Math.max(prefix[i], suffix[i]);
            // if (currentMax < minTime) {
            //     minTime = currentMax;
            // }
            minTime = Math.min(currentMax , minTime);
        }

        System.out.println(minTime);

        scanner.close();
    }
}

// int T = scanner.nextInt();
// System.out.println("T = " + T); // debug
// for (int t = 0; t < T; t++) {
// if (!scanner.hasNextInt()) break; // safeguard
// int N = scanner.nextInt();
// System.out.println("N = " + N); // debug
// int[] A = new int[N];
// for (int i = 0; i < N; i++) {
// if (!scanner.hasNextInt()) break; // safeguard
// A[i] = scanner.nextInt();
// }
// // continue logic...
// }
