package com.herballife.main.models;

import java.sql.Blob;

public class Catalog {
    public int id;
    public String name;
    public String kegunaan;
    public Blob image;

    public Catalog(int id, String name, String kegunaan, Blob image){

        this.id = id;
        this.name = name;
        this.kegunaan = kegunaan;
        this.image = image;

    }

    public Catalog(String nama, String kegunaan, Blob image) {
        this.name = nama;
        this.kegunaan = kegunaan;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKegunaan() {
        return kegunaan;
    }

    public Blob getImage() {
        return image;
    }

}
