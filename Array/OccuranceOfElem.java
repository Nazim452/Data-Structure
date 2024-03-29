package Array;

public class OccuranceOfElem {
    static int  Occurance(int [] arr , int x){
        int count =0; 
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int  [] arr = { 23, 45, 67,23, 23, 23,23,45,45};
        System.out.println("COUNT  OF X IS " + Occurance(arr, 45));
        
    }
    
}
