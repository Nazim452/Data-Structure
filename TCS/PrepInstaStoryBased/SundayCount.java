package TCS.PrepInstaStoryBased;
// Example 1:

// Input 

// mon-> input String denoting the start of the month.

// 13  -> input integer denoting the number of days from the start of the month.

// Output :

// 2    -> number of days within 13 days.

// Explanation:

// The month start with mon(Monday). So the upcoming sunday will arrive in next 6 days. And then next Sunday in next 7 days and so on.
public class SundayCount {


    static void Question(String week , int days){
        String arr[]={"mon","tue,","wed","thu","fri","sat","sun"};
        int n = arr.length;
        int i = 0;
        for( i = 0; i<n; i++){
            if(arr[i].equals(week)) break;

        }

        // Since the first Sunday will always occur within the first 7 days, we assume
        //  at least one Sunday.
        int res = 1;


        // Sunday is always at index 6, so the remaining days to reach the first Sunday is 6 - i.

        int leftForSunday = 6-i;

        // By doing  days = days-leftForSunday;, we remove the first portion of days
        //  and focus only  on the remaining days after the first Sunday.
       

        days = days-leftForSunday;



        // After reaching the first Sunday, every next Sunday occurs every 7 days.
        
        res+=days/7;

        System.out.println(res);

    }
    public static void main(String[] args) {
        String week = "thu";
        int days  = 20;
        Question(week, days);
        
    }
    
}
