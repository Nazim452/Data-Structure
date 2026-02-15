package HashMap;

import java.util.HashMap;
// import java.util.HashSet;
import java.util.LinkedHashMap;

import Stack.ArrayInplem.stak;

public class ValidAnagram {


    // Brute Force - Time Complexity - O(n^2)

        static boolean ValidAnagramMyyy(String s , String t){
        int n1 = s.length();
        int n2 = t.length();

        if(n1!=n2) return false;

        for(int i = 0; i<n1; i++){

            boolean found = false;

            char ch = s.charAt(i);

            for(int j = 0; j<n2; j++){
                if(ch==t.charAt(j)){
                    found = true;
                    break;
                }
            }

            if(!found) return false;

        }
        return true;

    }



   
    static HashMap<Character, Integer> make_freq_string(String s){

        // 2nd Method - 

        //  HashMap<Character , Integer> map = new LinkedHashMap<>();

        // for(int i = 0 ;i<s.length(); i ++){

        //     char ch = s.charAt(i);

        //     map.put(ch ,map.getOrDefault(ch,0 )+1);
        // }


        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!mp.containsKey(ch)){
                mp.put(ch, 1);
            }else{
                int currFreq = mp.get(ch);
                mp.put(ch,currFreq+1);
            }
        }
        return mp;
    }


    
    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp1 = make_freq_string(s);
         HashMap<Character,Integer> mp2 = make_freq_string(t);
        return  mp1.equals(mp2);

    } 



    //2nd way to achieve anagram_______________________________________________________
     
    public static boolean isAnagram1(String s, String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp = make_freq_string(s);

        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);

            if(!mp.containsKey(ch)) return false;
            int currFreq = mp.get(ch);
            mp.put(ch, currFreq-1);
        }

        for(var i:mp.values()){
            if(i!=0){
                return false;
            }

        }
        return true;
      
    } 




    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";
        System.out.println(isAnagram(s1, s2));
        
    }
}
