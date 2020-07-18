package com.example.myapplication.Subscription;

public class subs_model {
    private int colorback;
    private int colorellipse;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getColorback() {
        return colorback;
    }

    public void setColorback(int colorback) {
        this.colorback = colorback;
    }

    public int getColorellipse() {
        return colorellipse;
    }

    public void setColorellipse(int colorellipse) {
        this.colorellipse = colorellipse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public subs_model(int colorback, int colorellipse, String name, String feature1, String feature2, String feature3, String price) {
        this.colorback = colorback;
        this.colorellipse = colorellipse;
        this.name = name;
        this.price = price;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
    }

    private String name;
    private String feature1;
    private String feature2;
    private String feature3;
}
