package com.pracha.orderorganic.models.models.sidemenu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuCategorylist {
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("subcategory_list")
    @Expose
    private List<MenuSubcategoryList> subcategoryList = null;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<MenuSubcategoryList> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<MenuSubcategoryList> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

}
