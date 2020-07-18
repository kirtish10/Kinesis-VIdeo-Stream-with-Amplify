package com.example.myapplication.questionare;

public class Model {

    private int image;
    private String title;

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    private int back;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Model(int image, String title,int back) {
        this.image = image;
        this.title = title;
        this.back = back;
    }
}
