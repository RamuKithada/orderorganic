package com.pracha.orderorganic.models.models.subcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subcategory {
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("subcategory_name")
    @Expose
    private String subcategoryName;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_image")
    @Expose
    private String subcategoryImage;

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryImage() {
        return subcategoryImage;
    }

    public void setSubcategoryImage(String subcategoryImage) {
        this.subcategoryImage = subcategoryImage;
    }

}
