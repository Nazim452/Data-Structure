package TCS.MatheMatics;

public class SumOfTable {

    static  void findSumValueTable(int n){
        int tableSum =0;
        for(int i=1; i<=n; i++){
            tableSum+=n*i;

        }
        System.out.println("Total Table sum for given number  is"+tableSum);
    }
    public static void main(String[] args) {
        findSumValueTable(10);
        
    }
}
