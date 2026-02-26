package PYQ.Zoho.Advance;
// LeaveManagementSystem
import java.util.*;

// Design and implement a console-based Leave Management System that supports:

// Adding employees

// Applying for leave

// Approving / Rejecting leave

// Tracking leave balance

// Viewing leave history

// All data stored in memory.

// 📦 Assumptions

// Each Employee has:

// Employee ID (unique)

// Name

// Leave balance (e.g., 20 days annually)

// Each Leave Request has:

// Leave ID

// Employee ID

// Start Day

// End Day

// Total Days

// Status (PENDING / APPROVED / REJECTED)

// Rules:

// Leave days must be ≤ available balance

// Leave balance reduces only when approved

// Cannot approve already processed leave

// Leave days calculated as (end - start + 1)

// 📋 Functional Requirements
// 1️⃣ Add Employee

// Reject duplicate ID.

// 2️⃣ Apply Leave

// Rules:

// Employee must exist

// Start day ≤ end day

// Leave days ≤ available balance

// Status = PENDING

// 3️⃣ Approve Leave

// Rules:

// Leave must exist

// Status must be PENDING

// Deduct leave balance

// Change status to APPROVED

// 4️⃣ Reject Leave

// Rules:

// Leave must be PENDING

// 5️⃣ View Leave Balance
// 6️⃣ View Leave History
public class LeaveManagementSystem {

    enum LeaveStatus {
        PENDING, APPROVED, REJECTED
    }

    // -------- EMPLOYEE --------
    static class Employee {
        int id;
        String name;
        int leaveBalance;
        List<LeaveRequest> leaveHistory = new ArrayList<>();

        Employee(int id, String name, int leaveBalance) {
            this.id = id;
            this.name = name;
            this.leaveBalance = leaveBalance;
        }
    }

    // -------- LEAVE REQUEST --------
    static class LeaveRequest {
        int leaveId;
        int employeeId;
        int startDay;
        int endDay;
        int totalDays;
        LeaveStatus status;

        LeaveRequest(int leaveId, int employeeId,
                     int startDay, int endDay) {

            this.leaveId = leaveId;
            this.employeeId = employeeId;
            this.startDay = startDay;
            this.endDay = endDay;
            this.totalDays = endDay - startDay + 1;
            this.status = LeaveStatus.PENDING;
        }

        void print() {
            System.out.println("LeaveID: " + leaveId +
                    " | Days: " + totalDays +
                    " | Status: " + status);
        }
    }

    // -------- LEAVE SYSTEM --------
    static class LeaveSystem {

        Map<Integer, Employee> employees = new HashMap<>();
        Map<Integer, LeaveRequest> leaveRequests = new HashMap<>();
        int leaveCounter = 1;

        // Add Employee
        void addEmployee(int id, String name, int balance) {

            if (employees.containsKey(id)) {
                System.out.println("Employee ID already exists.");
                return;
            }

            employees.put(id, new Employee(id, name, balance));
            System.out.println("Employee added successfully.");
        }

        // Apply Leave
        void applyLeave(int empId, int startDay, int endDay) {

            Employee emp = employees.get(empId);

            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            if (startDay > endDay) {
                System.out.println("Invalid date range.");
                return;
            }

            int days = endDay - startDay + 1;

            if (days > emp.leaveBalance) {
                System.out.println("Insufficient leave balance.");
                return;
            }

            LeaveRequest leave = new LeaveRequest(
                    leaveCounter++, empId, startDay, endDay);

            leaveRequests.put(leave.leaveId, leave);
            emp.leaveHistory.add(leave);

            System.out.println("Leave applied successfully. LeaveID: " + leave.leaveId);
        }

        // Approve Leave
        void approveLeave(int leaveId) {

            LeaveRequest leave = leaveRequests.get(leaveId);

            if (leave == null) {
                System.out.println("Leave request not found.");
                return;
            }

            if (leave.status != LeaveStatus.PENDING) {
                System.out.println("Leave already processed.");
                return;
            }

            Employee emp = employees.get(leave.employeeId);

            if (leave.totalDays > emp.leaveBalance) {
                System.out.println("Insufficient leave balance.");
                return;
            }

            emp.leaveBalance -= leave.totalDays;
            leave.status = LeaveStatus.APPROVED;

            System.out.println("Leave approved.");
        }

        // Reject Leave
        void rejectLeave(int leaveId) {

            LeaveRequest leave = leaveRequests.get(leaveId);

            if (leave == null) {
                System.out.println("Leave request not found.");
                return;
            }

            if (leave.status != LeaveStatus.PENDING) {
                System.out.println("Leave already processed.");
                return;
            }

            leave.status = LeaveStatus.REJECTED;

            System.out.println("Leave rejected.");
        }

        // View Leave Balance
        void viewBalance(int empId) {

            Employee emp = employees.get(empId);

            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.println("Leave Balance: " + emp.leaveBalance);
        }

        // View Leave History
        void viewLeaveHistory(int empId) {

            Employee emp = employees.get(empId);

            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            if (emp.leaveHistory.isEmpty()) {
                System.out.println("No leave history.");
                return;
            }

            for (LeaveRequest leave : emp.leaveHistory) {
                leave.print();
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        LeaveSystem system = new LeaveSystem();

        system.addEmployee(101, "Nazim", 20);

        system.applyLeave(101, 1, 5);
        system.applyLeave(101, 10, 12);

        system.viewLeaveHistory(101);

        system.approveLeave(1);

        system.viewBalance(101);

        system.rejectLeave(2);

        system.viewLeaveHistory(101);
    }
}










