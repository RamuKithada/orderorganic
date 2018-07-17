package com.pracha.orderorganic.database;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.pracha.orderorganic.apis.MyService;

import rx.Scheduler;
import rx.schedulers.Schedulers;


public class MyApplication extends Application {

    public static Context contextOfApplication;
    private static MyApplication mInstance;
    public MyService ckService;
    //    private Retrofit retrofit;
    private Scheduler defaultSubscribeScheduler;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

    /*@Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }*/

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        contextOfApplication = getApplicationContext();

        mInstance = this;

        try {
        /*AnalyticsTrackers.initialize(this);
        AnalyticsTrackers.getInstance().get(AnalyticsTrackers.Target.APP);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        MultiDex.install(this);
    }

    public MyService getCKService() {
//        if (ckService == null) {
        ckService = MyService.Factory.create(getContextOfApplication());
//        }
        return ckService;
    }

    //For setting mocks during testing
    public void setCCService(MyService ckService) {
        this.ckService = ckService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
