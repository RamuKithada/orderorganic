package com.pracha.orderorganic.models.models.subcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subitem {
    @SerializedName("subitem_id")
    @Expose
    private String subitemId;
    @SerializedName("subitem_name")
    @Expose
    private String subitemName;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;

    public String getSubitemId() {
        return subitemId;
    }

    public void setSubitemId(String subitemId) {
        this.subitemId = subitemId;
    }

    public String getSubitemName() {
        return subitemName;
    }

    public void setSubitemName(String subitemName) {
        this.subitemName = subitemName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

}
