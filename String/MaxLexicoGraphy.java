package String;

public class MaxLexicoGraphy {
    static void lex(String[] fruit){
        String largest = fruit[0];

        for (int i = 1; i < fruit.length; i++) {

            // pahle chhota letter & baad me bada letter hai to value -ve aayega. Baad me bada hai means ab use max me dalna padega
          
            if(largest.compareTo(fruit[i])<0) largest = fruit[i];

            
        }
        System.out.println(largest);
    }
    public static void main(String[] args) {
        String[] fruit = {"apple", "orange", "mango","papaye"};
        lex(fruit);
        
    }
}
