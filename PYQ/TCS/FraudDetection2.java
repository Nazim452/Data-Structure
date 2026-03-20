package PYQ.TCS;
import java.util.*;


public class FraudDetection2 {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Transaction> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String sender = sc.next();
            String receiver = sc.next();
            int amount = sc.nextInt();
            int time = sc.nextInt();

            list.add(new Transaction(sender, receiver, amount, time));
        }

        detectFraud(list);
    }
}