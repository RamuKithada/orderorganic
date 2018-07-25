package com.pracha.orderorganic.models.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seasonsale {
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("offer_percentage")
    @Expose
    private String offerPercentage;
    @SerializedName("item_image")
    @Expose
    private String itemImage;
    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(String offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
