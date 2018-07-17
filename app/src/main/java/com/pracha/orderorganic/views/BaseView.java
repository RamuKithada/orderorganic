package com.pracha.orderorganic.views;

import android.content.Context;

/**
 * Created by saif on 20/03/2018.
 */

public interface BaseView {

    Context getContext();

    void showMessage(int stringId);

    void showMessage(String message);

    void showProgressIndicator(Boolean show);

}
