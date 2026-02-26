package PYQ.TCS;

public class NebrVanishsing {
    static void question(int m  , int n){
        int ans = 0;

        for(int i = n; i>=2; i-=2){
            ans+=i;
        }

        System.out.println(ans*m);
    }
    public static void main(String[] args) {
        int m = 4, n = 5 ;
        question(m, n);
        
    }
    
}
