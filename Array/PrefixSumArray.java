// package Array;

// import java.util.Scanner;


// public class PrefixSumArray {
//     static int[] MakePrefixSumArray(int[] arr) {
//         for (int i = 1; i < arr.length; i++) {
//             arr[i] += arr[i - 1];
//         }
//         return arr;
//     }

//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4, 5 };
//         int[] prefsum = MakePrefixSumArray(arr);

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no of qeries");

//         int q = sc.nextInt();

//         while (q-- > 0) {
//             System.out.println("Enter range");
//             int l = sc.nextInt();
//             int r = sc.nextInt();
//             int ans;
//             if (l == 0)
//             ans = prefsum[r];
//             else
//             ans = prefsum[r] - prefsum[l - 1];


//             System.out.println("Sum= " + ans);
//         }

//     }

// }
