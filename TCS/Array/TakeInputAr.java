package TCS.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class TakeInputAr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int[]arr = new int[n];

        for(int  i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("You entered: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }



        
    }
    
}
