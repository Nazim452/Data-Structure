package PYQ.Zoho;

public class LargestSubarrayIndex {

    public static void findLargestSubarray(int[] arr) {

        int n = arr.length;
        int maxLen = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {

            int zeroCount = 0;
            int oneCount = 0;

            for (int j = i; j < n; j++) {

                if (arr[j] == 0)
                    zeroCount++;
                else
                    oneCount++;

                if (zeroCount == oneCount) {

                    int length = j - i + 1;

                    if (length > maxLen) {
                        maxLen = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        if (maxLen == 0)
            System.out.println(-1);
        else
            System.out.println(start + " to " + end);
    }

    public static void main(String[] args) {

        int[] arr1 = {0,1,1,0,1,0};
        findLargestSubarray(arr1);  // 0 to 5

        int[] arr2 = {0,0,1,0,1,0,1};
        findLargestSubarray(arr2);  // 1 to 6

        int[] arr3 = {1,1,1};
        findLargestSubarray(arr3);  // -1
    }
}
