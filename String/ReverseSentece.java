package String;

public class ReverseSentece {
    static void reverse(String str) {

        String ans = "";
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            } else {
                sb.reverse();
                ans += sb;
                ans += ' ';
                sb = new StringBuilder("");
            }
        }
        sb.reverse();
        ans += sb;
        System.out.println(ans);
 
    }

    static void reverse2(String str){
         StringBuilder sb = new StringBuilder("");
         String ans="";
         for(int i = 0; i<str.length(); i++){

            char ch =  str.charAt(i);
            if(ch!=' ') sb.append(ch);

            else if (ch==' '){
                sb.reverse();
                ans+=sb;
                ans+= ' ';

               sb =new StringBuilder("");


                
            }
            
         }
        
         sb.reverse();
         ans+=sb;
         System.out.println(ans);
    }
    public static void main(String[] args) {
        String str = "i am a good educator";
        reverse2(str);

    }
}
