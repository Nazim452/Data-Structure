package PYQ.Zoho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnlyFibNoPrint {

    // Optimized - DP (for fib series) , use Hashet to search O(1) , list take  O(n) to search  
      static Set<Integer> generateFibonacciUpTo(int max) {

        Set<Integer> fibSet = new HashSet<>();

        int a = 0;
        int b = 1;

        fibSet.add(a);
        fibSet.add(b);

        while (b <= max) {
            int c = a + b;
            fibSet.add(c);

            a = b;
            b = c;
        }

        return fibSet;
    }
    static int findMax(int[]arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static int  fibHelp(int n){
        if(n==0|| n==1) return n;

        return fibHelp(n-1)+fibHelp(n-2);
    }

    static List<Integer> fib(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int f = fibHelp(i);
            list.add(f);
            

        }
        return list;

    }

    static void question(int[]arr){
        int n= arr.length;
        int max = findMax(arr);

        List<Integer> fibList = fib(max);


        for(int i = 0; i<n; i++){
            if(fibList.contains(arr[i])){
                System.out.print(arr[i]+" ");
            }
            
        }


    }
    public static void main(String[] args) {
        // int[]arr = {2,10,4,8};
        int[]arr = {1,10,6,8,13,21};
        question(arr);
        
    }
}
