package com.pracha.orderorganic.models.models.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductList implements Parcelable {
    @SerializedName("item_id")
    @Expose
    private String itemId;
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
    @SerializedName("category_id")
    @Expose
    private String categoryId;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemId);
        dest.writeString(this.itemName);
        dest.writeString(this.itemCost);
        dest.writeString(this.specialPrice);
        dest.writeString(this.offerExpairdate);
        dest.writeString(this.itemQuantity);
        dest.writeString(this.itemStatus);
        dest.writeString(this.categoryId);
        dest.writeString(this.offerAmount);
        dest.writeString(this.offerPercentage);
        dest.writeString(this.itemImage);
        dest.writeString(this.withcrossmarkprice);
        dest.writeString(this.withoutcrossmarkprice);
        dest.writeString(this.percentage);
    }

    public ProductList() {
    }

    protected ProductList(Parcel in) {
        this.itemId = in.readString();
        this.itemName = in.readString();
        this.itemCost = in.readString();
        this.specialPrice = in.readString();
        this.offerExpairdate = in.readString();
        this.itemQuantity = in.readString();
        this.itemStatus = in.readString();
        this.categoryId = in.readString();
        this.offerAmount = in.readString();
        this.offerPercentage = in.readString();
        this.itemImage = in.readString();
        this.withcrossmarkprice = in.readString();
        this.withoutcrossmarkprice = in.readString();
        this.percentage = in.readString();
    }

    public static final Parcelable.Creator<ProductList> CREATOR = new Parcelable.Creator<ProductList>() {
        @Override
        public ProductList createFromParcel(Parcel source) {
            return new ProductList(source);
        }

        @Override
        public ProductList[] newArray(int size) {
            return new ProductList[size];
        }
    };
}
