package com.pracha.orderorganic.presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.pracha.orderorganic.apis.MyService;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.sidemenu.HomeMenuList;
import com.pracha.orderorganic.views.MenuListView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MenuListPresenter implements BasePresenter<MenuListView> {

    private MenuListView menuListView;
    private Subscription subscription;
    private HomeMenuList homeMenuList;

    @Override
    public void attachView(MenuListView view) {
        this.menuListView = view;
    }

    @Override
    public void detachView() {
        menuListView = null;
        if (subscription != null)
            subscription.unsubscribe();
    }

    public void getMenuListDetails() {
        MyApplication myApplication = MyApplication.get(menuListView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getMenuListDetails()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<HomeMenuList>() {
                    @Override
                    public void onCompleted() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                menuListView.showProgressIndicator(false);
                                menuListView.getMenuListDetails(homeMenuList);

                            }
                        }).run();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("HomeMenuError", "" + e.getLocalizedMessage() + "" + e.getMessage());
                        menuListView.showProgressIndicator(false);
                    }

                    @Override
                    public void onNext(final HomeMenuList homeMenuList) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String res = new Gson().toJson(homeMenuList);
                                Log.e("homemenuresponse", "" + res);
                                MenuListPresenter.this.homeMenuList = homeMenuList;

                            }
                        }).run();
                    }
                });
    }
}
