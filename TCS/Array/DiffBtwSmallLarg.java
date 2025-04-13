package TCS.Array;

public class DiffBtwSmallLarg {

    static void findDiffBtwLargAndSmall(int[] arr) {
        int n = arr.length;
        int largest = arr[n - 1];
        int ans = Integer.MIN_VALUE;

        for(int i = n-1; i>0; i--){
            
            largest = Math.max(largest,arr[i]);

            if(arr[i]<largest){
                int diff = largest-arr[i];
                ans = Math.max(diff,ans);

            }
        }

        System.out.println("ANS " + ans);
    }


    public static void getMaxDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int minElement = arr[0]; // Start with the first element as the minimum
        int maxDifference = Integer.MIN_VALUE; // Initialize to the smallest possible value

        for (int i = 1; i < arr.length; i++) {
            // Calculate the difference between current element and the minimum so far
            int difference = arr[i] - minElement;

            // Update maxDifference if the current difference is larger
            if (difference > maxDifference) {
                maxDifference = difference;
            }

            // Update the minimum element if the current element is smaller
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }

       System.out.println(maxDifference);
    }
    public static void main(String[] args) {

        int[]arr ={4,8,3,6,1,9};
        // int[] arr = { -3, -5, 1, 6, -7, 11, 8 };

        // Condition - Smallest number should come before largest number..... (VVI)
        // min = -7 ,
        // max = 11 ,
        // Diff = 11-(-7) = 18 - O/P
        getMaxDifference(arr);
    }

}
