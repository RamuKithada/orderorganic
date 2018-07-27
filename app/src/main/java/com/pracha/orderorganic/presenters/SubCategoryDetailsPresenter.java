package com.pracha.orderorganic.presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.pracha.orderorganic.apis.MyService;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.subcategory.SubCategoryDetails;
import com.pracha.orderorganic.views.SubCategoryView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class SubCategoryDetailsPresenter implements BasePresenter<SubCategoryView> {

    private Subscription subscription;
    private SubCategoryView subCategoryView;
    private SubCategoryDetails subCategoryDetails;

    @Override
    public void attachView(SubCategoryView view) {
        this.subCategoryView = view;
    }

    @Override
    public void detachView() {
        subCategoryView = null;
        if(subscription!=null){
            subscription.unsubscribe();
        }
    }

    public void getSubCategoryDetails(String category_id){
        MyApplication myApplication = MyApplication.get(subCategoryView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getSubcategoryDetails(category_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<SubCategoryDetails>() {
                    @Override
                    public void onCompleted() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                subCategoryView.showProgressIndicator(false);
                                subCategoryView.getSubCategoryDetails(subCategoryDetails);
                            }
                        }).run();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("subcategoryerror",e.getMessage());
                        subCategoryView.showProgressIndicator(false);
                    }

                    @Override
                    public void onNext(final SubCategoryDetails subCategoryDetails) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String res = new Gson().toJson(subCategoryDetails);
                                Log.e("subcategoryres",res);
                                SubCategoryDetailsPresenter.this.subCategoryDetails = subCategoryDetails;
                            }
                        }).run();

                    }
                });
    }
}
