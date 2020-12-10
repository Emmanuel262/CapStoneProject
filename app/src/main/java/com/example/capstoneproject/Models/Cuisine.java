package com.example.capstoneproject.Models;

public class Cuisine {
    private int id;
    private int restaurant_id;
    private String name;
    private String image_url;
    private String price;
    private String description;

    public Cuisine(int id, int restaurant_id, String name, String image_url, String price, String description) {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.name = name;
        this.image_url = image_url;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
