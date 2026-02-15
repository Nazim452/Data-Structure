package PYQ.Propel;

import java.util.Arrays;
import java.util.HashSet;

public class q1 {
  static boolean question(String[] arr){
    String key = arr[0];
    String [] filter = arr[1].split(",");

    HashSet<String> set  = new HashSet<>(Arrays.asList(filter));

    boolean found = false;
    for(int i = 1; i<key.length(); i++){
        String left = key.substring(0, i);
        String right = key.substring(i);

        if(set.contains(right)&& set.contains(left)) return true;
    }

    return found;

  }

    public static void main(String[] args) {
        String [] str = {"baseball", "a,all,b,ball,base,cat,code,d,e,q,uit,z"};
        System.out.println(question(str));

        
    }
    
}
