package TCS.Array;

public class MaxmContSubArrSum {
    static void maxmSubarraySum(int[] arr) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;

            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];

                if (ans < currSum)
                    ans = currSum;

            }
        }
        System.out.println("MaxmContSubArrSum  " + ans);

    }


// OPTIMIZED APPROACH ______Kadane's Algorithm Implementation____________________XXX

    static void question(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int num : arr) {
            maxEndingHere += num;

            if (ans < maxEndingHere) {
                ans = maxEndingHere;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        System.out.println("Maximum Contiguous Subarray Sum: " + ans);
    }
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5 };
        // int[]arr = {1,2,3,4,5};
        question(arr);
        maxmSubarraySum(arr);

    }

}
