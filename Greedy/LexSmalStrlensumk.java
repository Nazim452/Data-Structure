package Greedy;

public class LexSmalStrlensumk {

    static void lex(int  n , int k){
        int kk = k-n;
        String s ="";


        for(int i = n-1; i>=0; i--){
            if(kk>=25){
                s+='z';
                kk-=25;

            }
            else{
                s+=(char)('a'+kk);
                kk-=kk;
            }
        }
        String ans = "";
        for(int i = n-1; i>=0; i--){
            ans=ans+s.charAt(i);
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int n = 5, k=42;
        lex( n, k);
        
    }
}
