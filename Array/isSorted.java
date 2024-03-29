package Array;

public class isSorted {
    static boolean IsSorted(int[] arr ,int x){
        boolean check = true;

        for(int i = 1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                check =  false;
                break;
            }
        }
        return check;
    }
    public static void main(String[] args) {
        int [] arr = { 2,3,4,5,6, 8};
        System.out.println(IsSorted(arr , 0));
        
    }
    
}
