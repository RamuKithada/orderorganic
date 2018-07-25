package com.pracha.orderorganic.models.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offersforyou {

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("item_image")
    @Expose
    private String itemImage;
    @SerializedName("offers")
    @Expose
    private String offers;
    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
