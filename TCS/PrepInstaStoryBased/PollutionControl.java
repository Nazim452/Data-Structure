package TCS.PrepInstaStoryBased;

// Example 1:

// Input :

// 4 -> Value of N

// {5,2,3,7} -> a[], Elements a[0] to a[N-1], during input each element is separated by a new line

// 12 -> Value of D, i.e. date 

// 200 -> Value of x i.e. fine

// Output :

// 600  -> total fine collected 

// Explanation:

// Date D=12 means , only an even number of vehicles are allowed. 

// Find will be collected from 5,3 and 7 with an amount of 200 each.

// Hence, the output = 600.
public class PollutionControl {
    static boolean checkEven(int n){
        if(n%2==0) return true;
        return false;
    }
    static void question(int[]arr, int d , int fine){

        int n = arr.length;
        boolean dateStatus = checkEven(d);
        int countOdd = 0;
        int countEven = 0;

        if(dateStatus==true){
            for(int i = 0; i<n; i++){
                if(!checkEven(arr[i])) countOdd++;
            }

            System.out.println(countOdd*fine);

        }

        else if(dateStatus==false){
            for(int i = 0; i<n; i++){
                if(checkEven(arr[i])) countEven++;
            }

            System.out.println(countEven*fine);

        }

         


    }
    public static void main(String[] args) {
        int[]arr = {2,5,1,6,8};  //900
        int d =3;
        // int[]arr = {5,2,3,7};  //600
        // int d =12;
        question(arr, d,300);
        
    }
    
}
