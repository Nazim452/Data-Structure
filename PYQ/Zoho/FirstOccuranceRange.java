package PYQ.Zoho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstOccuranceRange {
    static int firstOccurance(String str1 , char tar){

         int FirstOcc = 0;
        HashMap<Character,List<Integer>> map = new HashMap<>();

        for(int i = 0; i<str1.length(); i++){
            char ch = str1.charAt(i);

            if(!map.containsKey(ch)){
                List<Integer> val = new ArrayList<>();
                val.add(i);
                map.put(ch,val);
            }
            else {
                List<Integer> val = map.get(ch);
                val.add(i);
            }
         
        }
    

        for(var data:map.entrySet()){
            char key = data.getKey();
           

            if(key==tar){
                 List<Integer> value = data.getValue();
             FirstOcc = value.get(0);


            }
        }
        return FirstOcc;

    }
    static void question(String str1 , String str2){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<str2.length(); i++){
            int firstOcc  = firstOccurance(str1, str2.charAt(i));
            min = Math.min(min, firstOcc);
            max  = Math.max(max, firstOcc);
        }

        System.out.println(str1.substring(min,max+1));

        System.out.println(min);
        System.out.println(max);

    }


    // Optimized - 

    static void questionOptimized(String str1, String str2) {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < str2.length(); i++) {

        int firstOcc = str1.indexOf(str2.charAt(i));

        if (firstOcc == -1) {
            System.out.println("Character not found");
            return;
        }

        min = Math.min(min, firstOcc);
        max = Math.max(max, firstOcc);
    }

    System.out.println(str1.substring(min, max + 1));
}




    public static void main(String[] args) {
      String  str1 = "ZOHOCORPORTION";
      String str2 = "PORT";
      question(str1, str2);
     
        
    }
}
