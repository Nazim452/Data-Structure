package BackTracking;

public class RatInMazeLiner {
    static int  factorial(int n){

        if(n==0||n==1) return 1;

        return n*factorial(n-1);
        

    }

    static int ratInMaze(int n, int m){
        int row = factorial(n-1);
        int col = factorial(m-1);
        int num = row+col;
        
        int denom = factorial(n-1);
        int denom2 =factorial(m-1);
        int den = denom*denom2;

        return (num)/den;

    }
    public static void main(String[] args) {
    System.out.println(ratInMaze(3, 3));
        
    }
    
}
