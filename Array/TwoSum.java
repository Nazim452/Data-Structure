package Array;

public class TwoSum {
    static int TargetSum(int []arr, int target){
        int ans = 0; 
        for(int i = 0; i<arr.length; i++){
            for(int j= i+1;j<arr.length; j++){
                if (arr[i] + arr[j] == target){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = { 2,4,5, 6, 1 };
        // 2+5 = 7
        // 1+6 = 7
        System.out.println(TargetSum(arr, 7));
        
    }
    
}
