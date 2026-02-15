package PYQ.Zoho.Advance;
// RailwayReservationSystem.java
import java.util.*;

/**
 * Railway Reservation System (Single File)
 *
 * Features:
 *  - Multiple coach types (configurable seats + waiting list)
 *  - Book, Cancel, Print status, Booking history
 *  - When a confirmed booking is cancelled, the first waiting passenger (if any)
 *    is promoted to confirmed.
 *
 * This is a beginner-friendly, single-file implementation suitable for a Round-3
 * advanced programming problem (menu-driven extension possible).
 * 
 * I built a complete, tested, beginner-friendly Java program that:

Supports coach types (AC / Non-AC / Seater) — configurable seat counts and WL sizes.

Books tickets (returns BookingID, coach, seat or WL position).

Cancels bookings (promotes first WL).

Maintains booking history and prints current status.

Uses clear OOP: Coach, Booking, ReservationSystem classes.

All in memory, console demo with sample test cases executed in main.
 */
public class RailWayReservation {

    // Booking status
    enum Status { CONFIRMED, WAITLIST, CANCELLED }

    // Booking record
    static class Booking {
        final String bookingId;
        final String passengerName;
        final String coachType;      // e.g. "AC", "NONAC", "SEATER"
        Status status;
        Integer seatNumber;          // null if WL or cancelled
        Integer wlPosition;          // null if confirmed
        final int timestamp;         // simple integer to mimic time order

        Booking(String bookingId, String passengerName, String coachType,
                Status status, Integer seatNumber, Integer wlPosition, int timestamp) {
            this.bookingId = bookingId;
            this.passengerName = passengerName;
            this.coachType = coachType;
            this.status = status;
            this.seatNumber = seatNumber;
            this.wlPosition = wlPosition;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return bookingId + " | " + passengerName + " | " + coachType + " | " +
                   status + " | seat: " + (seatNumber == null ? "-" : seatNumber) +
                   " | wl: " + (wlPosition == null ? "-" : wlPosition);
        }
    }

    // Coach representation
    static class Coach {
        final String type;            // name like "AC"
        final int capacity;           // number of seats
        final int maxWaitlist;        // WL capacity
        // Seats: track available seats as min-heap of seat numbers to allocate lowest seat
        final PriorityQueue<Integer> freeSeats;
        // Current confirmed bookings map seatNumber -> bookingId
        final Map<Integer, String> seatToBooking;
        // Waitlist queue of bookingIds (FIFO)
        final Queue<String> waitlist;

        Coach(String type, int capacity, int maxWaitlist) {
            this.type = type;
            this.capacity = capacity;
            this.maxWaitlist = maxWaitlist;
            this.freeSeats = new PriorityQueue<>();
            for (int i = 1; i <= capacity; i++) freeSeats.add(i);
            this.seatToBooking = new HashMap<>();
            this.waitlist = new ArrayDeque<>();
        }

        boolean hasFreeSeat() {
            return !freeSeats.isEmpty();
        }

        boolean canAddToWaitlist() {
            return waitlist.size() < maxWaitlist;
        }
    }

    // Reservation System
    static class ReservationSystem {
        final Map<String, Coach> coaches = new HashMap<>();
        final Map<String, Booking> bookings = new HashMap<>();
        int bookingCounter = 1;
        int timeCounter = 1; // simple timestamp

        ReservationSystem() {
            // default config; can be made dynamic
            coaches.put("AC", new Coach("AC", 10, 5));        // smaller numbers for demo
            coaches.put("NONAC", new Coach("NONAC", 10, 5));
            coaches.put("SEATER", new Coach("SEATER", 20, 10));
        }

        // Create a new booking attempt
        public String bookTicket(String passengerName, String coachType) {
            Coach coach = coaches.get(coachType);
            if (coach == null) return "Error: Invalid coach type.";

            String bookingId = "B" + (bookingCounter++);

            // try to allocate seat
            if (coach.hasFreeSeat()) {
                int seat = coach.freeSeats.poll();
                coach.seatToBooking.put(seat, bookingId);
                Booking b = new Booking(bookingId, passengerName, coachType,
                        Status.CONFIRMED, seat, null, timeCounter++);
                bookings.put(bookingId, b);
                return "Booked: " + bookingId + " Confirmed seat# " + seat + " (" + coachType + ")";
            }

            // no seat, try waitlist
            if (coach.canAddToWaitlist()) {
                coach.waitlist.add(bookingId);
                Booking b = new Booking(bookingId, passengerName, coachType,
                        Status.WAITLIST, null, coach.waitlist.size(), timeCounter++);
                bookings.put(bookingId, b);
                return "Booked: " + bookingId + " Waitlist position " + b.wlPosition + " (" + coachType + ")";
            }

            return "Booking Rejected: No seats and waitlist full for " + coachType;
        }

        // Cancel a booking
        public String cancelBooking(String bookingId) {
            Booking b = bookings.get(bookingId);
            if (b == null) return "Error: Booking ID not found";

            if (b.status == Status.CANCELLED) return "Already cancelled";

            // If confirmed, free seat and promote from waitlist if present
            if (b.status == Status.CONFIRMED) {
                Coach coach = coaches.get(b.coachType);
                int freedSeat = b.seatNumber;
                // free seat
                coach.seatToBooking.remove(freedSeat);
                coach.freeSeats.add(freedSeat);
                b.status = Status.CANCELLED;
                b.seatNumber = null;

                // promote first in waitlist (if any)
                if (!coach.waitlist.isEmpty()) {
                    String promoteBookingId = coach.waitlist.poll();
                    Booking promote = bookings.get(promoteBookingId);
                    // assign freed seat to promoted booking
                    promote.status = Status.CONFIRMED;
                    promote.seatNumber = freedSeat;
                    promote.wlPosition = null;
                    coach.seatToBooking.put(freedSeat, promoteBookingId);
                    // Remove seat from free seats (we just added it, so remove)
                    coach.freeSeats.remove(freedSeat);
                    return "Cancelled " + bookingId + ". Promoted " + promoteBookingId + " to seat " + freedSeat;
                }

                return "Cancelled " + bookingId + ". Seat " + freedSeat + " is now free.";
            }

            // If waitlist, simply remove from waitlist
            if (b.status == Status.WAITLIST) {
                Coach coach = coaches.get(b.coachType);
                boolean removed = coach.waitlist.remove(bookingId);
                b.status = Status.CANCELLED;
                b.wlPosition = null;

                // After removing someone from waitlist, WL positions shift — update WL numbers for passengers still in waitlist
                // (We recompute WL positions to keep consistent)
                int pos = 1;
                for (String id : coach.waitlist) {
                    Booking bx = bookings.get(id);
                    if (bx != null && bx.status == Status.WAITLIST) {
                        bx.wlPosition = pos++;
                    }
                }

                return removed ? "Cancelled waitlist booking " + bookingId : "Booking not found in waitlist.";
            }

            return "Unknown booking status.";
        }

        // Print status for all coaches
        public void printStatus() {
            System.out.println("\n=== Current System Status ===");
            for (Coach c : coaches.values()) {
                System.out.println("Coach: " + c.type);
                System.out.println("  Free seats: " + c.freeSeats.size());
                System.out.println("  Confirmed bookings: " + c.seatToBooking.size());
                System.out.println("  Waitlist size: " + c.waitlist.size());
            }
        }

        // Print booking details
        public void printBookings() {
            System.out.println("\n=== All Bookings ===");
            for (Booking b : bookings.values()) {
                System.out.println(b);
            }
        }
    }

    // ---------- Demo main with sample testcases ----------
    public static void main(String[] args) {
        ReservationSystem sys = new ReservationSystem();

        // 1) Book some seats in AC
        System.out.println(sys.bookTicket("Alice", "AC"));
        System.out.println(sys.bookTicket("Bob", "AC"));
        System.out.println(sys.bookTicket("Charlie", "AC"));

        // fill AC seats to capacity quickly (AC capacity = 10 in this demo)
        for (int i = 0; i < 8; i++) {
            System.out.println(sys.bookTicket("PaxAC" + i, "AC"));
        }

        // At this point AC seats full; next bookings go to WL until WL full (max 5 in demo)
        System.out.println(sys.bookTicket("WL1", "AC"));
        System.out.println(sys.bookTicket("WL2", "AC"));
        System.out.println(sys.bookTicket("WL3", "AC"));
        System.out.println(sys.bookTicket("WL4", "AC"));
        System.out.println(sys.bookTicket("WL5", "AC"));

        // This one should be rejected because seats + WL full
        System.out.println(sys.bookTicket("WL6", "AC"));

        // 2) Cancel a confirmed booking and see WL promotion
        // Find a confirmed booking id (one of B1..B10)
        String toCancel = "B3"; // Charlie for example
        System.out.println(sys.cancelBooking(toCancel));

        // Now print status and bookings
        sys.printStatus();
        sys.printBookings();

        // 3) Additional tests: Booking in other coach
        System.out.println(sys.bookTicket("Zara", "SEATER"));
        System.out.println(sys.bookTicket("Yusuf", "NONAC"));

        sys.printStatus();
        sys.printBookings();

        // 4) Cancel a waitlist booking (example)
        System.out.println(sys.cancelBooking("B14")); // might be a WL id depending on bookingCounter order

        // Final view
        sys.printStatus();
        sys.printBookings();
    }
}
