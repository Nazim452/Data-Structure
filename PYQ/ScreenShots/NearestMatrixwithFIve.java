public class NearestMatrixwithFIve {
    static void question(int n){

        // find lower and upper multiple 5

        //  Eg - 27  (lower 25 , uppper - 30 ===>> Which is multiple of 5)

        int lower = (n/5)*5;
        int upper = lower +5; // jub lower pata chal gaya hai to upper me sirf 5 add karne ki arurat hai

        System.out.println(lower +" "+ upper);
       


    }
    public static void main(String[] args) { 
        question(27);
        
    }
}
