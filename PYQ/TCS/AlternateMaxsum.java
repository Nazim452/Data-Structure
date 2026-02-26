package PYQ.TCS;

public class AlternateMaxsum {
    static void question(int n , int m){
        int sum1 = 0, sum2 = 0;
        for(int i = 1; i<=n; i+=2){
            sum1+=i;

        }
        for(int i = 2; i<=n; i+=2){
            sum2+=i;

        }
        int maxSum = Math.max(sum2, sum1);

        System.out.println(maxSum*m);
    }
    public static void main(String[] args) {
        int n= 10, m = 4;
        question(n, m);
        
    }
    
}
