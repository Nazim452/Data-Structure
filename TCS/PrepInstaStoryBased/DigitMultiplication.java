package TCS.PrepInstaStoryBased;


// Example 1:

// Input :

// 5244 -> Value of N

// Output :
// 160 -> Price 

// Explanation:

// From the input above 

// Product of the digits 5,2,4,4

// 5*2*4*4= 160

// Hence, output is 160.


public class DigitMultiplication {

    static void  question(int n){

        int ans = 1;
        while (n>0) {
            int lastdigit = n%10;
            ans = ans*lastdigit;
            n = n/10;

            
        }
        System.out.println(ans);
    
    }
    public static void main(String[] args) {
        question(5523);
        
    }
    
}
