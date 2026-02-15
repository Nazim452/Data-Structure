package PYQ.Propel;
// Problem 4: Longest Prefix Present in Dictionary
// Problem Statement

import java.util.*;

// Given:

// A string

// A dictionary of words

// Find the longest prefix of the string that exists in the dictionary.

// Return the prefix.
// If no prefix exists, return not possible.

// Example 1

// Input

// ["developer", "dev,develop,developer,code"]


// Output

// developer

// Example 2

// Input

// ["interview", "int,inter,view"]


// Output

// inter

// DSA Skills Tested

// Prefix scanning

// Greedy logic

// String slicin
public class q6 {

    static void question(String[]arr){
        String  key = arr[0];
        String[] filter = arr[1].split(",");

        HashSet<String> set = new HashSet<>(Arrays.asList(filter));

        String maxSubString = "";
        String ans = "Not Found";
        for(int i = 0; i<key.length(); i++){
            char curr = key.charAt(i);
            maxSubString+=curr;

            if(set.contains(maxSubString)) ans = maxSubString;


            
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        // String[]arr = {"interview", "int,inter,view"};
        String[]arr = {"developer", "dev,develop,developer,code"};
        question(arr);
        
    }
    
}
