package Recursion;

public class CountDigit {
    
    static int countDigit(int n){
        //base case

        if(n>=0 && n<=9){
            return 1;
        }

        // recursive work

        int smallAns = countDigit(n/10);

        // self work
        int ans = smallAns+1;

        return ans;

    }
    public static void main(String[] args) {
     System.out.println(countDigit(12348));

        
    }
    
}
