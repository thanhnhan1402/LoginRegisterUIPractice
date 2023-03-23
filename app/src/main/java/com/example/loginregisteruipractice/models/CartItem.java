package com.example.loginregisteruipractice.models;

import java.util.ArrayList;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ArrayList<CartItem> createCartItems(int num) {
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

        for (int i = 1; i <= num; i++) {
            cartItems.add(new CartItem(new Product(1, "PC đời mới", "", "", 15, 15, "1", "2022"),5));
        }

        return cartItems;
    }
}
