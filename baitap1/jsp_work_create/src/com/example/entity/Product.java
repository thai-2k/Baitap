package com.example.entity;

public class Product {
    private int id;
    private String name;
    private String pro_desc;

    public Product(int id, String name, String pro_desc) {
        this.id = id;
        this.name = name;
        this.pro_desc = pro_desc;
    }

    public Product() {
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

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }
}
