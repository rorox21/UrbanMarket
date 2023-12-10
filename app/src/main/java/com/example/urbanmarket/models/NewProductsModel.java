package com.example.urbanmarket.models;

import java.io.Serializable;

public class NewProductsModel implements Serializable {
    String descripcion;
    String name;
    String rating;
    int price;
    String img_url;

    public NewProductsModel () {
    }

    public NewProductsModel(String descripcion,String name,String rating,int price,String img_url){
        this.descripcion = descripcion;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.img_url = img_url;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}