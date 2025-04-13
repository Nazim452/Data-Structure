package TCS.Array;
// OPTIMIZED APPROACH IS REMAINING

public class MaxmContSubArrSum {
    static void maxmSubarraySum(int[] arr) {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;

            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];

                if (sum < currSum)
                    sum = currSum;

            }
        }
        System.out.println("MaxmContSubArrSum  " + sum);

    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5 };
        // int[]arr = {1,2,3,4,5};
        maxmSubarraySum(arr);

    }

}
