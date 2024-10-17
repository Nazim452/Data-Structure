package Array;

public class ArmsString {

    static boolean isArmStrong(int x) {
        int tempAns = 0, digitCount = 0;
        int copyNum = x;

        while (copyNum > 0) {
            copyNum = copyNum / 10;
            digitCount++;
        }

        copyNum = x;

        while (copyNum > 0) {
            int ld = copyNum % 10;
            tempAns += Math.pow(ld, digitCount);
            copyNum = copyNum / 10;

        }

        return tempAns == x;
    }


    static void genArmStrong(int limit){
        for(int i=0; i<=limit; i++){
            if(isArmStrong(i)) System.out.print(i+" ");

        }

    }
    public static void main(String[] args) {
        // The first few Armstrong numbers between 0 to 999 are 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407. Some other Armstrong numbers are 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774, 32164049650, 32164049651.

        // System.out.println(isArmStrong(93084));
        genArmStrong(9999);

    }
}
