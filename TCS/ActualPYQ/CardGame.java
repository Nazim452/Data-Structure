package TCS.ActualPYQ;


// The Card Game Challenge
// You are participating in a unique card game where
// several cards are arranged in a row. Each card has a
// certain number of points written on it. Your goal is to
// collect exactly K cards in such a way that your total
// score is maximized.
// However, there’s a catch! You can only pick cards from
// either the beginning or the end of the row in each step.
// Once a card is picked, it is removed, and you continue
// picking until you have exactly K cards.
// Input Format:
// Your task is to determine the maximum score you can
// achieve by strategically picking cards.
// The first line contains an integer N, the number of
// cards.
// The second line contains N space-separated integers
// representing the points on each card.
// The third line contains an integer K, the number of
// cards you must pick.
// Output Format:
// Print the maximum score that can be achieved by
// picking exactly K cards optimally. 
// Input :
// 7 
// 1 2 3 4 5 6 1
// 3 
// Output :
// 12 
// Video Solution: Watch Her

import java.util.Scanner;

public class CardGame {

    static void question(int k, int[]arr){
        int n = arr.length;

        // left sum
        int leftSum = 0;
        for(int i = 0; i<k; i++)leftSum+=arr[i];

        int rightSum=0;
        int maxSum = leftSum;
        for(int i = 0; i<k; i++){
            leftSum-= arr[k-i-1];
            rightSum+=arr[n-i-1];
            maxSum = Math.max(rightSum+leftSum, maxSum);
        }

        System.out.println("MaxSum "+ maxSum);

        
    }
   
   
    public static int maxScoreFromCards(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // First calculate the sum of first k elements
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int rightSum = 0;

        // Now slide the window from right
        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[n - 1 - i];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;

        // Q1 -
        // 5
        // 5 4 3 2 10
        // 3
        //O/P -  19

        // 7
        // 1 2 3 4 5 6 1
        // 3
        //O/P -  12

        // 5
        // 10 20 30 40 50
        // 3
        //O/P -  120
    }

   
   
   
   
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }
        int K = scanner.nextInt();

        // Calculate maximum score
        int maxScore = maxScoreFromCards(cards, K);
        System.out.println(maxScore);

        // int[] arr = {5,4,3,2,10};
        // int[] arr = {10, 20, 30 ,40, 50};
        // int k = 3;
        // question(k, arr);
    }

}