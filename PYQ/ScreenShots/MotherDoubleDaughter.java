public class MotherDoubleDaughter {

    static void question(int d , int m){
        int ans  = 0;

        while (m!=d*2) {
            d++;
            m++;
            ans++;
            
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {

        question(7,36 );
        
    }
}
