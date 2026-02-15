package PYQ.Zoho;

public class SubstringOfAnotherSbstring {

    static int question(String str1 , String str2){
        int n1 = str1.length();
        int n2  = str2.length();

       return str1.indexOf(str2);
    }
    
    public static void main(String[] args) {
        System.out.println(question("test123String", "123"));
        
    }
}
