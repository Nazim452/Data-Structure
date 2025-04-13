package TCS.PrepInstaStoryBased;

import java.util.Scanner;

// Note : 1st element of the array should be considered in the count of the result.

// For example,

// Arr[]={7,4,8,2,9}

// As 7 is the first element, it will consider in the result.

// 8 and 9 are also the elements that are greater than all of its previous elements.

// Since total of  3 elements is present in the array that meets the condition.

// Hence the output = 3.

public class GreaterThanPrev {

    static void question(int[]arr){
        int n = arr.length;
        int count=1;

        for(int i = 1; i<n; i++){
            if(arr[i]>arr[i-1]) count++;

        }

        System.out.println(count);
    }
    

    static void question2WithInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n = sc.nextInt();

        int[]arr = new int[n];
        for(int i = 0; i<n; i++){

            arr[i] = sc.nextInt();
        }

        int count=1;

        for(int i = 1; i<n; i++){
            if(arr[i]>arr[i-1]) count++;

        }

        System.out.println(count);
    }
    
    
    static void secondApproach(int[] arr){
        int n = arr.length;
        int maxm = Integer.MIN_VALUE;

        int count = 0;
        for(int i = 0; i<n; i++){
            if(arr[i]>maxm){
                maxm  = arr[i];
                count++;
            }
        }

        System.out.println(count);
    }
    
    
    
    public static void main(String[] args) {
        // int[]arr = {7,4,8,2,9};  // 3
        // question(arr); 
        int[]arr = {3,4,5,8,9};  // 5
        // question2WithInput(); 
        secondApproach(arr);
    }
}
