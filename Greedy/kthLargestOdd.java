package Greedy;

public class kthLargestOdd {
    static void kthlarODDD(int l, int r,  int k){
        int x, ans;
        if(r%2==1) x=r;
        else x = r-1;

        ans = x-2*(k-1);
        if(ans<l) System.out.println(0);
        else System.out.println(ans);
    }
    public static void main(String[] args) {

        kthlarODDD(-10, 25, 7);//13;
        
    }
}
