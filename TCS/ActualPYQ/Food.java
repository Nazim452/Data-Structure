package TCS.ActualPYQ;

import java.util.*;;

// Input -- 
//  Total income:Int
//  For each expense , take the following inputs repeatidly untile user enter -"done"
//    - category - "Food" , "Travel" , "Health" , "Education" , "Miscellaneous"
//    - expense:Int

// Output 
//  Print total income
//  Total expesnes
// Total savings - total income - total expenses
// Print the breakdown of expesnse for each category

public class Food {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalIncome = sc.nextInt();

        // Map<String, Integer> map = new TreeMap<>();
        // Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new LinkedHashMap<>(); // maintain order
        // Map<String, Integer> map1 = new TreeMap<>(); // ascending order

        int totalExpenses = 0;

        while (true) {
            String category = sc.next();
            if (category.equals("done")) {
                break;
            }

            int expense = sc.nextInt();

            map.put(category, map.getOrDefault(category, 0) + expense);
            totalExpenses += expense;

        }

        System.out.println(totalIncome);
        System.out.println(totalExpenses);
        System.out.println(totalIncome - totalExpenses);

        for (var data : map.entrySet()) {
            System.out.println(data.getKey() + " : " + data.getValue());

        }

        // 1200
        // food
        // 100
        // education
        // 300
        // travel
        // 400
        // done

    }

}
