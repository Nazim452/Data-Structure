package ArrayList;

import java.util.ArrayList;

public class MostFreqAfterKey {

    static int mostFreq (ArrayList<Integer> list , int key){
        int[]count = new int[100001];

        for(int  i = 1; i<list.size(); i++){
            if(list.get(i-1)==key)  count[list.get(i)]++;
        }

        //finding idx whose greate value

        int maxIndex = 0;

        for(int i = 0; i<count.length; i++){

            maxIndex = count[i]>count[maxIndex]? i:maxIndex;

        }
        return maxIndex;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(4);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(7);

      System.out.println(  mostFreq(list, 4));
        
    }
}
