package com.pracha.orderorganic.models.models.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topoffer implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryId);
        dest.writeString(this.offerPercentage);
        dest.writeString(this.itemImage);
        dest.writeString(this.categoryName);
    }

    public Topoffer() {
    }

    protected Topoffer(Parcel in) {
        this.categoryId = in.readString();
        this.offerPercentage = in.readString();
        this.itemImage = in.readString();
        this.categoryName = in.readString();
    }

    public static final Parcelable.Creator<Topoffer> CREATOR = new Parcelable.Creator<Topoffer>() {
        @Override
        public Topoffer createFromParcel(Parcel source) {
            return new Topoffer(source);
        }

        @Override
        public Topoffer[] newArray(int size) {
            return new Topoffer[size];
        }
    };
}
