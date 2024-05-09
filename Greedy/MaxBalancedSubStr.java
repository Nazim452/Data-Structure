package Greedy;

public class MaxBalancedSubStr {

    static void maxBal(String s){
        int n = s.length();
        int l=0, r=0, ans=0;

        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='L') l++;
            else r++;

            if(
                l==r){
                ans++;
                l=r=0;
            }
        
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        // String s = "LRLRRLRL";  //3
        String s = "LRRRRLLRLLRL";
        // String s = "LLLRRRRRLLRLLR";//4
        maxBal(s);
        
    }
}
