package com.pracha.orderorganic.presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.pracha.orderorganic.apis.MyService;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.login.ForResetResponse;
import com.pracha.orderorganic.models.models.login.LoginSuccess;
import com.pracha.orderorganic.views.LoginView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class LoginDetailsPresenter implements BasePresenter<LoginView> {

    private Subscription subscription;
    private LoginView loginView;
    private LoginSuccess loginSuccess;
    private ForResetResponse forResetResponse;

    @Override
    public void attachView(LoginView view) {
        this.loginView = view;
    }

    @Override
    public void detachView() {
        loginView = null;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void getForgotPassword(String username) {
        MyApplication myApplication = MyApplication.get(loginView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getForgotPassword(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<ForResetResponse>() {
                    @Override
                    public void onCompleted() {
                        loginView.showProgressIndicator(false);
                        if (forResetResponse != null)
                            loginView.forgotPasswordDetails(forResetResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("forgotpasserror", "" + e.getMessage());
                        loginView.showProgressIndicator(false);
                        loginView.showMessage("please try again..");
                    }

                    @Override
                    public void onNext(ForResetResponse forResetResponse) {
                        String res = new Gson().toJson(forResetResponse);
                        Log.e("forgotresponse", "" + res);
                        LoginDetailsPresenter.this.forResetResponse = forResetResponse;
                    }
                });
    }

    public void getResetPassword(String cust_id,String otp,String password){
        MyApplication myApplication = MyApplication.get(loginView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getResetPassword(cust_id,otp,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<ForResetResponse>() {
                    @Override
                    public void onCompleted() {
                        loginView.showProgressIndicator(false);
                        if (forResetResponse != null)
                            loginView.resetPasswordDetails(forResetResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("resetpasserror", "" + e.getMessage());
                        loginView.showProgressIndicator(false);
                        loginView.showMessage("please try again..");
                    }

                    @Override
                    public void onNext(ForResetResponse forResetResponse) {
                        String res = new Gson().toJson(forResetResponse);
                        Log.e("forgotresponse", "" + res);
                        LoginDetailsPresenter.this.forResetResponse = forResetResponse;
                    }
                });
    }

    public void getRegistrationDetails(String username, String password) {
        MyApplication myApplication = MyApplication.get(loginView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getRegistrationDetails(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<LoginSuccess>() {
                    @Override
                    public void onCompleted() {
                        loginView.showProgressIndicator(false);
                        if (loginSuccess != null)
                            loginView.registrationDetails(loginSuccess);
                        else
                            loginView.showMessage("Invalid Registration Details");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("registererror", "" + e.getMessage());
                        loginView.showProgressIndicator(false);
                        loginView.showMessage("please try again.....");
                    }

                    @Override
                    public void onNext(LoginSuccess loginSuccess) {
                        String res = new Gson().toJson(loginSuccess);
                        Log.e("loginresponse", "" + res);
                        LoginDetailsPresenter.this.loginSuccess = loginSuccess;
                    }
                });
    }

    public void getLoginDetails(String username, String password) {
        MyApplication myApplication = MyApplication.get(loginView.getContext());
        MyService myService = myApplication.getCKService();

        subscription = myService.getLoginDetails(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .subscribe(new Subscriber<LoginSuccess>() {
                    @Override
                    public void onCompleted() {
                        loginView.showProgressIndicator(false);
                        if (loginSuccess != null)
                            loginView.loginDetails(loginSuccess);
                        else
                            loginView.showMessage("Invalid Login Details");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("loginerror", "" + e.getMessage());
                        loginView.showProgressIndicator(false);
                        loginView.showMessage("Error while login please try again..");
                    }

                    @Override
                    public void onNext(LoginSuccess loginSuccess) {
                        String res = new Gson().toJson(loginSuccess);
                        Log.e("loginresponse", "" + res);
                        LoginDetailsPresenter.this.loginSuccess = loginSuccess;
                    }
                });
    }
}
