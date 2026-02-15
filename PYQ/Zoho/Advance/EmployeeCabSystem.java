package PYQ.Zoho.Advance;
// EmployeeCab System
import java.util.*;
// You must design a system that:

// Provides doorstep drop for employees after office hours.

// Office location is fixed: X

// Employee homes are: A, B, C, D, E ...

// Cabs are unlimited (no allocation conflict)

// Cab types:

// NORMAL

// AC

// LUXURY

// Cab type is allocated based on employee designation.

// Cab charges depend on:

// Cab type

// Distance

// System must generate reports:

// Total cost per month

// Total cost per employee

// Total cost for employee within a date range

// Trips done by employee

// 📦 Assumptions

// Distance map from Office X to homes:

// A = 10 km

// B = 15 km

// C = 20 km

// D = 25 km

// Charges per km:

// NORMAL = ₹10/km

// AC = ₹15/km

// LUXURY = ₹25/km

// Date is simple integer format (YYYYMMDD)

// 🏗️ OOP Design

// We will create:

// Employee

// CabType (enum)

// Trip

// CabService (controller)

// Reporting methods

// Data Structures Used:

// Map<Integer, Employee>

// List<Trip>

// Map<String, Integer> (distance mapping)
public class EmployeeCabSystem {

    // -------- ENUM --------
    enum CabType {
        NORMAL, AC, LUXURY
    }

    // -------- EMPLOYEE --------
    static class Employee {
        int id;
        String name;
        String designation;
        String homeLocation;
        CabType cabType;

        Employee(int id, String name, String designation, String homeLocation) {
            this.id = id;
            this.name = name;
            this.designation = designation;
            this.homeLocation = homeLocation;
            this.cabType = assignCabType(designation);
        }

        // Cab type based on designation
        private CabType assignCabType(String designation) {
            if (designation.equalsIgnoreCase("Manager"))
                return CabType.LUXURY;
            else if (designation.equalsIgnoreCase("Senior"))
                return CabType.AC;
            else
                return CabType.NORMAL;
        }
    }

    // -------- TRIP --------
    static class Trip {
        int tripId;
        int employeeId;
        CabType cabType;
        int distance;
        double cost;
        int date;  // YYYYMMDD

        Trip(int tripId, int employeeId,
             CabType cabType, int distance,
             double cost, int date) {

            this.tripId = tripId;
            this.employeeId = employeeId;
            this.cabType = cabType;
            this.distance = distance;
            this.cost = cost;
            this.date = date;
        }

        void print() {
            System.out.println("TripID: " + tripId +
                    " | Date: " + date +
                    " | Distance: " + distance +
                    " | Cost: ₹" + cost);
        }
    }

    // -------- CAB SERVICE --------
    static class CabService {

        Map<Integer, Employee> employees = new HashMap<>();
        List<Trip> trips = new ArrayList<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Map<CabType, Integer> ratePerKm = new HashMap<>();

        int tripCounter = 1;

        CabService() {

            // Distance from office X
            distanceMap.put("A", 10);
            distanceMap.put("B", 15);
            distanceMap.put("C", 20);
            distanceMap.put("D", 25);

            // Charges
            ratePerKm.put(CabType.NORMAL, 10);
            ratePerKm.put(CabType.AC, 15);
            ratePerKm.put(CabType.LUXURY, 25);
        }

        // Add Employee
        void addEmployee(int id, String name,
                         String designation, String home) {

            if (employees.containsKey(id)) {
                System.out.println("Employee already exists.");
                return;
            }

            if (!distanceMap.containsKey(home)) {
                System.out.println("Invalid location.");
                return;
            }

            Employee emp = new Employee(id, name,
                    designation, home);

            employees.put(id, emp);

            System.out.println("Employee added.");
        }

        // Create Trip
        void createTrip(int empId, int date) {

            Employee emp = employees.get(empId);

            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            int distance = distanceMap.get(emp.homeLocation);
            int rate = ratePerKm.get(emp.cabType);
            double cost = distance * rate;

            Trip trip = new Trip(tripCounter++,
                    empId, emp.cabType,
                    distance, cost, date);

            trips.add(trip);

            System.out.println("Trip created. Cost: ₹" + cost);
        }

        // Total cost per month
        void totalCostPerMonth(int yearMonth) {
            double total = 0;

            for (Trip trip : trips) {
                if (trip.date / 100 == yearMonth) {
                    total += trip.cost;
                }
            }

            System.out.println("Total cost for month: ₹" + total);
        }

        // Total cost per employee
        void totalCostPerEmployee(int empId) {

            double total = 0;

            for (Trip trip : trips) {
                if (trip.employeeId == empId) {
                    total += trip.cost;
                }
            }

            System.out.println("Total cost for employee: ₹" + total);
        }

        // Cost in date range
        void costInRange(int empId, int startDate, int endDate) {

            double total = 0;

            for (Trip trip : trips) {
                if (trip.employeeId == empId &&
                        trip.date >= startDate &&
                        trip.date <= endDate) {
                    total += trip.cost;
                }
            }

            System.out.println("Total cost in range: ₹" + total);
        }

        // Trips by employee
        void tripsByEmployee(int empId) {

            for (Trip trip : trips) {
                if (trip.employeeId == empId) {
                    trip.print();
                }
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        CabService service = new CabService();

        service.addEmployee(1, "Nazim", "Manager", "A");
        service.addEmployee(2, "John", "Senior", "B");

        service.createTrip(1, 20260210);
        service.createTrip(1, 20260212);
        service.createTrip(2, 20260215);

        service.totalCostPerEmployee(1);
        service.totalCostPerMonth(202602);
        service.costInRange(1, 20260201, 20260220);
        service.tripsByEmployee(1);
    }
}

