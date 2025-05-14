package TCS.PrepInstaStoryBased;
// Example 1:

import java.util.Scanner;

// Input :

// bbbaaababa -> Value of str - Har 1 string me a raehga hi rahge..

// 3    -> Value of L

// Output:

// 3   -> Maximum number of a’s

// Explanation:

// From the input given above.

// Dividing the string into sets of 3 characters each 

// Set 1: {b,b,b}

// Set 2: {a,a,a}

// Set 3: {b,a,b}

// Set 4: {a} -> leftover characters also as taken as another set

// Among all the sets, Set 2 has more number of a’s. The number of a’s in set 2 is 3.

// Hence, the output is 3.

public class curtainsManufacturing {

    static void question(String str, int l) {
        int n = str.length();
        int maxCount = 0; // Variable to store maximum count of 'a' in any substring

        for (int i = 0; i < n; i += l) {
            int countA = 0;
            
            // Process the substring from index i to i + l or end of the string
            // Math.min(i + l, n): Ensures we don't exceed the string length.
            for (int j = i; j < Math.min(i + l, n); j++) {
                if (str.charAt(j) == 'a') {
                    countA++; // Count 'a' in this segment
                }
            }

         
            maxCount = Math.max(maxCount, countA);
        }

        System.out.println(maxCount);
    }


    static void question2WithInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.next();

        System.out.println("Enter the length of box");
        int l = sc.nextInt();

        int n = str.length();

        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i<n; i+=l){
            int countA = 0;

            for(int j = i; j<Math.min(i+l,n); j++){
                if(str.charAt(j)=='a') countA++;
            }
            maxCount =Math.max(maxCount, countA);
        }

        System.out.println(maxCount);
    }
   
    // Since the outer loop runs ceil(N / L) inner loop L times :

    // N/L X L =  N 
   
   
    public static void main(String[] args) {
        String str = "bbbaaababa"; //3 
        int l = 3;
        
        // String str = "abbbaabbb";  //2
        // int l = 5;
        // question(str, l);

        question2WithInput();
        
    }
}
