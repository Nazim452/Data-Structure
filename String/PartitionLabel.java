package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// ✅ Each letter should appear in only one part.
// ❌ You can't repeat a letter in another part once it appeared in a previous part.

// 763. Partition Labels
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

 

// Example 1:

// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
// Example 2:

// Input: s = "eccbbbbdec"
// Output: [10]
 

public class PartitionLabel {
     static List<Integer> partitionLabels(String s) {
        // Step 1: Store last index of each character
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i); 
        }

        // Sout

        // for(var data:lastIndex.entrySet()){
        //     System.out.println(data.getKey()+" "+ data.getValue());
        // }

        List<Integer> result = new ArrayList<>();
        int start = 0;  
        int end = 0;    

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            end = Math.max(end, lastIndex.get(currentChar));  

            if (i == end) {
                result.add(end - start + 1); 
                start = i + 1;  
            }
        }

        return result;
    }

    public static void main(String[] args) {
      List<Integer> ans =   partitionLabels("ababcc");  //4 2 

      for(int  data:ans){
        System.out.print(data+" ");
      }
    }
}
