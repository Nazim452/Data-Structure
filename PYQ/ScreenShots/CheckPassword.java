public class CheckPassword {
    static boolean question(String str){
        int n = str.length();

        if(n<8) return false;
        boolean isNumber = false , isUpperCase  = false, islowercase = false, isSpecialChar = false;
        for(int i = 0; i<n; i++){
            char curr =str.charAt(i);

            if(Character.isDigit(curr)) isNumber = true;
            if(Character.isUpperCase(curr)) isUpperCase = true;

            if(Character.isLowerCase(curr)) islowercase = true;

            if(!Character.isLetterOrDigit(curr)) isSpecialChar = true;



        }

        if(!isNumber || ! isUpperCase || !islowercase|| !isSpecialChar) return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(question("tEst1230"));
        
    }
}
