package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSeq {
    static class job{
        int deadline;
        int profit;
        int id;

        public job(int i, int d, int  p){
            id = i;
            deadline = d;
            profit = p;
        }
    }


    static void jobSequencingProb(int[][] jobsInfo){
        ArrayList<job> jobs = new ArrayList<>();

        for(int  i= 0; i<jobsInfo.length; i++){
            jobs.add(new job (i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        // Sort Profit in descending o rder
        Collections.sort(jobs,(obj1, obj2)-> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time =0;
        for(int i = 0; i<jobs.size(); i++){
            job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Max Job done:" + seq.size());
        for(int i = 0; i<seq.size(); i++){
            System.out.print(seq.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int[][] jobInfo = {{4,20},{1,10},{1,40},{1,30}};
        jobSequencingProb(jobInfo);
        
    }
}
