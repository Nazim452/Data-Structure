package TCS.ActualPYQ;

import java.util.*;

// Print - 

// --------------First Non-Repeating Character:

// Use a frequency map (LinkedHashMap to maintain order) to track occurrences.

// Identify the first character with frequency 1.

// -------------------Most Repeated Character:

// Track the character with the highest frequency in the map.

// If multiple characters have the same highest frequency, print the first non-repeating character first, then the repeating character.

// Edge Cases:

// If the input string is empty → Print "Invalid Input".

// If all characters are repeating → Print "None" followed by the first repeating character.

public class RepetingString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // sc.close();

        if (input.isEmpty()) {
            System.out.println("Invalid Input");
            return;
        }

        LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<>();
        char firstRepeating = '\0';
        char firstNonRepeating = '\0';
      
        // Step 1: Count frequency of each character & identify first repeating
        // character
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i); // Extract the character first
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        }

        // OR ---------OR----------Or

        // for (char c : input.toCharArray()) {
        // freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        // }

        for (var entry : freqMap.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();

            if (count > 1) {
                firstRepeating = key;
                break;
            }
        }
        // Step 2: Identify first non-repeating character
        for (var data : freqMap.entrySet()) {
            char key = data.getKey();
            int value = data.getValue();

            if (value == 1) {
                firstNonRepeating = key;
                break;
            }
        }

        // Step 3: Identify most repeated character
        int maxFreq = 0;
        char mostRepeated = '\0';
        for (var entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostRepeated = entry.getKey();
            }
        }

        // Step 4: Handle different cases based on conditions
        if (firstNonRepeating != '\0' && maxFreq > 1) {
            System.out.println(firstNonRepeating + " " + mostRepeated);
        } else if (firstNonRepeating != '\0') {
            System.out.println(firstNonRepeating);
        } else {
            System.out.println("None " + firstRepeating);
        }
    }
}