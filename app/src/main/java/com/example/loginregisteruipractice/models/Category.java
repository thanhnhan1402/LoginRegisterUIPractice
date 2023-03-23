package com.example.loginregisteruipractice.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private String url;

    public Category(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public static List<Category> createCategoryList(){
        List<Category> list = new ArrayList<Category>();
        list.add(new Category(1, "Laptop", "https://cdn.tgdd.vn/Products/Images/42/247508/iphone-14-pro-tim-thumb-600x600.jpg"));
        list.add(new Category(2, "Máy lạnh", "https://tinhocluna.com/wp-content/uploads/2021/04/pc-gaming.jpg"));
        list.add(new Category(3, "Máy giặt", "https://diennuocnhatlong.vn/uploads/may-lanh-nguyen-ly-hoat-dong-3.jpg"));

        return list;
    }
}
