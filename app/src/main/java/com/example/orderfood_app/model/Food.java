package com.example.orderfood_app.model;

public class Food {
    private String Name,Image,Descriptoin,Price, Discount,MenuId;

    public Food() {
    }

    public Food(String name, String image, String descriptoin, String price, String discount, String menuId) {
        Name = name;
        Image = image;
        Descriptoin = descriptoin;
        Price = price;
        Discount = discount;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescriptoin() {
        return Descriptoin;
    }

    public void setDescriptoin(String descriptoin) {
        Descriptoin = descriptoin;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
