package String;

public class PalinDrome {
    static boolean isPalindrome(String str){
        int i =0, j = str.length()-1;
        boolean flag = true;      // palindrome
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                flag = false;
                break;
            }
            i++; 
            j--;
        }
        if(flag==true) return true;
        return false;
    }


    // Second Way______________________________________________________________________

    
    static boolean palindrome(String str, int l, int r) {
        if (l >= r)
            return true;

        if (str.charAt(l) != str.charAt(r))
            return false;

        return palindrome(str, l + 1, r - 1);
    }
    public static void main(String[] args) {
        
    }
}
