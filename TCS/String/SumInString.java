package TCS.String;

import java.util.Scanner;
// Next - Space ke baad wala string ko ignore 
// Nextline - Space is also including
public class SumInString{
    static void question(String str){
        int sum = 0;

        int  n = str.length();

        for(int i  = 0; i<n; i++){
            char ch = str.charAt(i);

             int ascii = (int)ch;
             if( ascii>=48 && ascii<=57){
                int num = ascii-48;
                sum+=num;
             }
        }

        System.out.println(sum);

    }
    static void questionInput(){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int sum = 0;

        int  n = str.length();

        for(int i  = 0; i<n; i++){
            char ch = str.charAt(i);

             int ascii = (int)ch;
             if( ascii>=48 && ascii<=57){
                int num = ascii-48;
                sum+=num;
             }
        }

        System.out.println(sum);

    }
    public static void main(String[] args) {

        // String str = "abc123xyz45";
        // question(str);
        questionInput();

        
    }
}





