package com.pracha.orderorganic.presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.pracha.orderorganic.apis.MyService;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.home.HomePageDetails;
import com.pracha.orderorganic.views.HomeDetailsView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class HomeDetailsPresenter implements BasePresenter<HomeDetailsView> {

    private Subscription subscription;

    private HomePageDetails homePageDetails;

    private HomeDetailsView homeDetailsView;

    @Override
    public void attachView(HomeDetailsView view) {
        this.homeDetailsView = view;
    }

    @Override
    public void detachView() {
        homeDetailsView = null;
        if (subscription!=null)
            subscription.unsubscribe();
    }


    public void getHomeDetails(){

        MyApplication myApplication = MyApplication.get(homeDetailsView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getHomePageDetails()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<HomePageDetails>() {
                    @Override
                    public void onCompleted() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                homeDetailsView.showProgressIndicator(false);
                                homeDetailsView.getHomeDetails(homePageDetails);
                            }
                        }).run();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("HomeErrords", "" + e.getMessage());
                        homeDetailsView.showProgressIndicator(false);
                    }

                    @Override
                    public void onNext(final HomePageDetails homePageDetails) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String res = new Gson().toJson(homePageDetails);
                                Log.e("homeresponse",""+res);
                                HomeDetailsPresenter.this.homePageDetails = homePageDetails;
                            }
                        }).run();

                    }
                });
    }
}
