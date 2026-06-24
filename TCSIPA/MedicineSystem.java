package TCSIPA;


// ewritten Problem Statement (Exam-Ready)
// 📌 Problem Title: Medicine Management System

// You are required to implement a system using Object-Oriented Programming (OOP) concepts to manage medicine details.

// 🔹 Class Definition: Medicine

// Create a class Medicine with the following attributes:

// String medicineName
// String batch
// String disease
// int price
// Requirements:
// Provide getters and setters
// Provide a parameterized constructor in the same order of attributes
// 🔹 Class: Solution

// Create a class Solution and implement the following static method:

// ✅ getPriceByDisease
// Method Signature:
// public static Integer[] getPriceByDisease(Medicine[] medicines, String disease)
// 🔹 Description:
// This method takes:
// An array of Medicine objects
// A disease string
// It should:
// Find all medicines where disease matches (case-insensitive)
// Extract their prices
// Return the prices in a sorted array (ascending order)
// 🔹 If No Match Found:
// Return null
// 🔹 Input Format:
// Read details of 4 Medicine objects in the following order:
// medicineName
// batch
// disease
// price
// Then read:
// disease (for search)
// 🔹 Output Format:
// If result is not null:
// Print all prices in ascending order (each in new line)

// If result is null:

// No Medicine found
// ✅ Test Case (Cleaned)
// Input:
// dolo650
// FAC12W
// fever
// 100
// paracetamol
// PAC545B
// bodypain
// 150
// almox
// ALM747S
// fever
// 200
// aspirin
// ASP849Q
// flu
// 250
// fever
// Output:
// 100
// 200

import java.util.Arrays;
import java.util.Scanner;

public class MedicineSystem {
    static int[] getPriceBydisese(Medicine[] arr, String disease) {

        int[] ans = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDisease().equalsIgnoreCase(disease)) {

                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = arr[i].getPrice();

            }

        }
        Arrays.sort(ans);
        if (ans.length > 0) {
            return ans;
        }
        return null;

    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Medicine[] arr = new Medicine[4];

        for (int i = 0; i < arr.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            arr[i] = new Medicine(a, b, c, d);
        }

        String disease = sc.nextLine();

        int[] ans = getPriceBydisese(arr, disease);
        if (ans != null) {
            printArray(ans);
        } else {
            System.out.println("No Medicine Found");
        }

    }

}

class Medicine {
    
    String medicineName;
    String batch;
    String disease;
    int price;

    Medicine(String medicineName,
            String batch,
            String disease,
            int price) {
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;

    }

    public String getBatch() {
        return batch;
    }

    public String getDisease() {
        return disease;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

}









// OPtmized_______________________________________________

    // static Integer[] getPriceByDisease(Medicine[] arr, String disease) {

    //     ArrayList<Integer> list = new ArrayList<>();

    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i].getDisease().equalsIgnoreCase(disease)) {
    //             list.add(arr[i].getPrice());
    //         }
    //     }

    //     if (list.size() == 0) return null;

    //     Collections.sort(list);

    //     return list.toArray(new Integer[0]);
    // }



    
// Could u explain this line specially what is the meaning of :new Integer[0]

// That line looks confusing at first, but it’s actually very simple once you break it down.

// 🔍 The Line
// return list.toArray(new Integer[0]);
// ✅ What it Means

// You have:

// ArrayList<Integer> list

// But your method must return:

// Integer[]

// 👉 So you need to convert ArrayList → Array

// 🧠 Why new Integer[0]?

// toArray() has this version:

// <T> T[] toArray(T[] a)

// You must pass an array of the same type (Integer[] here).

// 💡 Key Idea
// new Integer[0]

// 👉 means:

// “Create an empty Integer array just to tell Java the type.”

// ⚙️ What Java Does Internally

// When you write:

// list.toArray(new Integer[0]);

// Java:

// Sees the type → Integer[]
// Ignores size (0)
// Creates a new array of correct size automatically
// Copies list elements into it
// 🔥 Example
// ArrayList<Integer> list = new ArrayList<>();
// list.add(10);
// list.add(20);
// Integer[] arr = list.toArray(new Integer[0]);

// 👉 Result:

// arr = [10, 20]
// ❓ Why not give size like new Integer[list.size()]?

// You can do this:

// list.toArray(new Integer[list.size()]);

// But:

// ✔ Modern best practice
// list.toArray(new Integer[0]);

// 👉 JVM optimizes it internally
// 👉 Cleaner and widely used in interviews

// 🧾 Interview-Ready Answer

// If interviewer asks:

// Why do we use new Integer[0] in toArray()?

// You can say:

// "It is used to specify the type of array required. The size doesn’t matter because Java automatically creates a new array of the correct size internally."

// 🚫 Common Mistake
// list.toArray(); // ❌ returns Object[]


// if we have to return int[] array then we have to like such that :return list.toArray(new int[0]);

// No — that will not work ❌

// list.toArray(new int[0]); // ❌ Compile-time error
// 🔴 Why this fails

// list is:

// ArrayList<Integer>

// But:

// int[]   // primitive
// Integer[] // object

// 👉 toArray() works only with objects, not primitives.

// 🧠 Core Rule (Very Important)
// Type	Allowed in Generics?
// int	❌ No
// Integer	✅ Yes

// 👉 Java Generics do not support primitives

// ✅ Correct Ways to Return int[]
// ✔ Option 1: Manual Conversion (Most Common)
// int[] result = new int[list.size()];

// for (int i = 0; i < list.size(); i++) {
//     result[i] = list.get(i); // auto-unboxing
// }

// return result;



