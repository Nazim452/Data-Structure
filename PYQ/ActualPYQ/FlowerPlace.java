package PYQ.ActualPYQ;

// We need to determine if we can plant n new flowers in a flowerbed represented by an array of 0s (empty) and 1s (planted), following the rule that no two flowers can be adjacent.

// Approach
// Iterate through the flowerbed to find empty plots (0s).

// Check adjacent plots to ensure they are also empty before planting a flower.

// Plant the flower (mark as 1) and decrement n if a valid spot is found.

// Return true if n reaches 0, otherwise false.

public class FlowerPlace {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;   //optional 
                     count++;

                    if (count >= n) {
                        return true;
                    }
                }
            }
        }   

        return count >= n;
    }


       public static void main(String[] args) {

        // int[] flowerbed1 = {1, 0, 0, 0, 1};
        // int n1 = 1;
        // System.out.println(canPlaceFlowers(flowerbed1, n1)); // Output: true

        // int[] flowerbed2 = {1, 0, 0, 0, 1};
        // int n2 = 2;
        // System.out.println(canPlaceFlowers(flowerbed2, n2)); // Output: false

        // int[] flowerbed = {1, 1, 1, 1, 1};
        // int n = 1; //false

        // int[] flowerbed = {0};
        // int n = 1; //true

        // int[] flowerbed = {1};
        // int n = 1; //false

        int[] flowerbed = {1, 0, 1, 0, 1};
        int n = 1; //false

        // int[] flowerbed = { 1, 0, 1 };
        // int n = 0; // true
        System.out.println(canPlaceFlowers (flowerbed, n)); // Output: false

    }
}
