public class PowerOf2 {
    // You are given:

    // An integer N (size of the array)

    // An array Arr of N positive integers

    // You need to find two things:

    // 1️⃣ First Part: Count C

    // Count how many elements in the array are powers of 2.

    // What does “power of 2” mean?

    // A number is a power of 2 if it can be written as:

    // 2
    // 0
    // =
    // 1
    // 2
    // 0
    // =1

    // 2
    // 1
    // =
    // 2
    // 2
    // 1
    // =2

    // 2
    // 2
    // =
    // 4
    // 2
    // 2
    // =4

    // 2
    // 3
    // =
    // 8
    // 2
    // 3
    // =8

    // 2
    // 4
    // =
    // 16
    // 2
    // 4
    // =16

    // and so on…

    // So valid power-of-2 numbers are:
    // 1, 2, 4, 8, 16, 32, ...

    // 2️⃣ Second Part (Important): Find Sum S

    // Add only those elements of the array that are powers of 2.

    // 👉 Do NOT sum all elements
    // 👉 Sum only power-of-2 elements

    // 🔍 Example Walkthrough
    // Input
    // N = 5
    // Array = [1, 2, 3, 4, 5]

    // Step-by-step analysis
    // Element Is power of 2? Reason
    // 1 ✅ Yes 2⁰
    // 2 ✅ Yes 2¹
    // 3 ❌ No cannot be written as 2^x
    // 4 ✅ Yes 2²
    // 5 ❌ No not power of 2
    // Final Results

    // Count (C) = 3 → (1, 2, 4)

    // Sum (S) = 1 + 2 + 4 = 7

    static boolean isPowerOfTwo(int x) {
        if (x <= 0)
            return false;

        while (x % 2 == 0) {
            x /= 2;
        }

        return x == 1;
    }

    static void question5(int[] arr) {
        int count = 0, sum = 0;

        for (int x : arr) {
            if (isPowerOfTwo(x)) {
                count++;
                sum += x;
            }
        }

        System.out.println(count);
        System.out.println(sum);
    }

    public static void main(String[] args) {

        // int[] arr = { 1, 2, 3, 4, 5 };// 3 ,7
        // int[] arr = {1,2,4,8,16,32}; //6 63
        int[] arr = { 1, 3, 4, 7, 8, 10, 16 }; // 4 29
        question5(arr);

    }
}
