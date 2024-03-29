package Recursion;

public class FriendShipPair {
    static int friendShpPar(int n) {
        if (n == 1 || n == 2)
            return n;
        int single = friendShpPar(n - 1);
        int pair = (n - 1) * friendShpPar(n - 2);
        return single + pair;

    }
    public static void main(String[] args) {
        System.out.println(friendShpPar(3));
        
    }
}
