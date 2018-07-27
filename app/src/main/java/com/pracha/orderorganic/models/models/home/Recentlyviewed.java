package com.pracha.orderorganic.models.models.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recentlyviewed implements Parcelable {
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("subitemid")
    @Expose
    private String subitemid;
    @SerializedName("itemwise_id")
    @Expose
    private String itemwiseId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_status")
    @Expose
    private String itemStatus;
    @SerializedName("item_cost")
    @Expose
    private String itemCost;
    @SerializedName("special_price")
    @Expose
    private String specialPrice;
    @SerializedName("item_quantity")
    @Expose
    private String itemQuantity;
    @SerializedName("offer_percentage")
    @Expose
    private String offerPercentage;
    @SerializedName("offer_amount")
    @Expose
    private String offerAmount;
    @SerializedName("offer_expairdate")
    @Expose
    private String offerExpairdate;
    @SerializedName("offer_type")
    @Expose
    private String offerType;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("offers")
    @Expose
    private String offers;
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

    public String getSubitemid() {
        return subitemid;
    }

    public void setSubitemid(String subitemid) {
        this.subitemid = subitemid;
    }

    public String getItemwiseId() {
        return itemwiseId;
    }

    public void setItemwiseId(String itemwiseId) {
        this.itemwiseId = itemwiseId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
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

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(String offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public String getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(String offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getOfferExpairdate() {
        return offerExpairdate;
    }

    public void setOfferExpairdate(String offerExpairdate) {
        this.offerExpairdate = offerExpairdate;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
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
        dest.writeString(this.categoryId);
        dest.writeString(this.subcategoryId);
        dest.writeString(this.subitemid);
        dest.writeString(this.itemwiseId);
        dest.writeString(this.itemName);
        dest.writeString(this.itemStatus);
        dest.writeString(this.itemCost);
        dest.writeString(this.specialPrice);
        dest.writeString(this.itemQuantity);
        dest.writeString(this.offerPercentage);
        dest.writeString(this.offerAmount);
        dest.writeString(this.offerExpairdate);
        dest.writeString(this.offerType);
        dest.writeString(this.discount);
        dest.writeString(this.offers);
        dest.writeString(this.itemImage);
        dest.writeString(this.withcrossmarkprice);
        dest.writeString(this.withoutcrossmarkprice);
        dest.writeString(this.percentage);
    }

    public Recentlyviewed() {
    }

    protected Recentlyviewed(Parcel in) {
        this.itemId = in.readString();
        this.categoryId = in.readString();
        this.subcategoryId = in.readString();
        this.subitemid = in.readString();
        this.itemwiseId = in.readString();
        this.itemName = in.readString();
        this.itemStatus = in.readString();
        this.itemCost = in.readString();
        this.specialPrice = in.readString();
        this.itemQuantity = in.readString();
        this.offerPercentage = in.readString();
        this.offerAmount = in.readString();
        this.offerExpairdate = in.readString();
        this.offerType = in.readString();
        this.discount = in.readString();
        this.offers = in.readString();
        this.itemImage = in.readString();
        this.withcrossmarkprice = in.readString();
        this.withoutcrossmarkprice = in.readString();
        this.percentage = in.readString();
    }

    public static final Parcelable.Creator<Recentlyviewed> CREATOR = new Parcelable.Creator<Recentlyviewed>() {
        @Override
        public Recentlyviewed createFromParcel(Parcel source) {
            return new Recentlyviewed(source);
        }

        @Override
        public Recentlyviewed[] newArray(int size) {
            return new Recentlyviewed[size];
        }
    };
}
