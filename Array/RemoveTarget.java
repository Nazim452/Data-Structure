package Array;

//Not getting Clear Idea_____________________________________________________

public class RemoveTarget {
    

    static int removeTarget(int[]arr, int val){
        int count = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[i]!=val){
                arr[count] =arr[i];
                count++; 
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int[]arr = { 3,2,2,3,8,10};

        System.out.println(removeTarget(arr, 3));
        
    }
    
}
