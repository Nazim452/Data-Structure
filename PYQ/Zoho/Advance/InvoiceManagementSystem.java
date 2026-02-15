package PYQ.Zoho.Advance;
// InvoiceManagementSystem
import java.util.*;




// Design and implement a menu-driven In-Memory Billing / Invoice System for a retail store.

// The system must:

// Maintain product inventory

// Allow customers to add/remove products to cart

// Validate stock before checkout

// Generate invoice with subtotal, tax, discount, final amount

// Update inventory after successful checkout

// Store invoice history

// 📦 Core Entities

// You must design:

// Product

// CartItem

// Invoice

// Inventory Manager

// Billing System

// 📋 Functional Requirements
// 1️⃣ Add Product to Inventory

// Product ID (unique)

// Name

// Price

// Quantity

// Reject duplicate ID.

// 2️⃣ Add Product to Cart

// Product ID

// Quantity

// Rules:

// Product must exist

// Requested quantity ≤ available stock

// If already in cart → increase quantity

// 3️⃣ Remove Product from Cart

// Reduce quantity OR remove item completely

// 4️⃣ Checkout

// Calculate:

// Subtotal

// Tax (10%)

// Discount (5% if subtotal > 1000)

// Generate Invoice ID

// Deduct stock from inventory

// Store invoice

// 5️⃣ View Invoice History

// Display:

// Invoice ID

// Items

// Total amount










public class InvoiceManagementSystem {

    // ---------------- PRODUCT ----------------
    static class Product {
        int id;
        String name;
        double price;
        int quantity;

        Product(int id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    // ---------------- CART ITEM ----------------
    static class CartItem {
        Product product;
        int quantity;

        CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        double getTotal() {
            return quantity * product.price;
        }
    }

    // ---------------- INVOICE ----------------
    static class Invoice {
        String invoiceId;
        List<CartItem> items;
        double subtotal;
        double tax;
        double discount;
        double finalAmount;

        Invoice(String invoiceId, List<CartItem> items,
                double subtotal, double tax,
                double discount, double finalAmount) {

            this.invoiceId = invoiceId;
            this.items = items;
            this.subtotal = subtotal;
            this.tax = tax;
            this.discount = discount;
            this.finalAmount = finalAmount;
        }

        void printInvoice() {
            System.out.println("\nInvoice ID: " + invoiceId);
            System.out.println("Items:");
            for (CartItem item : items) {
                System.out.println(item.product.name + " | Qty: " +
                        item.quantity + " | Price: " +
                        item.product.price);
            }
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Tax: " + tax);
            System.out.println("Discount: " + discount);
            System.out.println("Final Amount: " + finalAmount);
        }
    }

    // ---------------- BILLING SYSTEM ----------------
    static class BillingSystem {

        Map<Integer, Product> inventory = new HashMap<>();
        Map<Integer, CartItem> cart = new HashMap<>();
        List<Invoice> invoiceHistory = new ArrayList<>();
        int invoiceCounter = 1;

        // Add product
        void addProduct(int id, String name, double price, int quantity) {
            if (inventory.containsKey(id)) {
                System.out.println("Product ID already exists.");
                return;
            }
            inventory.put(id, new Product(id, name, price, quantity));
            System.out.println("Product added successfully.");
        }

        // Add to cart
        void addToCart(int productId, int quantity) {
            Product p = inventory.get(productId);

            if (p == null) {
                System.out.println("Product not found.");
                return;
            }

            if (quantity > p.quantity) {
                System.out.println("Insufficient stock.");
                return;
            }

            if (cart.containsKey(productId)) {
                cart.get(productId).quantity += quantity;
            } else {
                cart.put(productId, new CartItem(p, quantity));
            }

            System.out.println("Added to cart.");
        }

        // Remove from cart
        void removeFromCart(int productId, int quantity) {

            if (!cart.containsKey(productId)) {
                System.out.println("Product not in cart.");
                return;
            }

            CartItem item = cart.get(productId);

            if (quantity >= item.quantity) {
                cart.remove(productId);
            } else {
                item.quantity -= quantity;
            }

            System.out.println("Updated cart.");
        }

        // Checkout
        void checkout() {

            if (cart.isEmpty()) {
                System.out.println("Cart is empty.");
                return;
            }

            double subtotal = 0;

            for (CartItem item : cart.values()) {
                subtotal += item.getTotal();
            }

            double discount = 0;
            if (subtotal > 1000) {
                discount = subtotal * 0.05;
            }

            double tax = subtotal * 0.10;
            double finalAmount = subtotal + tax - discount;

            // Deduct stock
            for (CartItem item : cart.values()) {
                item.product.quantity -= item.quantity;
            }

            Invoice invoice = new Invoice(
                    "INV" + invoiceCounter++,
                    new ArrayList<>(cart.values()),
                    subtotal,
                    tax,
                    discount,
                    finalAmount
            );

            invoiceHistory.add(invoice);

            invoice.printInvoice();

            cart.clear();
        }

        // View invoice history
        void printInvoiceHistory() {
            for (Invoice invoice : invoiceHistory) {
                invoice.printInvoice();
            }
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        BillingSystem system = new BillingSystem();

        system.addProduct(101, "Rice", 50, 100);
        system.addProduct(102, "Sugar", 40, 80);

        system.addToCart(101, 5);
        system.addToCart(102, 3);

        system.checkout();

        system.printInvoiceHistory();
    }
}

