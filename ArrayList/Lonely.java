package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Lonely {

    ///Wrong output----________________________________________________________________________
    
    static ArrayList<Integer> lonely(ArrayList<Integer> list){

        ArrayList<Integer> res  = new ArrayList<>();
        int  n = list.size();
        Collections.sort(list);

        for(int i = 0; i<list.size(); i++){
            if(i!=0   &&( (list.get(i-1))==(list.get(i)-1)  ||   list.get(i-1)==list.get(i))){
                continue;

            }

             if(i!=n-1 && ((list.get(i+1)==list.get(i)+1)   ||  list.get(i+1)==list.get(i))){
                res.add(list.get(i));
            }
        }
        return res;

    }
   
    static ArrayList<Integer> lonely2(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size();
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            if ((i == 0 || list.get(i - 1) != list.get(i) - 1) && 
                (i == n - 1 || list.get(i + 1) != list.get(i) + 1)) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(11);
         System.out.println( lonely2(list));;
        
    }
    
}
