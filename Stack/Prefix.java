package Stack;

import java.util.Stack;

public class Prefix {
    public static void main(String[] args) {
        
        String str = "-9/*+4356";
        Stack<Integer> val = new Stack<>();

        for(int i = str.length()-1; i>=0; i--){
            char ch  = str.charAt(i);
            int asci=  (int)ch;

            if(asci>=48&& asci<=57){
                val.push(asci-48);
            }
            else {
                int v1 = val.pop();
                int v2 = val.pop();

                if(ch=='+') val.push(v1+v2);
                if(ch=='-') val.push(v1-v2);




                
                if(ch=='*') val.push(v1*v2);
                if(ch=='/') val.push(v1/v2);
            }
        }
   
      System.out.println(val.peek());
  


 
    
    }
    
}
