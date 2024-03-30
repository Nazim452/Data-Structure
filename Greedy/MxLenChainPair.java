package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MxLenChainPair {
    static void maxLenChainPAIr(int[][] pair){
        Arrays.sort(pair, Comparator.comparingDouble(o->o[1]));  //sort 1s row

        int chainLen  = 1;   //1st elemetn always consider in chain
        int chainEnd = pair[0][1];

        for(int i = 1; i<pair.length; i++){
            if(pair[i][0]>chainEnd){
                chainLen++;
                chainEnd=pair[i][1];
            }
        }

        System.out.println(chainLen);


    }
    public static void main(String[] args) {

        int[][]pair  ={{5,24},{39,60},{5,28},{27,40},{50,90}};
        maxLenChainPAIr(pair);
        
    }
}
