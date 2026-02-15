package PYQ.Zoho.Advance;
// MovieTicketBookingSystem
import java.util.*;




public class MovieTicketBookingSystem {

//     Design and implement a console-based Movie Ticket Booking System that supports:

// Creating a theatre with rows and seats

// Booking seats

// Cancelling bookings

// Checking seat availability

// Viewing total revenue

// Displaying seating arrangement

// All data stored in memory.

// 📦 Assumptions

// Theatre has:

// R rows

// C seats per row

// Each seat costs ₹150

// Booking is for specific seat (row, seat number)

// Cannot double-book seat

// Cancellation frees seat

// Revenue tracked

// Rows and seats are zero-indexed.📋 Functional Requirements
// 1️⃣ Create Theatre
// Rows = 5
// Seats per row = 5

// 2️⃣ Book Seat
// book(2,3)


// Rules:

// Seat must exist

// Seat must be free

// 3️⃣ Cancel Seat
// cancel(2,3)


// Rules:

// Seat must be booked

// 4️⃣ Display Seating
// display()


// Show:

// O = Available

// X = Booked

// 5️⃣ Show Revenue

    static class Theatre {

        int rows;
        int cols;
        boolean[][] seats;
        int seatPrice = 150;
        double totalRevenue = 0;

        Theatre(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            seats = new boolean[rows][cols];
        }

        // Validate seat position
        boolean isValid(int r, int c) {
            return r >= 0 && r < rows && c >= 0 && c < cols;
        }

        // Book seat
        void bookSeat(int r, int c) {

            if (!isValid(r, c)) {
                System.out.println("Invalid seat position.");
                return;
            }

            if (seats[r][c]) {
                System.out.println("Seat already booked.");
                return;
            }

            seats[r][c] = true;
            totalRevenue += seatPrice;

            System.out.println("Seat booked successfully.");
        }

        // Cancel seat
        void cancelSeat(int r, int c) {

            if (!isValid(r, c)) {
                System.out.println("Invalid seat position.");
                return;
            }

            if (!seats[r][c]) {
                System.out.println("Seat is not booked.");
                return;
            }

            seats[r][c] = false;
            totalRevenue -= seatPrice;

            System.out.println("Booking cancelled.");
        }

        // Display seating arrangement
        void display() {

            System.out.println("Seating Arrangement:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (seats[i][j]) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }
        }

        // Show total revenue
        void showRevenue() {
            System.out.println("Total Revenue: ₹" + totalRevenue);
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Theatre theatre = new Theatre(5, 5);

        theatre.display();

        theatre.bookSeat(2, 3);
        theatre.bookSeat(1, 1);
        theatre.bookSeat(2, 3); // duplicate booking test

        theatre.display();

        theatre.cancelSeat(2, 3);

        theatre.display();

        theatre.showRevenue();
    }
}
