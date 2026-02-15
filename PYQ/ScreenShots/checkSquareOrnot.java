import java.sql.Time;

public class checkSquareOrnot {
    static boolean question(int n){
        for(int  i = 0; i*i<=n; i++){
            if(i*i==n) return true;

        }
        return false;
    }

//     ⏱ Time Complexity:
// O(√n)


// Much bett
    public static void main(String[] args) {
        System.out.println(question(34));
        
    }
    
}
