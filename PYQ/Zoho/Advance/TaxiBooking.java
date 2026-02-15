package PYQ.Zoho.Advance;
import java.util.*;

public class TaxiBooking {

    // -------------------- BOOKING CLASS --------------------
    static class Booking {
        int bookingId;
        int customerId;
        char from;
        char to;
        int pickupTime;
        int dropTime;
        int amount;

        Booking(int bookingId, int customerId, char from, char to,
                int pickupTime, int dropTime, int amount) {

            this.bookingId = bookingId;
            this.customerId = customerId;
            this.from = from;
            this.to = to;
            this.pickupTime = pickupTime;
            this.dropTime = dropTime;
            this.amount = amount;
        }
    }

    // -------------------- TAXI CLASS --------------------
    static class Taxi {

        int taxiId;
        char currentLocation;
        int freeTime;
        int totalEarnings;
        List<Booking> bookings;

        Taxi(int id) {
            this.taxiId = id;
            this.currentLocation = 'A';   // Initially all taxis at A
            this.freeTime = 0;
            this.totalEarnings = 0;
            this.bookings = new ArrayList<>();
        }
    }

    // -------------------- TAXI MANAGER --------------------
    static class TaxiManager {

        List<Taxi> taxis = new ArrayList<>();
        int bookingCounter = 1;

        TaxiManager(int numberOfTaxis) {
            for (int i = 1; i <= numberOfTaxis; i++) {
                taxis.add(new Taxi(i));
            }
        }

        // Allocate nearest free taxi with lower earnings priority
        Taxi allocateTaxi(char pickup, int pickupTime) {

            Taxi selectedTaxi = null;
            int minDistance = Integer.MAX_VALUE;

            for (Taxi taxi : taxis) {

                if (taxi.freeTime <= pickupTime) {

                    int distance = Math.abs(taxi.currentLocation - pickup);

                    if (selectedTaxi == null ||
                            distance < minDistance ||
                            (distance == minDistance &&
                             taxi.totalEarnings < selectedTaxi.totalEarnings)) {

                        selectedTaxi = taxi;
                        minDistance = distance;
                    }
                }
            }

            return selectedTaxi;
        }

        // Booking method
        void bookTaxi(int customerId, char from, char to, int pickupTime) {

            Taxi taxi = allocateTaxi(from, pickupTime);

            if (taxi == null) {
                System.out.println("Booking Rejected. No taxi available.");
                return;
            }

            int distance = Math.abs(to - from) * 15;  // 15 km per point
            int travelTime = Math.abs(to - from);     // 1 hour per point

            int amount;
            if (distance <= 5) {
                amount = 100;
            } else {
                amount = 100 + (distance - 5) * 10;
            }

            int dropTime = pickupTime + travelTime;

            Booking booking = new Booking(
                    bookingCounter++,
                    customerId,
                    from,
                    to,
                    pickupTime,
                    dropTime,
                    amount
            );

            taxi.bookings.add(booking);
            taxi.totalEarnings += amount;
            taxi.currentLocation = to;
            taxi.freeTime = dropTime;

            System.out.println("Taxi-" + taxi.taxiId + " is allotted.");
        }

        // Display taxi details
        void printTaxiDetails() {

            for (Taxi taxi : taxis) {

                if (!taxi.bookings.isEmpty()) {

                    System.out.println("\nTaxi-" + taxi.taxiId +
                            " Total Earnings: Rs. " + taxi.totalEarnings);

                    System.out.println("BookingID  CustomerID  From  To  PickupTime  DropTime  Amount");

                    for (Booking b : taxi.bookings) {
                        System.out.println(
                                b.bookingId + "          " +
                                b.customerId + "           " +
                                b.from + "     " +
                                b.to + "     " +
                                b.pickupTime + "          " +
                                b.dropTime + "         " +
                                b.amount
                        );
                    }
                }
            }
        }
    }

    // -------------------- MAIN METHOD --------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of taxis: ");
        int n = sc.nextInt();

        TaxiManager manager = new TaxiManager(n);

        while (true) {

            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Pickup Point (A-F): ");
                    char from = sc.next().toUpperCase().charAt(0);

                    System.out.print("Drop Point (A-F): ");
                    char to = sc.next().toUpperCase().charAt(0);

                    System.out.print("Pickup Time (hour): ");
                    int pickupTime = sc.nextInt();

                    manager.bookTaxi(customerId, from, to, pickupTime);
                    break;

                case 2:
                    manager.printTaxiDetails();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
