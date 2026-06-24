package TCSIPA;

// Problem Title: Travel Agencies Management System

// You are required to implement a system using Object-Oriented Programming concepts to manage travel agency details.

// 🔹 Class Definition: TravelAgencies

// Create a class TravelAgencies with the following attributes:

// int regNo
// String agencyName
// String packageType
// int price
// boolean flightFacility
// Requirements:
// Provide getter methods for all attributes
// Provide a parameterized constructor in the same order of attributes
// 🔹 Class: Solution

// Create a class Solution with the following two static methods:

// ✅ 1. findAgencyWithHighestPackagePrice
// Method Signature:
// public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies)
// Description:
// This method takes an array of TravelAgencies objects.
// It returns the highest package price among all agencies.
// ✅ 2. agencyDetailsForGivenIdAndType
// Method Signature:
// public static TravelAgencies agencyDetailsForGivenIdAndType(
//     TravelAgencies[] agencies, int regNo, String packageType)
// Description:
// This method returns a TravelAgencies object based on:
// flightFacility must be true
// regNo must match the input
// packageType must match the input (case-sensitive)
// If no match is found:
// Return null
// 🔹 Important Conditions
// A travel agency can have multiple package types
// The combination of agency and package type is unique
// All string comparisons are case-sensitive
// 🔹 Input Format
// Read details of 4 TravelAgencies objects in the following order:
// regNo
// agencyName
// packageType
// price
// flightFacility
// After that, read:
// regNo (for search)
// packageType (for search)
// 🔹 Output Format
// For findAgencyWithHighestPackagePrice:
// Print the highest package price
// For agencyDetailsForGivenIdAndType:
// If object is found → print:
// agencyName:price
// If not found → print:
// No Agency found
// ✅ Test Case (Cleaned)
// Input:
// 123
// A2Z Agency
// Platinum
// 50000
// true
// 345
// SSS Agency
// Gold
// 30000
// false
// 987
// Cox and Kings
// Diamond
// 40000
// true
// 888
// Global Tours
// Silver
// 20000
// false
// 987
// Diamond
// Output:
// 50000
// Cox and Kings:40000
// 💡 Logic Breakdown (Interview Ready)
// Method 1:
// Traverse array
// Track maximum price
// Method 2:
// Traverse array

// Check:

// flightFacility == true
// AND regNo matches
// AND packageType matches

import java.util.Scanner;

public class TravelAagencySys {

    static int findAgencyWithHIghestPackagePrice(TravelAagencies[] arr) {
        int highestPrice = arr[0].getprice();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i].getprice() > highestPrice) {
                highestPrice = arr[i].getprice();
            }

        }
        return highestPrice != 0 ? highestPrice : 0;

    }

    static TravelAagencies agencyDetailsForGivenANdTYpe(TravelAagencies[] arr, int regNo, String pacakgeTYpe) {
        TravelAagencies ans = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getflightFacility() == true) {
                if (arr[i].getRegNo() == (regNo) && arr[i].getPackageType().equals(pacakgeTYpe))
                    return arr[i];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 4 - total no of test case
        TravelAagencies[] arr = new TravelAagencies[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            boolean e = sc.nextBoolean();
            // sc.nextLine();
            arr[i] = new TravelAagencies(a, b, c, d, e);
        }

        int registerNo = sc.nextInt();
        sc.nextLine();
        String myPacakageType = sc.nextLine();
        int highestPackagePrice = findAgencyWithHIghestPackagePrice(arr);
        System.out.println(highestPackagePrice);

        TravelAagencies res = agencyDetailsForGivenANdTYpe(arr, registerNo, myPacakageType);

        // Handle Null pointer exception
        if (res != null) {
            System.out.println(res.getagencyName() + ":" + res.getprice());
        } else {
            System.out.println("No Agency found");
        }

    }

}

class TravelAagencies {
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;

    TravelAagencies(int regNo,
            String agencyName,
            String packageType,
            int price,
            boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    int getRegNo() {
        return regNo;
    }

    String getagencyName() {
        return agencyName;
    }

    int getprice() {
        return price;
    }

    public boolean getflightFacility() {
        return flightFacility;
    }

    String getPackageType() {
        return packageType;
    }

}
