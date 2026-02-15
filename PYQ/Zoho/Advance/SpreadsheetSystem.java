package PYQ.Zoho.Advance;
// SpreadsheetSystem 
 
import java.util.*;
// 📊 Spreadsheet / Excel Simulation System

// (Matrix + Cell Update + Formula Logic + Row/Column Operations)

// This problem is powerful because it tests:

// 2D data structure understanding

// OOP modeling

// Index validation

// Formula computation

// Clean design

// Edge case handling

// 🏢 ROUND 3 – Advanced Programming
// Design an In-Memory Spreadsheet System
// 🧠 Problem Statement (Zoho Style)

// Design and implement a simplified Spreadsheet system similar to Excel that supports:

// Creating a spreadsheet with R rows and C columns

// Updating cell values

// Getting cell values

// Calculating SUM of row or column

// Inserting row

// Deleting row

// Displaying spreadsheet

// All data stored in memory.

// 📦 Assumptions

// Rows and columns are zero-indexed

// Only integer values allowed

// SUM calculation is dynamic

// Invalid index → reject

// 📋 Functional Requirements
// 1️⃣ Create Spreadsheet

// Input:

// Rows = 3
// Columns = 3


// Initial state:

// 0 0 0
// 0 0 0
// 0 0 0

// 2️⃣ Update Cell
// set(1,2,50)

// 3️⃣ Get Cell Value
// get(1,2)

// 4️⃣ Sum Row
// sumRow(1)

// 5️⃣ Sum Column
// sumCol(2)

// 6️⃣ Insert Row

// Add new row at index.

// 7️⃣ Delete Row

// Remove row at index.
public class SpreadsheetSystem {

    static class Spreadsheet {

        List<List<Integer>> sheet;
        int rows;
        int cols;

        Spreadsheet(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            sheet = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < cols; j++) {
                    row.add(0);
                }
                sheet.add(row);
            }
        }

        // Validate indices
        boolean isValid(int r, int c) {
            return r >= 0 && r < rows && c >= 0 && c < cols;
        }

        // Set cell value
        void set(int r, int c, int value) {
            if (!isValid(r, c)) {
                System.out.println("Invalid cell position.");
                return;
            }
            sheet.get(r).set(c, value);
            System.out.println("Cell updated.");
        }

        // Get cell value
        void get(int r, int c) {
            if (!isValid(r, c)) {
                System.out.println("Invalid cell position.");
                return;
            }
            System.out.println("Value: " + sheet.get(r).get(c));
        }

        // Sum row
        void sumRow(int r) {
            if (r < 0 || r >= rows) {
                System.out.println("Invalid row index.");
                return;
            }

            int sum = 0;
            for (int value : sheet.get(r)) {
                sum += value;
            }

            System.out.println("Row Sum: " + sum);
        }

        // Sum column
        void sumCol(int c) {
            if (c < 0 || c >= cols) {
                System.out.println("Invalid column index.");
                return;
            }

            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += sheet.get(i).get(c);
            }

            System.out.println("Column Sum: " + sum);
        }

        // Insert row
        void insertRow(int index) {

            if (index < 0 || index > rows) {
                System.out.println("Invalid index.");
                return;
            }

            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < cols; i++) {
                newRow.add(0);
            }

            sheet.add(index, newRow);
            rows++;

            System.out.println("Row inserted.");
        }

        // Delete row
        void deleteRow(int index) {

            if (index < 0 || index >= rows) {
                System.out.println("Invalid index.");
                return;
            }

            sheet.remove(index);
            rows--;

            System.out.println("Row deleted.");
        }

        // Display sheet
        void display() {
            System.out.println("Spreadsheet:");
            for (List<Integer> row : sheet) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Spreadsheet sheet = new Spreadsheet(3, 3);

        sheet.display();

        sheet.set(1, 2, 50);
        sheet.get(1, 2);

        sheet.sumRow(1);
        sheet.sumCol(2);

        sheet.insertRow(1);
        sheet.display();

        sheet.deleteRow(2);
        sheet.display();
    }
}
