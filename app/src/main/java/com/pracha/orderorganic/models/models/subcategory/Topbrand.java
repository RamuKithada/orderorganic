package com.pracha.orderorganic.models.models.subcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topbrand {
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("added_by")
    @Expose
    private String addedBy;
    @SerializedName("status")
    @Expose
    private String status;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
