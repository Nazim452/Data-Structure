package PYQ.TCS;

public class PipeJunction{
    static int arraySum(int []arr){
        int n= arr.length;
        int sum = 0;
        for(int i= 0; i<n;i++){
           sum+=arr[i];
        }
        return sum;
    }
    static void  question(int[] incoming , int[] outgoing , int r){
        int icomLen = incoming.length;
        int outgoLen = outgoing.length;

        int incomeSum = arraySum(incoming);
        int outgoingSum = arraySum(outgoing);

        if(incomeSum==outgoingSum){
            System.out.println("Balanced");
            return;
        }
        int ans = 0;

        if(incomeSum>outgoingSum){
            ans = incomeSum-outgoingSum+r;
            System.out.println(-ans);
            return;

        }
        else{

            ans = outgoingSum-incomeSum+r;
            System.out.println(ans);            
            return;

        }

    }
    public static void main(String[] args) {

        int[] incoming = {85,75,95};
        int[] outgoing = {70,80,45};
        int r  = 2;
        question(incoming, outgoing, r);
        
    }

}