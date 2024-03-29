package Recursion;

public class Poweral {
    static int myPow(int x, int n) {
        if(n>=0) return positive(x,n);
        else return negative(x,n);
    }

    static  int positive(int x, int n){
        if(n==0) return 1;

        int smallans = myPow(x,n/2);
        if(n%2==0) return smallans*smallans;
        else return x*smallans*smallans;
    }
    static int negative(int x, int n){
        if(n==-1) return 1/x;

        int smallans = myPow(x,n/2);
        if(n%2==0) return smallans*smallans;
        else return 1/x*smallans*smallans;

    }


    public static void main(String[] args) {
        System.out.println(myPow(8, -2));
        
    }
    
}
