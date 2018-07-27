package com.pracha.orderorganic.views;

import com.pracha.orderorganic.models.models.subcategory.SubCategoryDetails;

public interface SubCategoryView extends BaseView {
    void showMessage(int stringId);

    void showMessage(String message);

    void getSubCategoryDetails(SubCategoryDetails subCategoryDetails);
}
