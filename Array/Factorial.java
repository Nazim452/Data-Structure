package Array;


public class Factorial{
    static void fact(int n){
        int ans = 1;

        for(int i = 1; i<=n; i++){
            ans=ans*i;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        fact(5);
        
    }
}




