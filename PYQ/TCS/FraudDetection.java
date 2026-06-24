package PYQ.TCS;
<<<<<<< HEAD
=======

>>>>>>> 7d1ba78 (ALL file done)
import java.util.*;

public class FraudDetection {

<<<<<<< HEAD
=======
    static class Transaction {
        String sender;
        String receiver;
        int amount;
        int time;

        Transaction(String s, String r, int a, int t) {
            sender = s;
            receiver = r;
            amount = a;
            time = t;
        }

        @Override
        public String toString() {
            return sender + " " + receiver + " " + amount + " " + time;
        }
    }

    public static void detectFraud(List<Transaction> transactions) {

        // Key -> "sender_receiver_amount"
        HashMap<String, Integer> map = new HashMap<>();

        List<Transaction> fraudList = new ArrayList<>();

        for (Transaction t : transactions) {

            String key = t.sender + "_" + t.receiver + "_" + t.amount;

            // 🔴 Rule 2: High amount fraud
            if (t.amount > 1000) {
                fraudList.add(t);
                continue;
            }

            // 🔴 Rule 1: Duplicate within 60 seconds
            if (map.containsKey(key)) {
                int prevTime = map.get(key);

                if (t.time - prevTime <= 60) {
                    fraudList.add(t); // add latest
                }
            }

            // update latest timestamp
            map.put(key, t.time);
        }

        // Output
        if (fraudList.isEmpty()) {
            System.out.println("No Fraud Detected");
        } else {
            for (Transaction t : fraudList) {
                System.out.println(t);
            }
        }
    }

>>>>>>> 7d1ba78 (ALL file done)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

<<<<<<< HEAD
        // HashMap: key -> sender#receiver#amount, value -> last timestamp
        HashMap<String, Integer> map = new HashMap<>();

        boolean found = false;

        for (int i = 0; i < n; i++) {

=======
        List<Transaction> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
>>>>>>> 7d1ba78 (ALL file done)
            String sender = sc.next();
            String receiver = sc.next();
            int amount = sc.nextInt();
            int time = sc.nextInt();

<<<<<<< HEAD
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
=======
            list.add(new Transaction(sender, receiver, amount, time));
        }

        detectFraud(list);
>>>>>>> 7d1ba78 (ALL file done)
    }
}