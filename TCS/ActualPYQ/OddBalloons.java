package TCS.ActualPYQ;

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

        char []arr = {'r','g','b','b','g','y','y'};   //r
        // char []arr = {'a','b','b','b','c','c','c','a' , 'f', 'c'}; //b
        question(arr);


        
    }
}
