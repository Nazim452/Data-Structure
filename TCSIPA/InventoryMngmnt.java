package TCSIPA;

import java.util.Scanner;

// Problem Statement

// Create class Inventory with below attributes:

// inventoryId - int
// maximumQuantity - int
// currentQuantity - int
// threshold - int

// Write necessary getters and setters and Constructors.

// Create class Solution and implement static method:

// replenish

// in the Solution class.

// This method will take:

// array of Inventory objects
// a limit int

// as parameters.

// And will return another array of Inventory objects where the limit int is lesser than or equal to the original array of Inventory object's threshold attribute.

// Before calling "replenish" method in the main method, read values for four Inventory objects referring the attributes in above sequence along with a int limit.

// Then call the "replenish" method and write logic in main method to print:

// inventoryId and "Critical Filling" if the threshold attribute is greater than 75
// Else if the threshold attribute is between 50 and 75 then print "Moderate Filling"
// Else print "Non-Critical Filling"
// Sample Input
// 1
// 100
// 50
// 50
// 2
// 200
// 60
// 40
// 3
// 150
// 35
// 45
// 4
// 80
// 45
// 40
// 45

// Sample Output
// 2 Non-Critical Filling
// 3 Non-Critical Filling
// 4 Non-Critical Filling

public class InventoryMngmnt {
    static class Inventory{
        int inventoryId;
        int maxQuantity;
        int currentQuantity;
        int theroshold;
        public Inventory(int inventoryId, int maxQuantity, int currentQuantity, int theroshold) {
            this.inventoryId = inventoryId;
            this.maxQuantity = maxQuantity;
            this.currentQuantity = currentQuantity;
            this.theroshold = theroshold;
        }
        public void setInventoryId(int inventoryId) {
            this.inventoryId = inventoryId;
        }
        public int getInventoryId() {
            return inventoryId;
        }
        public int getMaxQuantity() {
            return maxQuantity;
        }
        public int getCurrentQuantity() {
            return currentQuantity;
        }
        public int getTheroshold() {
            return theroshold;
        }
        public void setMaxQuantity(int maxQuantity) {
            this.maxQuantity = maxQuantity;
        }
        public void setCurrentQuantity(int currentQuantity) {
            this.currentQuantity = currentQuantity;
        }
        public void setTheroshold(int theroshold) {
            this.theroshold = theroshold;
        }
        
    }


    static class Solution{
        static Inventory[]  replenish(Inventory[] arr , int limit){
            int count = 0;
            for(int i = 0; i<arr.length; i++){
                if(arr[i].getTheroshold()<=limit) count++;
            }
            Inventory[] ans = new Inventory[count];
            int k = 0;

            for(int i = 0; i<arr.length; i++){
               if(arr[i].getTheroshold()<=limit) {
                ans[k++] = arr[i];
               }
            }
            return ans;

        }


    }


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Inventory[] arr = new Inventory[4];
        for(int i = 0;i<arr.length; i++){
            int a = sc.nextInt(); sc.nextLine();
            int b = sc.nextInt(); sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            arr[i] = new Inventory(a,b,c,d);

        }

        int limit = sc.nextInt();

        Inventory[] ans = Solution.replenish(arr, limit);
        for(int i = 0; i<ans.length; i++){
            if(ans[i].getTheroshold()>75){
                System.out.println(ans[i].getInventoryId()+" "+"Critical Filling");
            }
            else if(ans[i].getTheroshold()>=50 && ans[i].getTheroshold()<=75){
                System.out.println("Moderate Filling");
            }
            else{
                System.out.println("Non Critical Filling");
            }
        }
        
    }
}
