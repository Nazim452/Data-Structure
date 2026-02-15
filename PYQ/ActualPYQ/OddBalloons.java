package PYQ.ActualPYQ;

import java.util.LinkedHashMap;

public class OddBalloons {
    static boolean findOdd(int n){
        if(n%2==0) return false;
        return true;
    }

    static void question(char [] arr){
        LinkedHashMap<Character , Integer> map = new LinkedHashMap<>();

        for(char c: arr){
            // map.put(c , map.getOrDefault(c,0)+1);

            if(map.containsKey(c))   map.put(c ,map.get(c)+1);
            
            else map.put(c,1);
        }

        for(var data:map.entrySet()){
            char key = data.getKey();
            int value = data.getValue();

            if(findOdd(value)){
                System.out.println(key);
                return;
            }
        }


    }

    public static void main(String[] args) {

        // Prolem statement - Those ballons present odd number of time(1,3,5) return that

        // char []arr = {'r','g','b','b','g','y','y'};   //r-odd number times
        char []arr = {'a','b','b','b','c','c','c','a' , 'f', 'c'}; //b & f - odd num  , b first so b - output, 
        question(arr);


        
    }
}
