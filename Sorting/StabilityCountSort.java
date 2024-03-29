package Sorting;

public class StabilityCountSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int findMax(int[]arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    
    static void stabilityCountSort(int[]arr){
        int n = arr.length;
        int[]output = new int[n]; // sc - n

        int maximum = findMax(arr);

        int []count = new int[maximum+1];   //SC - max---k

        for(int i = 0; i<arr.length; i++){   // TC - n
            count[arr[i]]++;
        }

        // make prefix sum array of count - prefix sum me index rahta hai ki kis elem ko kis 
        // particular index par rakhna hai

        for(int i = 1; i<count.length; i++){     // TC - max ---k 
            count[i]+=count[i-1];
        }

        // find the index of each elemnt in the original arry &put in output array

        // travese back for maintain stability

        for(int i = n-1; i>=0; i--){   // tC = n

            int index = count[arr[i]] -1;  //  count[arr[i]] -- isse hame position pata & 1- se index
            output[index] = arr[i];
            count[arr[i]]--;

        }

          // copy all elem of output to array
          for(int i = 0; i<n; i++){
            arr[i] = output[i];
          }

    }
    public static void main(String[] args) {
        int[] arr = { 6, 3, 1, 1, 5, 5, 4 };
        stabilityCountSort(arr);
        printArray(arr);


        
    }
    
}
