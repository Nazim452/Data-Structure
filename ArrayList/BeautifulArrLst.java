package ArrayList;

import java.util.ArrayList;

import LinkedList.CutomLinkedList.node;

public class BeautifulArrLst {

    static  ArrayList<Integer> btfl(int n){
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(1);

        while (ans.size()<n) {
            ArrayList<Integer> temp = new ArrayList<>();


            //odd

            for(int i = 0; i<ans.size(); i++){
                if((ans.get(i)*2-1)<=n) temp.add(ans.get(i)*2-1);

            }

            ///even

            for(int  i = 0; i<ans.size(); i++){
                if(ans.get(i)*2<=n) temp.add(ans.get(i)*2);
            }

            ans=  temp;


            
        }
        return ans;

    }
     public static void main(String[] args) {
        // System.out.println(btfl(5));
        int n = 10;

        for(int i = 1; i<=10; i++){
            int res = n+i;
            System.out.println(n +"X"+ i +"="+ res);     
     }

   


     }
}