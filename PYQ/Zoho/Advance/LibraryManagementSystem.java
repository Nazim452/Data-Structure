package PYQ.Zoho.Advance;
// Library management System
import java.util.*;
// Design an In-Memory Library Management System
// 🧠 Problem Statement (Zoho Style)

// Design and implement a console-based Library Management System that supports:

// Adding books

// Registering members

// Issuing books

// Returning books

// Fine calculation for late return

// Viewing book availability

// Viewing member borrowing history

// All data must be stored in memory only.

// 📦 Assumptions

// Each book has:

// Book ID (unique)

// Title

// Author

// Total copies

// Available copies

// Each member has:

// Member ID (unique)

// Name

// Fine:

// ₹5 per day after 7 days📦 Assumptions

// Each book has:

// Book ID (unique)

// Title

// Author

// Total copies

// Available copies

// Each member has:

// Member ID (unique)

// Name

// Fine:

// ₹5 per day after 7 days

// Issue date and return date are integers (days)

// 📋 Functional Requirements
// 1️⃣ Add Book

// Reject duplicate Book ID.

// 2️⃣ Register Member

// Reject duplicate Member ID.

// 3️⃣ Issue Book

// Rules:

// Book must exist

// Member must exist

// Available copies > 0

// A member cannot issue the same book twice without returning

// 4️⃣ Return Book

// Rules:

// Book must be issued to that member

// Calculate fine if returnDay - issueDay > 7

// Increase available copies

// 5️⃣ View Book Details
// 6️⃣ View Member History

// Issue date and return date are integers (days)
public class LibraryManagementSystem {

    // -------- BOOK --------
    static class Book {
        int bookId;
        String title;
        String author;
        int totalCopies;
        int availableCopies;

        Book(int bookId, String title, String author, int copies) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.totalCopies = copies;
            this.availableCopies = copies;
        }

        void printDetails() {
            System.out.println(bookId + " | " + title + " | " +
                    author + " | Available: " + availableCopies);
        }
    }

    // -------- MEMBER --------
    static class Member {
        int memberId;
        String name;
        Map<Integer, Integer> borrowedBooks = new HashMap<>();
        // bookId -> issueDay

        Member(int memberId, String name) {
            this.memberId = memberId;
            this.name = name;
        }
    }

    // -------- LIBRARY SYSTEM --------
    static class Library {

        Map<Integer, Book> books = new HashMap<>();
        Map<Integer, Member> members = new HashMap<>();
        int finePerDay = 5;
        int allowedDays = 7;

        // Add Book
        void addBook(int id, String title, String author, int copies) {

            if (books.containsKey(id)) {
                System.out.println("Book ID already exists.");
                return;
            }

            books.put(id, new Book(id, title, author, copies));
            System.out.println("Book added successfully.");
        }

        // Register Member
        void registerMember(int id, String name) {

            if (members.containsKey(id)) {
                System.out.println("Member ID already exists.");
                return;
            }

            members.put(id, new Member(id, name));
            System.out.println("Member registered successfully.");
        }

        // Issue Book
        void issueBook(int memberId, int bookId, int issueDay) {

            Member member = members.get(memberId);
            Book book = books.get(bookId);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }

            if (book == null) {
                System.out.println("Book not found.");
                return;
            }

            if (book.availableCopies <= 0) {
                System.out.println("No copies available.");
                return;
            }

            if (member.borrowedBooks.containsKey(bookId)) {
                System.out.println("Book already issued to this member.");
                return;
            }

            book.availableCopies--;
            member.borrowedBooks.put(bookId, issueDay);

            System.out.println("Book issued successfully.");
        }

        // Return Book
        void returnBook(int memberId, int bookId, int returnDay) {

            Member member = members.get(memberId);
            Book book = books.get(bookId);

            if (member == null || book == null) {
                System.out.println("Invalid member or book.");
                return;
            }

            if (!member.borrowedBooks.containsKey(bookId)) {
                System.out.println("This book was not issued to this member.");
                return;
            }

            int issueDay = member.borrowedBooks.get(bookId);
            int daysKept = returnDay - issueDay;

            int fine = 0;
            if (daysKept > allowedDays) {
                fine = (daysKept - allowedDays) * finePerDay;
            }

            book.availableCopies++;
            member.borrowedBooks.remove(bookId);

            System.out.println("Book returned successfully.");
            if (fine > 0) {
                System.out.println("Fine: ₹" + fine);
            } else {
                System.out.println("No fine.");
            }
        }

        // View Book Details
        void viewBook(int bookId) {

            Book book = books.get(bookId);

            if (book == null) {
                System.out.println("Book not found.");
                return;
            }

            book.printDetails();
        }

        // View Member History
        void viewMember(int memberId) {

            Member member = members.get(memberId);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }

            System.out.println("Member: " + member.name);
            if (member.borrowedBooks.isEmpty()) {
                System.out.println("No borrowed books.");
            } else {
                for (int bookId : member.borrowedBooks.keySet()) {
                    System.out.println("Borrowed Book ID: " + bookId);
                }
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(101, "Java Basics", "James", 3);
        library.addBook(102, "Data Structures", "Mark", 2);

        library.registerMember(1, "Nazim");

        library.issueBook(1, 101, 1);
        library.returnBook(1, 101, 12);

        library.viewBook(101);
        library.viewMember(1);
    }
}

