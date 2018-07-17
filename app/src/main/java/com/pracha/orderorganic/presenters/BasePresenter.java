package com.pracha.orderorganic.presenters;

/**
 * Created by saif on 20/03/2018.
 */

public interface BasePresenter<V> {
    void attachView(V view);

    void detachView();
}
