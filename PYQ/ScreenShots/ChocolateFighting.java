public class ChocolateFighting {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    static void question(int n , int x){
        // Bob - x
        // Alice - y

        int box = 0, bob  = x, alice = n-x;

        while(bob!=alice){

            if(bob<alice){
                box+=bob;
                alice-=bob; 

            }
            else{
                box+=alice;
                bob-=alice;

            }

        }
        System.out.println(box);
    }
    public static void main(String[] args) {

        // question(10, 4);
        System.out.println(gcd(10, 4));
        
    }
}
