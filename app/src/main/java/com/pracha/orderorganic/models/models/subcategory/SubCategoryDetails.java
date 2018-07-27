package com.pracha.orderorganic.models.models.subcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pracha.orderorganic.models.models.home.Banners;
import com.pracha.orderorganic.models.models.home.ProductList;

import java.util.List;

public class SubCategoryDetails {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("banners1")
    @Expose
    private List<Banners> banners1 = null;
    @SerializedName("subcategory")
    @Expose
    private List<Subcategory> subcategory = null;
    @SerializedName("topbrands")
    @Expose
    private List<Topbrand> topbrands = null;
    @SerializedName("banners2")
    @Expose
    private List<Banners> banners2 = null;
    @SerializedName("shopbyprice")
    @Expose
    private List<Double> shopbyprice = null;
    @SerializedName("shopbyx")
    @Expose
    private List<ProductList> shopbyx = null;
    @SerializedName("shopbyxlabel")
    @Expose
    private String shopbyxlabel;
    @SerializedName("banners3")
    @Expose
    private List<Banners> banners3 = null;
    @SerializedName("subitems")
    @Expose
    private List<Subitem> subitems = null;
    @SerializedName("shopbyy")
    @Expose
    private List<ProductList> shopbyy = null;
    @SerializedName("shopbyylabel")
    @Expose
    private String shopbyylabel;
    @SerializedName("shopbyz")
    @Expose
    private List<ProductList> shopbyz = null;
    @SerializedName("shopbyzlable")
    @Expose
    private String shopbyzlable;
    @SerializedName("banners4")
    @Expose
    private List<Banners> banners4 = null;
    @SerializedName("mostviewed")
    @Expose
    private List<ProductList> mostviewed = null;
    @SerializedName("recommended")
    @Expose
    private List<ProductList> recommended = null;
    @SerializedName("banners5")
    @Expose
    private List<Banners> banners5 = null;
    @SerializedName("subcategoryimage")
    @Expose
    private String subcategoryimage;
    @SerializedName("imagepath")
    @Expose
    private String imagepath;
    @SerializedName("bannerspath")
    @Expose
    private String bannerspath;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Banners> getBanners1() {
        return banners1;
    }

    public void setBanners1(List<Banners> banners1) {
        this.banners1 = banners1;
    }

    public List<Subcategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<Subcategory> subcategory) {
        this.subcategory = subcategory;
    }

    public List<Topbrand> getTopbrands() {
        return topbrands;
    }

    public void setTopbrands(List<Topbrand> topbrands) {
        this.topbrands = topbrands;
    }

    public List<Banners> getBanners2() {
        return banners2;
    }

    public void setBanners2(List<Banners> banners2) {
        this.banners2 = banners2;
    }

    public List<Double> getShopbyprice() {
        return shopbyprice;
    }

    public void setShopbyprice(List<Double> shopbyprice) {
        this.shopbyprice = shopbyprice;
    }

    public List<ProductList> getShopbyx() {
        return shopbyx;
    }

    public void setShopbyx(List<ProductList> shopbyx) {
        this.shopbyx = shopbyx;
    }

    public String getShopbyxlabel() {
        return shopbyxlabel;
    }

    public void setShopbyxlabel(String shopbyxlabel) {
        this.shopbyxlabel = shopbyxlabel;
    }

    public List<Banners> getBanners3() {
        return banners3;
    }

    public void setBanners3(List<Banners> banners3) {
        this.banners3 = banners3;
    }

    public List<Subitem> getSubitems() {
        return subitems;
    }

    public void setSubitems(List<Subitem> subitems) {
        this.subitems = subitems;
    }

    public List<ProductList> getShopbyy() {
        return shopbyy;
    }

    public void setShopbyy(List<ProductList> shopbyy) {
        this.shopbyy = shopbyy;
    }

    public String getShopbyylabel() {
        return shopbyylabel;
    }

    public void setShopbyylabel(String shopbyylabel) {
        this.shopbyylabel = shopbyylabel;
    }

    public List<ProductList> getShopbyz() {
        return shopbyz;
    }

    public void setShopbyz(List<ProductList> shopbyz) {
        this.shopbyz = shopbyz;
    }

    public String getShopbyzlable() {
        return shopbyzlable;
    }

    public void setShopbyzlable(String shopbyzlable) {
        this.shopbyzlable = shopbyzlable;
    }

    public List<Banners> getBanners4() {
        return banners4;
    }

    public void setBanners4(List<Banners> banners4) {
        this.banners4 = banners4;
    }

    public List<ProductList> getMostviewed() {
        return mostviewed;
    }

    public void setMostviewed(List<ProductList> mostviewed) {
        this.mostviewed = mostviewed;
    }

    public List<ProductList> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<ProductList> recommended) {
        this.recommended = recommended;
    }

    public List<Banners> getBanners5() {
        return banners5;
    }

    public void setBanners5(List<Banners> banners5) {
        this.banners5 = banners5;
    }

    public String getSubcategoryimage() {
        return subcategoryimage;
    }

    public void setSubcategoryimage(String subcategoryimage) {
        this.subcategoryimage = subcategoryimage;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getBannerspath() {
        return bannerspath;
    }

    public void setBannerspath(String bannerspath) {
        this.bannerspath = bannerspath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
