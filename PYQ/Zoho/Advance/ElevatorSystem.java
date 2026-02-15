package PYQ.Zoho.Advance;
// Elevator Management System
import java.util.*;
// Design a Lift / Elevator Management System


// Design a system that manages multiple lifts in a building.

// The system must:

// Handle multiple lifts

// Allocate the best lift for a request

// Move lift to requested floor

// Track lift direction

// Track lift status (IDLE / MOVING / STOPPED)

// Maintain trip history

// Display lift status

// 📦 Assumptions

// Building has N floors (0 to N-1)

// There are M lifts

// Each lift:

// Has current floor

// Has direction (UP / DOWN / IDLE)

// Has request queue

// Lift can serve one request at a time (simplified version)

// Request contains:

// Source floor

// Destination floor

// 📋 Functional Requirements
// 1️⃣ Add Lift

// Initialize M lifts at floor 0.

// 2️⃣ Request Lift

// Input:

// Source Floor
// Destination Floor


// System should:

// Allocate nearest suitable lift

// Move lift to source

// Then to destination

// 3️⃣ Display Lift Status

// Show:

// Lift 1 | Floor: 5 | Direction: UP
// Lift 2 | Floor: 2 | Direction: IDLE

// 4️⃣ Show Trip History
public class ElevatorSystem {

    enum Direction {
        UP, DOWN, IDLE
    }

    // -------- REQUEST --------
    static class Request {
        int source;
        int destination;

        Request(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    // -------- LIFT --------
    static class Lift {

        int id;
        int currentFloor;
        Direction direction;
        List<String> tripHistory = new ArrayList<>();

        Lift(int id) {
            this.id = id;
            this.currentFloor = 0;
            this.direction = Direction.IDLE;
        }

        // Move lift
        void move(int source, int destination) {

            if (currentFloor < source) {
                direction = Direction.UP;
            } else if (currentFloor > source) {
                direction = Direction.DOWN;
            }

            currentFloor = source;

            if (source < destination) {
                direction = Direction.UP;
            } else if (source > destination) {
                direction = Direction.DOWN;
            }

            currentFloor = destination;
            direction = Direction.IDLE;

            tripHistory.add("From " + source +
                    " to " + destination);
        }

        void printStatus() {
            System.out.println("Lift " + id +
                    " | Floor: " + currentFloor +
                    " | Direction: " + direction);
        }

        void printHistory() {
            System.out.println("Lift " + id + " Trips:");
            for (String trip : tripHistory) {
                System.out.println(trip);
            }
        }
    }

    // -------- CONTROLLER --------
    static class LiftController {

        List<Lift> lifts = new ArrayList<>();

        LiftController(int numberOfLifts) {
            for (int i = 1; i <= numberOfLifts; i++) {
                lifts.add(new Lift(i));
            }
        }

        // Allocate nearest lift
        Lift allocateLift(int source) {

            Lift selected = null;
            int minDistance = Integer.MAX_VALUE;

            for (Lift lift : lifts) {

                int distance = Math.abs(lift.currentFloor - source);

                if (selected == null ||
                        distance < minDistance ||
                        (distance == minDistance &&
                                lift.id < selected.id)) {

                    selected = lift;
                    minDistance = distance;
                }
            }

            return selected;
        }

        // Request lift
        void requestLift(int source, int destination) {

            if (source == destination) {
                System.out.println("Source and destination same.");
                return;
            }

            Lift lift = allocateLift(source);

            System.out.println("Lift " + lift.id +
                    " allocated.");

            lift.move(source, destination);
        }

        // Display status
        void displayStatus() {
            for (Lift lift : lifts) {
                lift.printStatus();
            }
        }

        // Display history
        void displayHistory() {
            for (Lift lift : lifts) {
                lift.printHistory();
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        LiftController controller = new LiftController(3);

        controller.requestLift(2, 7);
        controller.requestLift(3, 1);
        controller.requestLift(8, 4);

        controller.displayStatus();
        controller.displayHistory();
    }
}

