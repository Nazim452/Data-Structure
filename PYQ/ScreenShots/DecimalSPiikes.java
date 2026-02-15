import java.util.Scanner;

public class DecimalSPiikes {


    static void question(int[] arr, int spike) {
        String ans = "";
        int finspik = spike;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int bin = decTOBin(curr);

            while (spike > 0 && bin > 0) {
                bin = bin / 10;
                spike--;

            }
            spike = finspik;
            System.out.println(bin);

            ans += bin;
        }
        System.out.println(ans);

    }

    static int decTOBin(int n) {
        int ans = 0;
        int pow = 0;
        while (n > 0) {
            int rem = n % 2;
            ans += rem * (int) Math.pow(10, pow);
            pow++;
            n = n / 2;

        }
        return ans;
    }

    static void question2(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] >> n);
            System.out.print(" ");
        }
    }

    static void question(String str){
        StringBuilder sb = new StringBuilder();

        for(int i   = 0; i<str.length()-1; i++){
            char curr = str.charAt(i);
            char next = str.charAt(i+1); //remove

            if(curr!=next){
                sb.append(curr);

            }
           else   if(curr==' ') sb.append(" ");
            

        }
        System.out.println(sb.toString());

    }
    
    public static void main(String[] args) {
        question("Hello There");
    

    }
}
