package PYQ.TCS;
import java.util.*;

public class FraudDetection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // HashMap: key -> sender#receiver#amount, value -> last timestamp
        HashMap<String, Integer> map = new HashMap<>();

        boolean found = false;

        for (int i = 0; i < n; i++) {

            String sender = sc.next();
            String receiver = sc.next();
            int amount = sc.nextInt();
            int time = sc.nextInt();

            String key = sender + "#" + receiver + "#" + amount;

            boolean isFraud = false;

            // ✅ Rule 2: High Amount
            if (amount > 1000) {
                isFraud = true;
            }

            // ✅ Rule 1: Duplicate within 60 seconds
            if (map.containsKey(key)) {
                int prevTime = map.get(key);

                if (time - prevTime <= 60) {
                    isFraud = true;
                }
            }

            // ✅ Print fraudulent transaction
            if (isFraud) {
                System.out.println(sender + " " + receiver + " " + amount + " " + time);
                found = true;
            }

            // ✅ Always update latest timestamp
            map.put(key, time);
        }

        // ✅ If no fraud found
        if (!found) {
            System.out.println("No Fraud Detected");
        }

        sc.close();
    }
}