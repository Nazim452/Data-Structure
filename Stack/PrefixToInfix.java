package Stack;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
              
        String str = "-9/*+4356";
        Stack<String> val = new Stack<>();

        for(int i = str.length()-1; i>=0; i--){
            char ch  = str.charAt(i);
            int asci=  (int)ch;

            if(asci>=48&& asci<=57){
                val.push(ch+"");
            }
            else {
                String v1 = val.pop();
                String v2 = val.pop();

                char  op = ch;
                String rt = v1+op+v2;
                val.push(rt);

                
           }
       }
   
      System.out.println(val.peek());
  



    }
    
}
