package TCS.PrepInstaStoryBased;

import java.util.Scanner;


// Example 1:

// Input :

// 10  -> Integer

// Output :

// 5    -> result- Integer

// Explanation:

// Binary representation of 10 is 1010. After toggling the bits(1010), will get 0101 which represents “5”. Hence output will print “5”.


public class BinaryDecimal {

    static int decimalToBin(int n) {
        int pow = 0, bin = 0;
        while (n > 0) {
            int remainder = n % 2;
            bin += remainder * (int) Math.pow(10, pow);
            pow++;
            n = n / 2;

        }

        return bin;
    }

    static int binarytoDecimal(int n) {
        int pow = 0, dec = 0;

        while (n > 0) {
            int lastdigit = n % 10;
            dec += lastdigit * (int) Math.pow(2, pow);
            pow++;
            n = n / 10;
        }

        return dec;
    }

    static int flipBinary(int n) {
        String binaryStr = String.valueOf(n); // Convert number to string
        StringBuilder flippedStr = new StringBuilder();

        for (char bit : binaryStr.toCharArray()) {
            // Flip '1' to '0' and '0' to '1'
            flippedStr.append(bit == '1' ? '0' : '1');
        }

        return Integer.parseInt(flippedStr.toString()); // Return flipped binary string
    }

    static void Question(int n) {
        int binary = decimalToBin(n);

        int flippedNum =flipBinary(binary);
        
        int ans = binarytoDecimal(flippedNum);

        System.out.println(ans);

    }








    static void approachSecod(int n){
         Scanner sc=new Scanner(System.in);
         int no=sc.nextInt();
          String bin="";
         
          while(no!=0)
           {
                  bin=(no&1)+bin;
                  no=no>>1;
           }
            bin=bin.replaceAll("1","2");
            bin=bin.replaceAll("0","1");
            bin=bin.replaceAll("2","0");
            int res=Integer.parseInt(bin,2);
           System.out.println(res);
    }
    public static void main(String[] args) {

        // Question(10);
        approachSecod(10);

    }

}
