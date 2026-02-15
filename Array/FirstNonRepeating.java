package Array;

public class FirstNonRepeating {

    public static int firstNonRepeating(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isRepeating = false;

            for (int j = i; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isRepeating = true;
                    break;
                }
            }

            if (!isRepeating) {
                return arr[i]; // Found the first non-repeating element
            }
        }

        return -1; // No non-repeating element found
    }
    

    public static void main(String[] args) {
        int[] arr = {-1,2,-1, 3, 2}; 
        System.out.println(firstNonRepeating(arr));          
    }
    
}
