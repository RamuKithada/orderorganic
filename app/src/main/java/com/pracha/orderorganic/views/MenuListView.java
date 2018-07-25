package com.pracha.orderorganic.views;

import com.pracha.orderorganic.models.models.sidemenu.HomeMenuList;

public interface MenuListView extends BaseView{

    void showMessage(int stringId);

    void showMessage(String message);

    void getMenuListDetails(HomeMenuList homeMenuList);
}
