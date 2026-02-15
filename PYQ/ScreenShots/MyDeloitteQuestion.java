import java.util.HashSet;

// Problem Statement

// You are given a message msg that contains a list of words.
// A word is considered “Outstanding” if all of its characters belong to the following set of allowed characters:

// { H, I, N, O, S, X, Z, W }
 

// Write a program to count the number of outstanding words in the given message msg.

// Important Instructions

// Read the input from STDIN

// Print the output to STDOUT

// Do not print any extra or arbitrary strings, as they will be considered part of the output and may cause test cases to fail

// Constraints

// 0 < length of msg < 10000

// Only uppercase English letters (A to Z) are allowed in msg

// Letters in the message msg may repeat

// Input Format

// A single line of input containing a string representing the message msg

// Each word in msg is separated by a single whitespace

// Output Format

// Print a single integer representing the count of outstanding words in msg

// Sample Input 1
// HSSN

// Sample Output 1
// 1

// Explanation 1

// The message is "HSSN".
// All characters in the word belong to the allowed character set, so the count of outstanding words is 1.

// Sample Input 2
// OS IS UPDATED

// Sample Output 2
// 2

// Explanation 2

// The words "OS" and "IS" consist only of allowed characters.
// The word "UPDATED" contains characters not in the allowed set.
// Hence, the count of outstanding words is 2.



public class MyDeloitteQuestion{

    static void question(String str){
        int n =  str.length();

        HashSet<Character> set  = new HashSet<>();
        set.add('H');
        set.add('I');
        set.add('N');
        set.add('O');
        set.add('S');
        set.add('X');
        set.add('Z');
        set.add('W');
        
        
        String[] arr = str.split(" ");
        int count = 0;

        for(String  st:arr){

            String curr = st;
            boolean isOutStanding = true;

            for(int i = 0; i<curr.length(); i++){
                char ch  = curr.charAt(i);

                if(!set.contains(ch)) {
                    isOutStanding  = false;
                   
                    break;
                }
            }

            if(isOutStanding) count++;


        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        String str = "OS IS UPDATED";
        question(str);
        
    }
}