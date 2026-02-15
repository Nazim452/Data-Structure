package PYQ.Zoho.Advance;
// ParkingLotSystem
import java.util.*;

// (Allocation Strategy + State Tracking + Revenue Calculation)

// This problem is very common because it tests:

// Allocation logic

// Priority handling

// OOP modeling

// Real-world simulation

// Clean design under time constraint

// 🏢 ROUND 3 – Advanced Programming
// Design a Parking Lot Management System
// 🧠 Problem Statement (Zoho Style)

// Design and implement an in-memory Parking Lot System that supports:

// Multiple slot types

// Vehicle parking

// Slot allocation

// Ticket generation

// Vehicle exit

// Fee calculation

// Display available slots

// Display total revenue

// 📦 Assumptions

// Parking lot has:

// Small slots (2-wheeler)

// Medium slots (Car)

// Large slots (Bus/Truck)

// Each vehicle has:

// Vehicle number

// Vehicle type

// Entry time

// Fee charged per hour:

// Small: ₹10/hr

// Medium: ₹20/hr

// Large: ₹50/hr

// Time is entered in integer hours

// If slot not available → reject
public class ParkingLotSystem {

    // -------- ENUM --------
    enum VehicleType {
        SMALL, MEDIUM, LARGE
    }

    // -------- VEHICLE --------
    static class Vehicle {
        String number;
        VehicleType type;

        Vehicle(String number, VehicleType type) {
            this.number = number;
            this.type = type;
        }
    }

    // -------- TICKET --------
    static class Ticket {
        String ticketId;
        Vehicle vehicle;
        int entryTime;
        int slotNumber;

        Ticket(String ticketId, Vehicle vehicle,
               int entryTime, int slotNumber) {
            this.ticketId = ticketId;
            this.vehicle = vehicle;
            this.entryTime = entryTime;
            this.slotNumber = slotNumber;
        }
    }

    // -------- PARKING LOT --------
    static class ParkingLot {

        Map<VehicleType, Queue<Integer>> availableSlots = new HashMap<>();
        Map<String, Ticket> activeTickets = new HashMap<>();
        Map<VehicleType, Integer> hourlyRate = new HashMap<>();

        int ticketCounter = 1;
        double totalRevenue = 0;

        ParkingLot(int small, int medium, int large) {

            availableSlots.put(VehicleType.SMALL, new LinkedList<>());
            availableSlots.put(VehicleType.MEDIUM, new LinkedList<>());
            availableSlots.put(VehicleType.LARGE, new LinkedList<>());

            for (int i = 1; i <= small; i++)
                availableSlots.get(VehicleType.SMALL).add(i);

            for (int i = 1; i <= medium; i++)
                availableSlots.get(VehicleType.MEDIUM).add(i);

            for (int i = 1; i <= large; i++)
                availableSlots.get(VehicleType.LARGE).add(i);

            hourlyRate.put(VehicleType.SMALL, 10);
            hourlyRate.put(VehicleType.MEDIUM, 20);
            hourlyRate.put(VehicleType.LARGE, 50);
        }

        // Park vehicle
        void parkVehicle(String number, VehicleType type, int entryTime) {

            Queue<Integer> slots = availableSlots.get(type);

            if (slots.isEmpty()) {
                System.out.println("No slots available for " + type);
                return;
            }

            int slot = slots.poll();
            Vehicle vehicle = new Vehicle(number, type);

            String ticketId = "T" + ticketCounter++;
            Ticket ticket = new Ticket(ticketId, vehicle, entryTime, slot);

            activeTickets.put(ticketId, ticket);

            System.out.println("Vehicle parked.");
            System.out.println("Ticket ID: " + ticketId);
            System.out.println("Slot Number: " + slot);
        }

        // Unpark vehicle
        void unparkVehicle(String ticketId, int exitTime) {

            Ticket ticket = activeTickets.get(ticketId);

            if (ticket == null) {
                System.out.println("Invalid Ticket ID");
                return;
            }

            int duration = exitTime - ticket.entryTime;
            if (duration <= 0) duration = 1;

            int rate = hourlyRate.get(ticket.vehicle.type);
            double fee = duration * rate;

            totalRevenue += fee;

            availableSlots.get(ticket.vehicle.type)
                    .add(ticket.slotNumber);

            activeTickets.remove(ticketId);

            System.out.println("Vehicle unparked.");
            System.out.println("Total Fee: ₹" + fee);
        }

        // Display available slots
        void displayAvailableSlots() {
            for (VehicleType type : availableSlots.keySet()) {
                System.out.println(type + " Slots Available: " +
                        availableSlots.get(type).size());
            }
        }

        // Display total revenue
        void displayRevenue() {
            System.out.println("Total Revenue: ₹" + totalRevenue);
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(2, 2, 1);

        lot.parkVehicle("TN01AB1234", VehicleType.SMALL, 9);
        lot.parkVehicle("TN02XY5678", VehicleType.MEDIUM, 10);

        lot.displayAvailableSlots();

        lot.unparkVehicle("T1", 12);

        lot.displayRevenue();
        lot.displayAvailableSlots();
    }
}

