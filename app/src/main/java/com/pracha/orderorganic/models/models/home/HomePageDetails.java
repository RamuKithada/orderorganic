package com.pracha.orderorganic.models.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pracha.orderorganic.models.models.home.Banners1;
import com.pracha.orderorganic.models.models.home.Banners2;
import com.pracha.orderorganic.models.models.home.Banners3;
import com.pracha.orderorganic.models.models.home.Banners4;
import com.pracha.orderorganic.models.models.home.Categorylist;
import com.pracha.orderorganic.models.models.home.Categorywiseproductlist;
import com.pracha.orderorganic.models.models.home.Dealsoftheday;
import com.pracha.orderorganic.models.models.home.Offersforyou;
import com.pracha.orderorganic.models.models.home.Recentlyviewed;
import com.pracha.orderorganic.models.models.home.Seasonsale;
import com.pracha.orderorganic.models.models.home.Topoffer;
import com.pracha.orderorganic.models.models.home.Trendingproduct;

import java.util.List;

public class HomePageDetails {
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("banners1")
    @Expose
    private List<Banners1> banners1 = null;
    @SerializedName("categorylist")
    @Expose
    private List<Categorylist> categorylist = null;
    @SerializedName("topoffer")
    @Expose
    private List<Topoffer> topoffer = null;
    @SerializedName("banners2")
    @Expose
    private List<Banners2> banners2 = null;
    @SerializedName("trendingproducts")
    @Expose
    private List<Trendingproduct> trendingproducts = null;
    @SerializedName("offersforyou")
    @Expose
    private List<Offersforyou> offersforyou = null;
    @SerializedName("banners3")
    @Expose
    private List<Banners3> banners3 = null;
    @SerializedName("dealsoftheday")
    @Expose
    private List<Dealsoftheday> dealsoftheday = null;
    @SerializedName("seasonsales")
    @Expose
    private List<Seasonsale> seasonsales = null;
    @SerializedName("banners4")
    @Expose
    private List<Banners4> banners4 = null;
    @SerializedName("recentlyviewed")
    @Expose
    private List<Recentlyviewed> recentlyviewed = null;
    @SerializedName("categorywiseproductlist")
    @Expose
    private List<Categorywiseproductlist> categorywiseproductlist=null;
    @SerializedName("categoryimage")
    @Expose
    private String categoryimage;
    @SerializedName("imagepath")
    @Expose
    private String imagepath;
    @SerializedName("banners1path")
    @Expose
    private String banners1path;
    @SerializedName("bannerspath")
    @Expose
    private String bannerspath;
    @SerializedName("message")
    @Expose
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Banners1> getBanners1() {
        return banners1;
    }

    public void setBanners1(List<Banners1> banners1) {
        this.banners1 = banners1;
    }

    public List<Categorylist> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Categorylist> categorylist) {
        this.categorylist = categorylist;
    }

    public List<Topoffer> getTopoffer() {
        return topoffer;
    }

    public void setTopoffer(List<Topoffer> topoffer) {
        this.topoffer = topoffer;
    }

    public List<Banners2> getBanners2() {
        return banners2;
    }

    public void setBanners2(List<Banners2> banners2) {
        this.banners2 = banners2;
    }

    public List<Trendingproduct> getTrendingproducts() {
        return trendingproducts;
    }

    public void setTrendingproducts(List<Trendingproduct> trendingproducts) {
        this.trendingproducts = trendingproducts;
    }

    public List<Offersforyou> getOffersforyou() {
        return offersforyou;
    }

    public void setOffersforyou(List<Offersforyou> offersforyou) {
        this.offersforyou = offersforyou;
    }

    public List<Banners3> getBanners3() {
        return banners3;
    }

    public void setBanners3(List<Banners3> banners3) {
        this.banners3 = banners3;
    }

    public List<Dealsoftheday> getDealsoftheday() {
        return dealsoftheday;
    }

    public void setDealsoftheday(List<Dealsoftheday> dealsoftheday) {
        this.dealsoftheday = dealsoftheday;
    }

    public List<Seasonsale> getSeasonsales() {
        return seasonsales;
    }

    public void setSeasonsales(List<Seasonsale> seasonsales) {
        this.seasonsales = seasonsales;
    }

    public List<Banners4> getBanners4() {
        return banners4;
    }

    public void setBanners4(List<Banners4> banners4) {
        this.banners4 = banners4;
    }

    public List<Recentlyviewed> getRecentlyviewed() {
        return recentlyviewed;
    }

    public void setRecentlyviewed(List<Recentlyviewed> recentlyviewed) {
        this.recentlyviewed = recentlyviewed;
    }

    public List<Categorywiseproductlist> getCategorywiseproductlist() {
        return categorywiseproductlist;
    }

    public void setCategorywiseproductlist(List<Categorywiseproductlist> categorywiseproductlist) {
        this.categorywiseproductlist = categorywiseproductlist;
    }

    public String getCategoryimage() {
        return categoryimage;
    }

    public void setCategoryimage(String categoryimage) {
        this.categoryimage = categoryimage;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getBanners1path() {
        return banners1path;
    }

    public void setBanners1path(String banners1path) {
        this.banners1path = banners1path;
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
