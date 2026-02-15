import java.util.Scanner;




// M-II

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         sc.nextLine(); // consume newline

//         for (int i = 0; i < n; i++) {
//             String s = sc.nextLine();

//             int[] freq = new int[256]; // ASCII frequency map

//             // Count frequency
//             for (int j = 0; j < s.length(); j++) {
//                 freq[s.charAt(j)]++;
//             }

//             char result = s.charAt(0);
//             int maxCount = 0;

//             // Find first character with maximum frequency
//             for (int j = 0; j < s.length(); j++) {
//                 char ch = s.charAt(j);
//                 if (freq[ch] > maxCount) {
//                     maxCount = freq[ch];
//                     result = ch;
//                 }
//             }

//             System.out.println(result);
//         }

//         sc.close();
//     }
// }






// M- III


// import java.util.HashMap;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         sc.nextLine(); // consume newline

//         for (int i = 0; i < n; i++) {
//             String s = sc.nextLine();

//             HashMap<Character, Integer> map = new HashMap<>();

//             // Build frequency map
//             for (int j = 0; j < s.length(); j++) {
//                 char ch = s.charAt(j);
//                 map.put(ch, map.getOrDefault(ch, 0) + 1);
//             }

//             char result = s.charAt(0);
//             int maxCount = 0;

//             // Find most frequent character (first occurrence wins)
//             for (int j = 0; j < s.length(); j++) {
//                 char ch = s.charAt(j);
//                 if (map.get(ch) > maxCount) {
//                     maxCount = map.get(ch);
//                     result = ch;
//                 }
//             }

//             System.out.println(result);
//         }

//         sc.close();
//     }
// }














public class freqin2String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            char result = s.charAt(0);
            int maxCount = 0;

            for (int j = 0; j < s.length(); j++) {
                int count = 0;

                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(j) == s.charAt(k)) {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    result = s.charAt(j);
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}
