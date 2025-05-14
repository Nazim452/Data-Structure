package TCS.Array;

public class KadaneAlgorithm {

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
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };   //6
        // int[] arr = { 1000000, -1000000, 2000000 }; //The subarray [2000000] 
        // int[] arr = { 0, 0, 0, 0 }; //0
        // int[]arr = {5};  //5

        question(arr);
        
    }
    
}
