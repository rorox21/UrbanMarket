package com.example.urbanmarket.models;

public class CategoryModel {

    String img_url;
    String name;
    String tipo;

    public CategoryModel(){

    }

    public CategoryModel(String img_url,String name,String tipo) {
        this.img_url = img_url;
        this.name = name;
        this.tipo = tipo;
    }

    public String getImg_url() {
        return  img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
