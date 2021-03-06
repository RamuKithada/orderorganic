package com.pracha.orderorganic.models.models.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trendingproduct implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryId);
        dest.writeString(this.itemImage);
        dest.writeString(this.offers);
        dest.writeString(this.categoryName);
    }

    public Trendingproduct() {
    }

    protected Trendingproduct(Parcel in) {
        this.categoryId = in.readString();
        this.itemImage = in.readString();
        this.offers = in.readString();
        this.categoryName = in.readString();
    }

    public static final Parcelable.Creator<Trendingproduct> CREATOR = new Parcelable.Creator<Trendingproduct>() {
        @Override
        public Trendingproduct createFromParcel(Parcel source) {
            return new Trendingproduct(source);
        }

        @Override
        public Trendingproduct[] newArray(int size) {
            return new Trendingproduct[size];
        }
    };
}
