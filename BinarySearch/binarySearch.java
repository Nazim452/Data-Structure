package BinarySearch;

public class binarySearch {

    static int binSerch(int[]arr, int tar){
        int n = arr.length;
        int st = 0, end = n - 1;

        while (st<=end) {
            int mid = (st+end)/2;

            if(tar==arr[mid])  return mid;

            else if(tar<arr[mid] ) end = mid-1;

            else st = mid+1;
            
        }

        return -1;
    }
    public static void main(String[] args) {
        int []arr = {1,6,8,45,67,89};
        System.out.println(binSerch(arr, 45));
        
    }
    
}
