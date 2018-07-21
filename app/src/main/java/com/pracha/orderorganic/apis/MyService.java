package com.pracha.orderorganic.apis;

import android.content.Context;

import com.pracha.orderorganic.database.MySharedPreference;
import com.pracha.orderorganic.models.home.HomePageDetails;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by saif on 27-10-2017.
 */

public interface MyService {

    class Factory {
        public static MyService create(Context contextOfApplication) {

            // default time out is 15 seconds
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MYURL.PRODUCTION_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            return retrofit.create(MyService.class);
        }
    }

    @GET(MYURL.HOME_PAGE_API)
    Observable<HomePageDetails> getHomePageDetails();


}
