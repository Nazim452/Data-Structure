package Recursion;

public class Reverse {
    static String reverse(String s, int index){
        if(s.length()==index) return " ";

        String smallAns = reverse(s, index+1);

        return smallAns + s.charAt(index);

    }
    public static void main(String[] args) {
        String s = "apple";
        // System.out.println(reverse(s, 0));


        //Checking Palindrome___________________________________________________________

        
        String rev = reverse(s, 0);
        if(rev.equals(s)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
    }
}
