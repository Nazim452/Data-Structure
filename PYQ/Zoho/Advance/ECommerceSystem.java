package PYQ.Zoho.Advance;
// ECommerceSystem

import java.util.*;

// 🛒 E-Commerce Order Management System

// (Order Lifecycle + Inventory Update + Status Workflow + History Tracking)

// This is commonly asked because it reflects real SaaS/product logic (Zoho style systems).

// It tests:

// OOP modeling

// Order lifecycle management

// Inventory validation

// Status transitions

// Revenue tracking

// Clean modular design

// 🏢 ROUND 3 – Advanced Programming
// Design an In-Memory E-Commerce Order Management System
// 🧠 Problem Statement (Zoho Style)

// Design and implement a console-based E-Commerce System that supports:

// Adding products to inventory

// Registering customers

// Placing orders

// Cancelling orders

// Updating order status

// Viewing order history

// Tracking total revenue

// All data must be stored in memory.

// 📦 Assumptions

// Each Product has:

// Product ID (unique)

// Name

// Price

// Stock quantity

// Each Customer has:

// Customer ID (unique)

// Name

// Each Order has:

// Order ID

// Customer ID

// List of products + quantity

// Total amount

// Status:

// PLACED

// SHIPPED

// DELIVERED

// CANCELLED

// Rules:

// Cannot place order if stock insufficient

// Stock reduces when order is placed

// Cancel only if not delivered

// Revenue increases only for DELIVERED orders

// 📋 Functional Requirements
// 1️⃣ Add Product

// Reject duplicate ID.

// 2️⃣ Register Customer

// Reject duplicate ID.

// 3️⃣ Place Order

// Input:

// Customer ID

// Product ID + Quantity

// Rules:

// Customer must exist

// Product must exist

// Stock must be sufficient

// Deduct stock

// Status = PLACED

// 4️⃣ Update Order Status

// Only allowed transitions:

// PLACED → SHIPPED → DELIVERED
// PLACED → CANCELLED

// 5️⃣ Cancel Order

// Allowed only if not DELIVERED.

// Restore stock.

// 6️⃣ View Order History
// 7️⃣ Show Total Revenue

// Only delivered orders count.
public class ECommerceSystem {

    enum OrderStatus {
        PLACED, SHIPPED, DELIVERED, CANCELLED
    }

    // -------- PRODUCT --------
    static class Product {
        int id;
        String name;
        double price;
        int stock;

        Product(int id, String name, double price, int stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
    }

    // -------- CUSTOMER --------
    static class Customer {
        int id;
        String name;
        List<Order> orderHistory = new ArrayList<>();

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // -------- ORDER ITEM --------
    static class OrderItem {
        Product product;
        int quantity;

        OrderItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        double getTotal() {
            return quantity * product.price;
        }
    }

    // -------- ORDER --------
    static class Order {
        int orderId;
        int customerId;
        List<OrderItem> items;
        double totalAmount;
        OrderStatus status;

        Order(int orderId, int customerId,
              List<OrderItem> items, double totalAmount) {

            this.orderId = orderId;
            this.customerId = customerId;
            this.items = items;
            this.totalAmount = totalAmount;
            this.status = OrderStatus.PLACED;
        }

        void print() {
            System.out.println("OrderID: " + orderId +
                    " | Total: ₹" + totalAmount +
                    " | Status: " + status);
        }
    }

    // -------- ECOMMERCE SYSTEM --------
    static class ECommerce {

        Map<Integer, Product> products = new HashMap<>();
        Map<Integer, Customer> customers = new HashMap<>();
        Map<Integer, Order> orders = new HashMap<>();

        int orderCounter = 1;
        double totalRevenue = 0;

        // Add product
        void addProduct(int id, String name, double price, int stock) {

            if (products.containsKey(id)) {
                System.out.println("Product ID already exists.");
                return;
            }

            products.put(id, new Product(id, name, price, stock));
            System.out.println("Product added successfully.");
        }

        // Register customer
        void registerCustomer(int id, String name) {

            if (customers.containsKey(id)) {
                System.out.println("Customer ID already exists.");
                return;
            }

            customers.put(id, new Customer(id, name));
            System.out.println("Customer registered successfully.");
        }

        // Place order
        void placeOrder(int customerId, int productId, int quantity) {

            Customer customer = customers.get(customerId);
            Product product = products.get(productId);

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

            if (quantity > product.stock) {
                System.out.println("Insufficient stock.");
                return;
            }

            product.stock -= quantity;

            List<OrderItem> items = new ArrayList<>();
            OrderItem item = new OrderItem(product, quantity);
            items.add(item);

            double total = item.getTotal();

            Order order = new Order(orderCounter++, customerId, items, total);

            orders.put(order.orderId, order);
            customer.orderHistory.add(order);

            System.out.println("Order placed successfully. OrderID: " + order.orderId);
        }

        // Update order status
        void updateOrderStatus(int orderId, OrderStatus newStatus) {

            Order order = orders.get(orderId);

            if (order == null) {
                System.out.println("Order not found.");
                return;
            }

            if (order.status == OrderStatus.CANCELLED ||
                order.status == OrderStatus.DELIVERED) {
                System.out.println("Order already finalized.");
                return;
            }

            if (order.status == OrderStatus.PLACED &&
                (newStatus == OrderStatus.SHIPPED ||
                 newStatus == OrderStatus.CANCELLED)) {

                order.status = newStatus;

            } else if (order.status == OrderStatus.SHIPPED &&
                       newStatus == OrderStatus.DELIVERED) {

                order.status = newStatus;
                totalRevenue += order.totalAmount;

            } else {
                System.out.println("Invalid status transition.");
                return;
            }

            System.out.println("Order status updated to " + order.status);
        }

        // Cancel order
        void cancelOrder(int orderId) {

            Order order = orders.get(orderId);

            if (order == null) {
                System.out.println("Order not found.");
                return;
            }

            if (order.status == OrderStatus.DELIVERED) {
                System.out.println("Cannot cancel delivered order.");
                return;
            }

            if (order.status == OrderStatus.CANCELLED) {
                System.out.println("Order already cancelled.");
                return;
            }

            // Restore stock
            for (OrderItem item : order.items) {
                item.product.stock += item.quantity;
            }

            order.status = OrderStatus.CANCELLED;

            System.out.println("Order cancelled.");
        }

        // View customer order history
        void viewOrderHistory(int customerId) {

            Customer customer = customers.get(customerId);

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            if (customer.orderHistory.isEmpty()) {
                System.out.println("No orders found.");
                return;
            }

            for (Order order : customer.orderHistory) {
                order.print();
            }
        }

        // Show total revenue
        void showRevenue() {
            System.out.println("Total Revenue: ₹" + totalRevenue);
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        ECommerce system = new ECommerce();

        system.addProduct(101, "Laptop", 50000, 10);
        system.addProduct(102, "Phone", 20000, 20);

        system.registerCustomer(1, "Nazim");

        system.placeOrder(1, 101, 1);

        system.updateOrderStatus(1, OrderStatus.SHIPPED);
        system.updateOrderStatus(1, OrderStatus.DELIVERED);

        system.viewOrderHistory(1);

        system.showRevenue();
    }
}
