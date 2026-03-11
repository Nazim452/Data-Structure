package PYQ.TCS;
// Horse Betting Problem (TCS NQT Style)

// Bob is going to place bets on a horse race.

// There are N horses, arranged in a sequence from 1 to N.

// Each horse has a different betting price. The price array is given in order.

// Bob believes that betting on a continuous sequence of horses increases his chances of winning.

// He will receive K units of reward if any one of the horses he bet on wins.

// Since the reward amount is only K units, he wants to ensure that the total betting amount is strictly less than K.

// Bob wants to bet on as many consecutive horses as possible.

// 🎯 Task

// Find the maximum length of a continuous sequence of horses such that:

// Sum of betting prices
// <
// 𝐾
// Sum of betting prices<K

// If multiple sequences satisfy the condition, return the maximum possible length.

// 📥 Input

// Integer N → Number of horses

// Integer K → Reward money

// Array of N integers → Betting prices of horses in order

// 📤 Output

// Return a single integer:

// 👉 The maximum number of consecutive horses Bob can bet on such that total price is strictly less than K.

// 📌 Constraints

// 2
// ≤
// 𝑁
// ≤
// 10
// 5
// 2≤N≤10
// 5

// 1
// ≤
// 𝐾
// ≤
// 10
// 9
// 1≤K≤10
// 9

// 1
// ≤
// 𝐴
// [
// 𝑖
// ]
// ≤
// 10
// 9
// 1≤A[i]≤10
// 9

// 🧪 Example 1
// Input
// N = 10
// K = 100
// Prices = [30, 40, 50, 20, 20, 10, 90, 10, 10, 10]
// Output
// 3
// Explanation

// Valid sequences with sum < 100:

// [50, 20, 20] → 90

// [10, 10, 10] → 30

// No longer valid sequence exists.
// So the maximum length is 3.

// 🧪 Example 2
// Input
// N = 10
// K = 100
// Prices = [10, 90, 80, 20, 90, 60, 40, 60, 70, 75]
// Output
// 1
// Explanation

// No two consecutive horses have sum < 100.
// So Bob can only bet on one horse at a time.

// 🧠 Core Concept

// This is a classic:

// Longest subarray with sum strictly less than K

// Efficient approach:

// Sliding Window (Two Pointers)

// Time Complexity: O(N)

public class SLidingWindowLessthank {
    static void queston11111(int[] arr, int k) {
        int n = arr.length;
        int st = 0;
        int maxlen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum < k) {
                maxlen = Math.max(maxlen, i - st + 1);
            }

            while (sum >= k) {
                sum -= arr[st++];
            }

        }
        System.out.println(maxlen);

    }

    public static void main(String[] args) {

        // int [] arr = {30,40,50,20,20,10,90,10,10,10};
        int[] arr = { 50, 50 };
        queston11111(arr, 100);

    }

}
