package com.pracha.orderorganic.models.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categorywiseproductlist {

    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("plist")
    @Expose
    private List<ProductList> plist = null;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<ProductList> getPlist() {
        return plist;
    }

    public void setPlist(List<ProductList> plist) {
        this.plist = plist;
    }

}