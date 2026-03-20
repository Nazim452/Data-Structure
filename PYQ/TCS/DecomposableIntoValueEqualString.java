package PYQ.TCS;

public class DecomposableIntoValueEqualString {
    static void question(String str){
        int count = 0;

        for(int i = 0; i<str.length()-1; i++){
            char curr = str.charAt(i);
            char next = str.charAt(i+1);

            if(curr==next){
                count++;
            }
            if(curr!=next) count = 0;
            if(count>=4){
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
    public static void main(String[] args) {
        question("000111000");
        question("00011111222");
        
    }
}
