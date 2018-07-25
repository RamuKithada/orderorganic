package com.pracha.orderorganic.models.models.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banners1 {

    @SerializedName("img1")
    @Expose
    private String img1;

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

}
