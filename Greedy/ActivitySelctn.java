package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelctn {

    static void actvity(int[] st, int[] end) {
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxActivity = 1;

        ans.add(0); // 1st element alwways selected
        int lastEnd = end[0];

        for (int i = 0; i < end.length; i++) {
            if (st[i] >= lastEnd) {
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }

        }
        System.out.println("Maximum Activity: - " + maxActivity);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    // If end time is not sorted______________________________________________

    static void actvityEndTimeNotSor(int[] st, int[] end) {

        int[][] activites = new int[st.length][3];

        for(int  i = 0; i<st.length; i++){
            activites[i][0]=i;
            activites[i][1]=st[i];
            activites[i][2]=end[i];
        }

        //sorting of second column
        Arrays.sort(activites, Comparator.comparingDouble(o->o[2]));

        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activites[0][0]);
        int lastend = activites[0][2];
        for(int i = 1; i<end.length; i++){
            if(activites[i][1]>=lastend){
                maxActivity++;
                ans.add(activites[i][0]);
                lastend = activites[i][2];
            }
        }

        System.out.println("Maximum Activity: - " + maxActivity);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }





    }

    public static void main(String[] args) {
        // int[] st = { 1, 3, 0, 5, 8, 5 };
        // int[] end = { 2, 4, 6, 7, 9, 9 };
        // actvity(st, end);   //0 1 3 4


        //For Not Sorted of end row

        int[]st = {0,1,3,5,5,8};
        int[]end ={6,2,4,7,9,9};
        actvityEndTimeNotSor(st, end);
    }
}
