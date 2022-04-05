package com.example.lab_06_fagment_figma;

import java.io.Serializable;

public class Shoe implements Serializable {
    private String name;
    private String details;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Shoe(String name, String details, int image) {
        this.name = name;
        this.details = details;
        this.image = image;
    }

    public Shoe() {
    }
}
