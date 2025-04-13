package TCS.PrepInstaStoryBased;
// Example 1:

// Input :

// 99 -> Value of N

// 3  -> Value of R

// Output :

// 9  -> Possible ways to fill the cistern.

// Explanation:

// Here, the number N=99

// Sum of the digits N: 9+9 = 18
// Repeat step 2 ‘R’ times i.e. 3 tims  (9+9)+(9+9)+(9+9) = 18+18+18 =54
// Add digits of 54 as we need a single digit 5+4
// Hence , the output is 9.



public class intelligenceAgency {
    static int digitSum(int n){
        int res = 0;

        while (n>0) {
            int lastdigit = n%10;
            res+=lastdigit;
            n = n/10;

            
        }
        return res;
    }
    static void question(int n, int r){

        int sumN = digitSum(n);
        int util = sumN*r;
        int ans = digitSum(util);

        System.out.println(ans);
    }
    public static void main(String[] args) {

        question(1234   ,2)        ;
    }
    
}
