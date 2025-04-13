package Array;

public class BinToDec {
    static void binTOdec(int n) {
        int pow = 0;
        int decimalNum = 0;

        while (n > 0) {
            int lasdigit = n % 10;
            decimalNum = decimalNum + lasdigit * (int) Math.pow(2, pow);
            n = n / 10;
            pow++;
        }
        System.out.println(decimalNum);

    }

    static void dectoBin(int n) {
        int pow = 0, bin = 0;
        while (n > 0) {
            int remainder = n % 2;
            bin += remainder * (int) Math.pow(10, pow);
            pow++;
            n = n / 2;

        }
        System.out.println(bin);
    }
   public static void main(String[] args) {
    // binTOdec(1001);
    dectoBin(10);
    
   } 
}
