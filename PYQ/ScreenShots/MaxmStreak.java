public class MaxmStreak {
// Problem 2: Peak Output (Maximum Consecutive Days)
// 📌 Problem Description

// Given:

// An integer N (number of days)

// An array workload[] of size N

// Define:

// Peak Output = Maximum number of consecutive days where workload > 6

// 📌 Sample Input
// 7
// 3 7 8 12 4 9 8

// 📌 Sample Explanation

// Workload = [3, 7, 8, 12, 4, 9, 8]

// Day	Workload	>6?	Streak	Max
// 1	3	      No	           0	0
// 2	7	      Yes	           1	1
// 3	8	      Yes	           2	2
// 4	12	      Yes	           3	3
// 5	4	      No	           0	3
// 6	9	      Yes	           1	3
// 7	8	      Yes	           2	3
// 📌 Sample Output
// 3
    static void question(int[] arr){
        int n = arr.length;
        int streak = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i]>=6){
                streak++;
                max = Math.max(max, streak);

            }
            else streak = 0;
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int[] arr = {3,7,8,12,4,9,8};
        question(arr);

        
    }
    
}
