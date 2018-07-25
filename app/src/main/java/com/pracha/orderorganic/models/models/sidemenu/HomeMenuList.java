package com.pracha.orderorganic.models.models.sidemenu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeMenuList {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("categorylist")
    @Expose
    private List<MenuCategorylist> categorylist = null;
    @SerializedName("cat_img_path")
    @Expose
    private String catImgPath;
    @SerializedName("subcat_img_path")
    @Expose
    private String subcatImgPath;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<MenuCategorylist> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<MenuCategorylist> categorylist) {
        this.categorylist = categorylist;
    }

    public String getCatImgPath() {
        return catImgPath;
    }

    public void setCatImgPath(String catImgPath) {
        this.catImgPath = catImgPath;
    }

    public String getSubcatImgPath() {
        return subcatImgPath;
    }

    public void setSubcatImgPath(String subcatImgPath) {
        this.subcatImgPath = subcatImgPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
