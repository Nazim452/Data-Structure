package String;

public class FirstNonRepeatingChar {
    static void question(String str){
        int n= str.length();

        for(int i = 0; i<n; i++){
            char curr = str.charAt(i);
            boolean isFound  = false;
            for(int j =0; j<n; j++){
                char next =str.charAt(j);

                if(i!=j &&curr==next){
                     isFound = true;
                     break;
                }
                
            }

            if(!isFound) {
                System.out.println(curr);
                return;
            }
        }
    }


    static void question2(String str){
        int[] freq = new int[256];

        for(int i = 0; i<str.length(); i++){
            freq[str.charAt(i)]++;

        }

        for(int i = 0;   i<str.length(); i++){
            if(freq[str.charAt(i)]==1) {
                System.out.println(str.charAt(i));
                return;
            }
        }

    }
    
    public static void main(String[] args) {
        String str  = "abcccaad%$#d@fb";
        question2(str);
     

    }
}

