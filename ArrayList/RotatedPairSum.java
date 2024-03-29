package ArrayList;

import java.util.ArrayList;

public class RotatedPairSum {
    static boolean pairSum(ArrayList<Integer> list, int tar) {
        int n = list.size();
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }

        }

        int l = bp+1, r = bp;

        while (l!=r) {
            if(list.get(l)+list.get(r)==tar) return true;

            else if(list.get(l)+list.get(r)<tar) l=(l+1)%n;

            else r = (n+r-1)%n;
            
        }
        return false;



    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(6);
        list.add(9);
        list.add(10);

        System.out.println(pairSum(list, 16));;
      

    }
}
