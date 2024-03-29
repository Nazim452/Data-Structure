package Array;

//Not getting Clear Idea_____________________________________________________

public class RemoveDuplicate {

    
    static int removeSDuplicate(int []arr){
        int j = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[j]!=arr[i]){
                j++;
                arr[j]=arr[i];
                
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,2,3,4,5,6};
       System.out.println( removeSDuplicate(arr));
        
    }
    
}
