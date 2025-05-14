package TCS.ActualPYQ;

import java.util.*;

public class Revision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        if (input.length() == 0) {
            System.out.println("Invalid input");
            return;
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char firstRepeating = '\0';
        char firstNonRepeating = '\0';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        // Find first non-repeating

        for(var entry:map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();

            if(value==1){
                firstNonRepeating =key;
                break;
            }

        }

        // Find First repeating

        for(var entry:map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(value>1){
                firstRepeating = key;
                break;
            }


        }

        // Most Repeated
        int maxFreq =0;
        char mostRepeated='\0';

        for(var entry:map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();

            if(value>maxFreq){
                mostRepeated = key;
                maxFreq = value;
            }
            

        }

        // Handle

        if(firstNonRepeating!='\0' && maxFreq>1){
            System.out.println(firstNonRepeating+" "+ mostRepeated);

        }
        else if (firstNonRepeating!='\0'){
            System.out.println(firstNonRepeating);
        }
        else {
            System.out.println("None " + firstRepeating);
        }

    }
}