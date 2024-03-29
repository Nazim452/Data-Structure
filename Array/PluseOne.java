package Array;

import java.util.Arrays;

public class PluseOne {
    static int[] plusone(int[] num){
        int n = num.length;

        for(int i =n-1; i>=0; i--){
            if(num[i]<9){
                num[i]++;
                return num;
            }
            num[i] =0;
        }

        int[]newNum = new int[n+1];
        newNum[0] =1;
        return newNum;
    }
    public static void main(String[] args) {
        int[] num = { 9};
        System.out.println(Arrays.toString(plusone(num)));
        
    }
    
}
