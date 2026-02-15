package PYQ.Array;


public class FreqofLimitedRangeArray {

   static void question(int[] arr, int p) {
        int[] freq = new int[p + 1]; // To count from 1 to p

        // Count frequencies for values in range 1 to p
        for (int num : arr) {
            if (num >= 1 && num <= p) {
                freq[num]++;
            }
        }

        // Output frequencies from 1 to p
        for (int i = 1; i <= p; i++) {
            System.out.print(freq[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 3, 5 }; //
        int p = 5;
        // O/P - 0 2 2 0 1
        // Explanation:
        // Counting frequencies of each array element
        // We have:
        // 1 occurring 0 times.
        // 2 occurring 2 times.
        // 3 occurring 2 times.
        // 4 occurring 0 times.
        // 5 occurring 1 time.

        question(arr, p);

    }
}
