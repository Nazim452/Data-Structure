import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Deloitte {

    static void question1(String str) {
        int n = str.length();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            ans += (int) ch;
        }
        System.out.println(ans);
    }

    static void question2(int x, int n) {
        // for(int i = 0; i<Math.max(i,n); i++){
        // if(n*i==x) {
        // System.out.println(i);
        // return;
        // }

        // }

        System.out.println(x / n);
    }

    static void question3(int m, int n) {
        // if(m==0 && n==0) return;
        int product = m * n;
        int sum = m + n;
        int AbsDiff = Math.abs(product - sum); // 34

        int factorSum = 1;
        for (int i = 2; i <= AbsDiff; i++) {
            if (AbsDiff % i == 0)
                factorSum += i;

        }
        System.out.println(factorSum);
    }

    static void question4CountMostFreq() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n= 2;

        while (n > 0) {
            String str = sc.next();

            // Hello
            int[] freq = new int[26];

            for (char ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    freq[ch - 'a']++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    freq[ch - 'A']++;
                }
            }

            char ans = str.charAt(0);
            int currMax = 0;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > currMax) {
                    currMax = freq[i];
                    ans = (char) ('a' + i); // ✅ FIX
                }
            }
            System.out.println(ans);

            n--;
        }

    }

    static void question2(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int j = i;
            int count = 0;

            while (count < n) {
                list.add(arr[j]);
                j++;

                if (j == n) { // jump back to start
                    j = 0;
                }

                count++;

            }
            System.out.println(list);
        }

    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void questionexclude(int[] arr, int x) {
        int n = arr.length;
        int k = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] != x) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {

    }
}