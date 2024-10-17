package BinarySearch;

public class Sqrt {

    static int sqrt(int x) {

        int st = 0, end = x;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int val = mid * mid;

            if (val == x) {
                return mid;
            } else if (val < x) {
                ans = mid;
                st = mid + 1;

            } else {
                end = mid - 1;
            }

        }
        return ans;

    }

    //LInearrly finding sqaure root_________________________________________________
    
    static int LinearSqrt(int n){
        for (int i = 0; i < n; i++) {
            if(i*i==n) return i;

            else if(i*i>n) return i-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        // System.out.println(LinearSqrt(29));

    }

}
