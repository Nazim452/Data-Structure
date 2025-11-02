package TCS.String;

public class LongestSubstringWithoutRept {
    static void question(String str){
        int n = str.length();
        int maxEnd = -1;
        int ans = 0;
        for(int i = 0; i<n; i++){
             char curr = str.charAt(i);

            for(int j = i+1; j<n; j++){

                if(curr==str.charAt(j)){
                    maxEnd = j;
                    ans = j-i+1;
                }
                else ans = j-i+11;


            }

        }

    }
    public static void main(String[] args) {

        String str = "abcddabac";
        question(str);
        
    }
}
