package TCSIPA;

import java.util.Scanner;

// ✅ Rewritten Problem Statement (Exam-Ready)
// 📌 Problem Title: Phone Management System

// You are required to design a system using Object-Oriented Programming (OOP) concepts.

// 🔹 Class Definition

// Create a class Phone with the following attributes:

// int phoneId
// String os
// String brand
// int price
// Requirements:
// Provide getters and setters
// Provide a parameterized constructor in the same order of attributes
// 🔹 Class: Solution

// Create a class Solution with the following two static methods:

// ✅ 1. findPriceForGivenBrand

// Method Signature:

// public static int findPriceForGivenBrand(Phone[] phones, String brand)

// Description:

// Returns the sum of prices of all Phone objects having the given brand.
// If no phone is found with the given brand, return 0.
// ✅ 2. getPhoneIdBasedOnOs

// Method Signature:

// public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os)

// Description:

// Return the Phone object where:
// os matches the input
// price >= 50000
// If no such phone exists, return null
// 🔹 Important Conditions
// No two phones will have the same OS
// All prices will be greater than 0
// String comparison should be case-sensitive
// 🔹 Input Format

// Read details of 4 Phone objects:

// phoneId
// os
// brand
// price

// Then read:

// brand (for search)
// os (for search)
// 🔹 Output Format
// For findPriceForGivenBrand:
// If sum > 0 → print sum

// Else → print:

// The given Brand is not available
// For getPhoneIdBasedOnOs:
// If found → print phoneId

// Else → print:

// No phones are available with specified os and price range
// ✅ Test Case (Cleaned)
// Input:
// 111
// iOS
// Apple
// 30000
// 222
// android
// Samsung
// 50000
// 333
// Symbian
// HTC
// 12000
// 444
// Paranoid
// HTC
// 89000
// Blackberry
// android
// Output:
// The given Brand is not available
// 222
// 💡 Logic Explanation (Important for Interview)
// First method:
// → Traverse array → match brand → sum prices

// Second method:
// → Traverse array → check:

// os match AND price >= 50000

// → return first match
public class PhoneMngmntSystm {
   
    
    
        static int findPriceForGivenBrand(Phone[] phone, String brand) {

            int price = 0;
            for (int i = 0; i < phone.length; i++) {
                if (phone[i].getBrand().equals(brand)) {
                    price += phone[i].getprice();
                }
            }
            return price;

        }

        static Phone getPhoneIdBasedOnOs(Phone[] phone, String os) {
            Phone p = null;

            for (int i = 0; i < phone.length; i++) {
                if (phone[i].getOs().equals(os) && phone[i].getprice() >= 50000) {
                    return phone[i];

                }
            }

            return p;

        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Phone[] arr = new Phone[4];

        for(int i = 0; i<arr.length; i++){
            int  a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            arr[i] = new Phone(a,b,c,d);
        }

        String brand =  sc.nextLine();
        String os = sc.nextLine();

        int sum = findPriceForGivenBrand(arr, brand);
        if(sum>0){
            System.out.println(sum);
        }
        else{
            System.out.println("Brand not exist");
        }

        Phone res = getPhoneIdBasedOnOs(arr, os);
        if(res!=null){
            System.out.println(res.getPhoneId());
        }
        else{
            System.out.println("No phone Avaialable with this OS");
        }

    }

}
 class Phone {
        int phoneId;
        String os;
        String brand;
        int price;

        // contructor
        Phone(int phoneId, String os, String brand, int price) {
            this.phoneId = phoneId;
            this.os = os;
            this.brand = brand;
            this.price = price;
        }
        // getter function

        public int getPhoneId() {
            return phoneId;
        }

        public String getOs() {
            return os;
        }

        public String getBrand() {
            return brand;
        }

        public int getprice() {
            return price;
        }

        // implemeting given method

    }


// Why sc.nextLine() is used after nextInt()
// 👉 Problem:
// int id = sc.nextInt();
// String os = sc.nextLine(); // ❌ ISSUE
// nextInt() does NOT consume the newline (\n)
// It only reads the number
// The Enter key you press remains in the buffer
// 👉 What happens internally:

// Input:

// 111⏎
// iOS⏎

// Buffer after nextInt():

// \n   ← still remaining

// So when you do:

// String os = sc.nextLine();

// 👉 It reads that leftover \n (empty line)
// 👉 So os = "" (empty string) ❌

// ✅ Solution
// int id = sc.nextInt();
// sc.nextLine(); // ✅ consumes leftover newline

// Now buffer is clean → nextLine() works properly 
