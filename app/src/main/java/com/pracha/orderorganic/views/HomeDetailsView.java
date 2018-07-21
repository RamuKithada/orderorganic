package com.pracha.orderorganic.views;

import com.pracha.orderorganic.models.home.HomePageDetails;

public interface HomeDetailsView extends BaseView {

    void showMessage(int stringId);

    void showMessage(String message);

    void getHomeDetails(HomePageDetails homePageDetails);
}
