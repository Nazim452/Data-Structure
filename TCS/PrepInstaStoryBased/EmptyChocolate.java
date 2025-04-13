package TCS.PrepInstaStoryBased;
// A chocolate factory is packing chocolates into the packets. The chocolate packets here
//  represent an array  
// of N number of integer values. The task is to find the empty packets(0) of chocolate and push it to the 
// end of the conveyor belt(array).

import java.util.Scanner;

public class EmptyChocolate {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void chocolate(int[]arr){
        // Scanner sc = new Scanner(System.in);

        // int num = sc.nextInt();

        int i = 0; int j = arr.length-1;
        while(i<j){
            if(arr[i]!=0) i++;
           else  if(arr[j]==0) j--;

            else if(arr[i]==0 && arr[j]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        printArray(arr);
        
    }
    
    static void actual(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[]ans  = new int[n];

        for(int i = 0;  i<n; i++){
            ans[i] = sc.nextInt();
        }
        int count = 0;

        for(int i = 0; i<n;  i++){
            if(ans[i]!=0) ans[count++] = ans[i];
        }

        for(int i = count; i<n; i++){
            ans[i] =0;
        }

        printArray(ans);
    }
    public static void main(String[] args) {
        int []arr = {0,4,5,0,1,9,0,5,0}; // O/P - 4 5 1 9 5 0 0 0
        // int []arr = {6,0,1,0,8,0,2}; // O/P - 4 5 1 9 5 0 0 0
        // chocolate(arr);

        actual();



    }
}
