package HashMap;

import java.util.HashMap;
// import java.util.HashSet;

public class ValidAnagram {


   
    static HashMap<Character, Integer> make_freq_string(String s){
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
