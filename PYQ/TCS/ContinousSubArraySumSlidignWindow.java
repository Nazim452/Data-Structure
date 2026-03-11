package PYQ.TCS;


public class ContinousSubArraySumSlidignWindow {
    static void bruteforce(int[] arr, int target) {

        int n = arr.length;

        boolean found = false;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += arr[j];

                if (sum == target) {
                    System.out.println((i + 1) + " " + (j + 1));
                    found = true;
                    break;
                }
            }

            if (found)
                break;
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    static void optimized(int[] arr, int tar) {
        int n = arr.length;
        int st = 0;
        int sum = 0;

        for(int end = 0; end<n; end++){
            sum+=arr[end];

            while (sum>tar && st<=end) {
                sum-=arr[st];
                st++;
                
            }

            if(sum==tar){
                System.out.println((st+1)+" "+(end+1));
                break;
            }
        }

    }

    
    public static void main(String[] args) {
    //  int[] arr = {1, 4, 20, 3, 10, 5};
    //     int target = 33;
    //     optimized(arr, target);
        
       
          
    }
}