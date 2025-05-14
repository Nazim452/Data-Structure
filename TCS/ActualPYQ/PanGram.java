package TCS.ActualPYQ;

public class PanGram {

    static boolean question(String[] arr){
        int[] freq  = new int[26];

        for(int i = 0; i<arr.length; i++){
            String str  = arr[i];

            for(int j = 0; j<str.length(); j++){
                char ch = str.charAt(j);
                freq[ch-'a']++;

            }
        }

        for(int i = 0; i<freq.length; i++){
            if(freq[i]==0) return false;

            
        }
        return true;
    }
    public static void main(String[] args) {
        // String [] str ={ "the"  , "quick", "brown","fox", "jumps", "over","the","lazy","dog"};
        String [] str ={  "lazy","dog"};
        System.out.println(question(str));;

    }
}
