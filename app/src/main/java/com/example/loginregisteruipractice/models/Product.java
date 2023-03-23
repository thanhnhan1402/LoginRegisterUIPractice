package com.example.loginregisteruipractice.models;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private String url;
    private String description;
    private double price;
    private int quantity;
    private String categoryId;

    public Product(int id, String name, String url, String description, double price, int quantity, String categoryId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
