package String;

public class Count {
    static void count(String str) {
        String ans = str.charAt(0) + "";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if (curr == prev)
                count++;
            else {
                ans += count;
                count = 1;
                ans += curr;

            }

        }
        if (count > 1)
            ans += count;
        System.out.println(ans);
    }
   

    static void count2(String str){
        int count =1;
        String  ans = str.charAt(0)+"";
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i-1)==str.charAt(i)) count++;

            else {
                 if(count>1) ans+=count;
                ans += str.charAt(i);
                count = 1;
            }
        }

        if(count>1) ans+=count;
        System.out.println(ans);
        


    }
   

    static void question(String str){
        String ans = str.charAt(0)+"";

        int count = 1;
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }
            else {
                ans+=count;
                ans+=str.charAt(i);
                count = 1;
            }
        }
        //  ans+=count;

         System.out.println(ans);
    }
   
    public static void main(String[] args) {

        String str = "abbbccccdd";
        question(str);
        
    }
}
