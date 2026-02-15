package PYQ.ActualPYQ;

// int[] entry =  {7,0,5,1,3};
// int[] leave  = {1,2,1,3,4};

// 1st hour - entry - 7 , exit  - 1 , guest on the ship = 6;
// 2nd hour - entry - 0 , exit  - 2 , guest on the ship = 6-2=4;
// 3rd hour - entry - 5 , exit  - 1 , guest on the ship = 4+5-1 = 8; (maxm guest - ans)
// 4th hour - entry - 1 , exit  - 3 , guest on the ship = 8+1-3 = 6;


public class MaxmGuestinParty {
 
    static void question(int[] entry, int[] leave) {

        int n1 = entry.length;
        int n2 = leave.length;

        if (n1 != n2)
            return;

        int ent = entry[0], lev = leave[0];
        int maxGuest = ent - lev;
        int currentGuest = ent - lev;
        

        for (int i = 1; i < n1; i++) {
            ent = entry[i];
            lev = leave[i];

            currentGuest = Math.abs((ent + currentGuest) - lev);

            maxGuest = Math.max(maxGuest, currentGuest);
        }

        System.out.println(maxGuest);
    }

    public static void main(String[] args) {
        int[] entry = { 3, 5, 2, 0 };
        int[] leave = { 0, 2, 4, 4 }; //6
        // int[] entry = {7,0,5,1,3};
        // int[] leave = {1,2,1,3,4}; //8 

        question(entry, leave);

    }
}
