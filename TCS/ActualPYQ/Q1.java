package TCS.ActualPYQ;

public class Q1 {

    // [3,9,4   , 5, 3,2 ,  7,9,3  ,3,2] 
    //  n = 3
    // 3 is present in every these 3 chunks  so output  - 1 

    static int question(int[]arr, int n){
      
        int len = arr.length;
        for(int i = 0;i<len; i+=3 ){

            boolean isNPres  = false;
            for(int j= i; j<Math.min(i+3,len); j++){
                if(arr[j]!=n) isNPres = false;
                else {
                    isNPres = true;
                    break;
                }               
            }
            if(!isNPres) return 0;             
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 9, 4,      5, 3, 2,     7, 9, 3,     3, 2}; 
        int n1 = 3;
        System.out.println(question(arr1, n1)); // Output: 1
        
        int[] arr2 = {3, 9, 4,     5, 2, 3,     7, 9, 2,     3}; 
        int n2 = 3;
        System.out.println(question(arr2, n2)); // Output: 0 (3nd chunk does not contain `3`)
    
        
    }
    
}
