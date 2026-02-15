package PYQ.Zoho.Advance;

import java.util.ArrayList;

import PYQ.Zoho.Advance.ProductMngmgnt.product.StockManagement;

public class ProductMngmgnt {
    enum type {
        SALE, PURCHASE
    };

    static class product {
        int productId;
        String productName;
        String category;
        int quantity;
        int price;
        String supplierName;

        product(int productId, String productName, String category, int quantity, int price, String supplierName) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.quantity = quantity;
            this.price = price;
            this.supplierName = supplierName;

        }

        static class StockManagement {
            ArrayList<product> list = new ArrayList<>();

            void printProductDetails(String Category) {
                for (product item : list) {

                    if (item.category.equals(Category)) {

                        System.out.println("Product id" + item.productId);
                        System.out.println("Product Name" + item.productName);
                        System.out.println("Product Category" + item.category);
                        System.out.println(item.quantity);
                        System.out.println(item.price);
                        System.out.println(item.supplierName);
                        return;
                    }

                }
            }

            void addProduct(int productId, String productName, String category, int quantity, int price,String supplierName) {

                for (product item : list) {
                    if (item.productId == productId) {
                        System.out.println("Product Id Already exist");
                        return;
                    } else if (item.quantity < 0) {
                        System.out.println("Quantity in negative not allowd");
                        return;
                    }

                }

                product p = new product(productId, productName, category, quantity, price, supplierName);
                list.add(p);

            }

            void updateProduct(int productId, int quantity) {
                if (quantity < 0) {
                    System.out.println("Can't add negative quantity");
                    return;
                }
                int currentQUantity = 0;

                for (product item : list) {
                    if (productId == item.productId) {
                        item.quantity += quantity;
                        currentQUantity = item.quantity;
                    }

                }
                System.out.println("Product Updated Succesfully");
                System.out.println("Current Quantity" + currentQUantity);

            }

            void searchProduct(String category) {
                System.out.println("Searching on the basis of category");

                for (product item : list) {
                    if (item.category.equals(category)) {
                        printProductDetails(category);

                    }

                }
            }
       
       
       
        }

    }

    public static void main(String[] args) {
        StockManagement st = new StockManagement();
        st.addProduct(12, "Apple", "Fruite", 20, 40, "AB Trader");
        st.addProduct(13, "Orange", "Fruite", 20, 40, "BC Trader");
        st.addProduct(13, "Orange", "Fruite", 20, 40, "BC Trader");

        st.printProductDetails("Fruite");

    }
}
