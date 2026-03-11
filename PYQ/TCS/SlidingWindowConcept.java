package PYQ.TCS;

public class SlidingWindowConcept {
    // Sliding WIndow Apply - Contigouse String , Contigous subarray Sun
    // Mental Model

    // Think like this:

    // Expand → Break Rule → Shrink → Fix Ruel → Expand Again

    // static void question(int[] arr, int tar) {
    //     int sum = 0;
    //     int n = arr.length;
    //     int st = 0;
    //     int maxLen =Integer.MAX_VALUE;

    //     for (int i = 0; i < n; i++) {

    //         sum += arr[i];
    //         maxLen = Math.min(maxLen, i-st+1);

    //         while (sum > tar) {

    //             sum -= arr[st++];
    //         }

    //         if (sum == tar) {
    //             // System.out.println((st + 1) + " " + (i + 1));
    //             // System.out.println("Maximum Length"+maxLen);
    //             maxLen = Math.min(maxLen, i-st+1);
    //         }

    //     }

    //             System.out.println("Maximum Length"+maxLen);

    // }
    


    static void question(int[] arr ,  int tar){
        int n = arr.length;
        int st = 0;
        int minength = Integer.MAX_VALUE;
        int sum = 0;

        for(int end = 0; end <n;end++){
            sum+=arr[end];

            while (sum>tar) {
                sum-=arr[st++];                               
            }
            

            if(sum==tar){
                int currentLength = end-st+1;
                if(currentLength<minength){
                    System.out.println((st+1) +" "+(end+1));
                }
            }



        }
    }

    public static void main(String[] args) {

        int[] arr = { 5,3,7,14,18,1,18,4,8,2,1};
        int tar = 15;
        question(arr, tar);

    }
}