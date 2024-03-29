package Array;

public class SwapWithoutTemp {
    
    static void SwapWithouttemp(int a , int b){
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("The value of after swap");

        System.out.println("a = " +a);
        System.out.println("b = "+ b);
        
    }
    public static void main(String[] args) {
        int a = 10; 
       int b = 20;
       SwapWithouttemp(a, b);
        
    }
    
}
