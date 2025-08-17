package Array;

// An Armstrong number is a special number where the sum of its digits each raised

//  to the power of the number of digits equals the number itself vvviii

//  Input:153
// Output: Yes
// Explanation: 153 is an Armstrong number, 1*1*1 + 5*5*5 + 3*3*3 = 153

// Input: 120
// Output: No
// Explanation: 120 is not a Armstrong number, 1*1*1 + 2*2*2 + 0*0*0 = 9

// These are all 1-digit numbers, so:

// Number of digits = 1

// So check if:
// digit
// 1
// =
// number itself
// digit 
// 1
//  =number itself

// | Number | Calculation | Armstrong? |
// | ------ | ----------- | ---------- |
// | 1      | 1¹ = 1      | ✅ Yes      |    //jitna no of digit hai utna hi power karna hai
// | 2      | 2¹ = 2      | ✅ Yes      |
// | 3      | 3¹ = 3      | ✅ Yes      |
// | 4      | 4¹ = 4      | ✅ Yes      |
// | 5      | 5¹ = 5      | ✅ Yes      |
// | 6      | 6¹ = 6      | ✅ Yes      |
// | 7      | 7¹ = 7      | ✅ Yes      |
// | 8      | 8¹ = 8      | ✅ Yes      |
// | 9      | 9¹ = 9      | ✅ Yes      |



public class ArmsStrong {

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

    static void genArmStrong(int limit) {
        for (int i = 0; i <= limit; i++) {
            if (isArmStrong(i))
                System.out.print(i + " ");

        }

    }

    public static void main(String[] args) {
        // The first few Armstrong numbers between 0 to 999 are 1, 2, 3, 4, 5, 6, 7, 8,
        // 9, 153, 370, 371, 407. Some other Armstrong numbers are 1634, 8208, 9474,
        // 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050,
        // 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774,
        // 32164049650, 32164049651.

        // System.out.println(isArmStrong(93084));
        genArmStrong(9999);

    }
}
