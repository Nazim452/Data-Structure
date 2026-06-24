package TCSIPA;

public class ActualPYQ {
    public static class Customer {
        private int customerId;
        private String customerName;
        private String customerAddress;
        private long contactNumber;
        private int accountNumer;
        private String accountType;

        public int getCustomerId() {
            return customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public long getContactNumber() {
            return contactNumber;
        }

        public int getAccountNumer() {
            return accountNumer;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public void setContactNumber(long contactNumber) {
            this.contactNumber = contactNumber;
        }

        public void setAccountNumer(int accountNumer) {
            this.accountNumer = accountNumer;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public Customer(int customerId, String customerName, String customerAddress, long contactNumber,
                int accountNumer, String accountType) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.customerAddress = customerAddress;
            this.contactNumber = contactNumber;
            this.accountNumer = accountNumer;
            this.accountType = accountType;
        }

        // So your Customer class already has a default toString() method inherited from
        // Object.

        // You are replacing (overriding) that old method with your own custom version.

        // That is called:
        @Override
        public String toString() {
            return "Customer [customerId=" + customerId + ", customerName=" + customerName +
                    ", customerAddress=" + customerAddress +
                    ", contactNumber=" + contactNumber +
                    ", accountNumber=" + accountNumer +
                    ", accountType=" + accountType + "]";
        }
    }

    static boolean customerExistance(Customer[] c, String name) {
        for (int i = 0; i < c.length; i++) {
            if (c[i].getCustomerName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    static int getCountNum(Customer[] c, String name) {

        int haveaccount = 0;
        for (int i = 0; i < c.length; i++) {

            if (c[i].getCustomerName().equals(name)) {
                haveaccount++;

            }

        }
        return haveaccount;
    }

    static void updatecustomerId(Customer[] c, int id, int newId) {
        for (int i = 0; i < c.length; i++) {
            if (c[i].getCustomerId() == (id)) {
                c[i].setCustomerId(newId);
                System.out.println("Updated Successfully");
                break;

            }
        }

    }

    static int getCountOfAccount(Customer[] c, String name) {
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i].getCustomerName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    static int[] getAccount(Customer[] c, String name) {
        int n = c.length;
        int m = getCountOfAccount(c, name);
        int[] accountArray = new int[m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            // best practice
            if (c[i] != null && c[i].getCustomerName().equals(name)) {
                accountArray[k++] = c[i].getAccountNumer();
            }

        }
        return accountArray;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // Customer[] c = new Customer[5];

        // for (int i = 0; i < c.length; i++) {

        // int a = sc.nextInt();
        // sc.nextLine();

        // }

        // or
        Customer[] cust = new Customer[5];

        cust[0] = new Customer(1, "Sachin", "ABC", 123456789L, 123, "Savings");
        cust[1] = new Customer(2, "Pratiksha", "XYZ", 89676543L, 456, "Savings");
        cust[2] = new Customer(3, "Sachin", "XYZ", 8765L, 789, "Current");
        cust[3] = new Customer(4, "Pragya", "TYU", 9876L, 9130, "Savings");
        cust[4] = new Customer(5, "Saran", "YUI", 87654L, 1234, "Current");

        // int[] arr = getAccount(cust, "Sachin");
        // for(int i = 0;i<arr.length; i++){
        // System.out.println(arr[i]);
        // }
        updatecustomerId(cust, 1, 10);

        System.out.println(getCountNum(cust, "Saran"));
        // for(int i = 0; i<cust.length; i++){

        // System.out.println(cust[i]);
        // }
    }

}
