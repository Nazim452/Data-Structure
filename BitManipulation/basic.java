package BitManipulation;

public class basic {
    static void eveOdd(int n){
        int bitMask=1;
        if((n&bitMask)==0) System.out.println("Even");
        else System.out.println("Odd");
    }

    static void getBit(int n,  int i){
        int bitMask=1<<i;
        if((n&bitMask)==0) System.out.println("0");
        else System.out.println("1");
    }

    static int setBit(int  n,  int i){
         int bitMask=1<<i;
         return n|bitMask;
    }

    static int clearithBit(int n, int i){
        int  bitMask=~(1<<i);
        return n&bitMask;
    }

    static int updateithBit(int n, int i, int newBit){
        if(newBit==0) return clearithBit(n, i);
        else return setBit(n, i);

    }
    public static void main(String[] args) {
        //  eveOdd(1685647668);
        // getBit(4, 1);
        // System.out.println(setBit(10, 2));
        // System.out.println(clearithBit(10, 1));

    //    System.out.println(updateithBit(10, 1, 0));


    }
}
