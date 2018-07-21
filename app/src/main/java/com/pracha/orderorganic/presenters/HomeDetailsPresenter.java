package com.pracha.orderorganic.presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.pracha.orderorganic.apis.MyService;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.home.HomePageDetails;
import com.pracha.orderorganic.views.HomeDetailsView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class HomeDetailsPresenter implements BasePresenter<HomeDetailsView> {

    private Subscription subscription;

    private HomePageDetails homePageDetails;

    HomeDetailsView homeDetailsView;

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
                        homeDetailsView.showProgressIndicator(false);
                        homeDetailsView.getHomeDetails(homePageDetails);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error", "" + e.getMessage());

                        homeDetailsView.showProgressIndicator(false);
                    }

                    @Override
                    public void onNext(HomePageDetails homePageDetails) {
                        String res = new Gson().toJson(homePageDetails);
                        Log.e("homepageresponse",""+res);
                        HomeDetailsPresenter.this.homePageDetails = homePageDetails;
                    }
                });
    }
}
