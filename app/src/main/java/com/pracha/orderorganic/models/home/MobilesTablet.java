package com.pracha.orderorganic.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobilesTablet {
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("subitemid")
    @Expose
    private String subitemid;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("itemwise_id")
    @Expose
    private Object itemwiseId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_cost")
    @Expose
    private String itemCost;
    @SerializedName("special_price")
    @Expose
    private String specialPrice;
    @SerializedName("offer_expairdate")
    @Expose
    private String offerExpairdate;
    @SerializedName("item_quantity")
    @Expose
    private String itemQuantity;
    @SerializedName("item_status")
    @Expose
    private String itemStatus;
    @SerializedName("offer_amount")
    @Expose
    private String offerAmount;
    @SerializedName("offer_percentage")
    @Expose
    private String offerPercentage;
    @SerializedName("item_image")
    @Expose
    private String itemImage;
    @SerializedName("withcrossmarkprice")
    @Expose
    private String withcrossmarkprice;
    @SerializedName("withoutcrossmarkprice")
    @Expose
    private String withoutcrossmarkprice;
    @SerializedName("percentage")
    @Expose
    private String percentage;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSubitemid() {
        return subitemid;
    }

    public void setSubitemid(String subitemid) {
        this.subitemid = subitemid;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Object getItemwiseId() {
        return itemwiseId;
    }

    public void setItemwiseId(Object itemwiseId) {
        this.itemwiseId = itemwiseId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getOfferExpairdate() {
        return offerExpairdate;
    }

    public void setOfferExpairdate(String offerExpairdate) {
        this.offerExpairdate = offerExpairdate;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(String offerAmount) {
        this.offerAmount = offerAmount;
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

    public String getWithcrossmarkprice() {
        return withcrossmarkprice;
    }

    public void setWithcrossmarkprice(String withcrossmarkprice) {
        this.withcrossmarkprice = withcrossmarkprice;
    }

    public String getWithoutcrossmarkprice() {
        return withoutcrossmarkprice;
    }

    public void setWithoutcrossmarkprice(String withoutcrossmarkprice) {
        this.withoutcrossmarkprice = withoutcrossmarkprice;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

}
