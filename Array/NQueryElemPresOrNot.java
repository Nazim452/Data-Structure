// package Array;

// import java.util.Scanner;

// public class NQueryElemPresOrNot {

//     static int[] MakeQuaryArr(int[] arr) {
//         int[] freq = new int[100005];

//         for (int i = 0; i < arr.length; i++) {
//             // freq[arr[i]]++;
//             // OR
//             freq[arr[i]] = freq[arr[i]] + 1;
//         }
//         return freq;

//     }

//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4, 5 };
//         int[] freq = MakeQuaryArr(arr);
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the no of queries, how mant times want to search");
//         int q = sc.nextInt();

//         while (q > 0) {
//             System.out.println("Enter no to be search");
//             int x = sc.nextInt();

//             if (freq[x] > 0) {
//                 System.out.println("Yes");
//             } else {
//                 System.out.println("No");
//             }
//             q--;
//         }

//     }

// }
