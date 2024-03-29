package Recursion;

public class FirstLastOccur {
    static int firsstOccurance(int[] arr, int n, int index, int key) {
        if (n == index)
            return -1;
        if (arr[index] == key)
            return index;
        return firsstOccurance(arr, n, index + 1, key);
    }

    static int lastOccurance(int[] arr, int key, int i) {
        if (i == arr.length)
            return -1;
        int smallAns = lastOccurance(arr, key, i + 1);
        if (smallAns == -1 && arr[i] == key)
            return i;
        return smallAns;

    }

    static int lastOccurance2(int[] arr, int key) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                ans = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr={1,3,2,3,4,7,2};
        System.out.println(firsstOccurance(arr, arr.length, 0, 2));
        System.out.println(lastOccurance(arr, 2,0));

    }
}
