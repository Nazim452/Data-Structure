package Array;

public class SubArray {
    static void printSubArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int st = i;

            for (int j = i; j < arr.length; j++) {
                int end = j;

                for (int k = st; k <=end; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    static void printSubArraySum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int st = i;

            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum=0;

                for (int k = st; k <=end; k++) {
                    sum+=arr[k];
                }
                System.out.print(sum+" ");
                
                sum=0;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr= {2,4,6,8,10};
        printSubArraySum(arr);

    }
}
