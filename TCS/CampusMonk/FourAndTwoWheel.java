package TCS.CampusMonk;

public class FourAndTwoWheel {
    static void question(int v , int w){
        int y = (w-(2*v))/2;
        int x = v-y;

        System.out.println("TW "+ x +" FW "+y);
    }
    public static void main(String[] args) {
        int v = 200;
        int w = 540;
        question(v, w);
        
    }
    
}
