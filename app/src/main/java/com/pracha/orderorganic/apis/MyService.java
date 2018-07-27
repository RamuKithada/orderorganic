package com.pracha.orderorganic.apis;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pracha.orderorganic.models.models.home.HomePageDetails;
import com.pracha.orderorganic.models.models.login.ForResetResponse;
import com.pracha.orderorganic.models.models.login.LoginSuccess;
import com.pracha.orderorganic.models.models.sidemenu.HomeMenuList;
import com.pracha.orderorganic.models.models.subcategory.SubCategoryDetails;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
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

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MYURL.PRODUCTION_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            return retrofit.create(MyService.class);
        }
    }

    @GET(MYURL.HOME_PAGE_API)
    Observable<HomePageDetails> getHomePageDetails();

    @GET(MYURL.HOME_MENU_API)
    Observable<HomeMenuList> getMenuListDetails();

    @POST(MYURL.LOGIN_API)
    Observable<LoginSuccess> getLoginDetails(@Query("username") String username,@Query("password") String password);

    @POST(MYURL.REGISTER_API)
    Observable<LoginSuccess> getRegistrationDetails(@Query("username") String username,@Query("password") String password);

    @POST(MYURL.FORGOT_PASS_API)
    Observable<ForResetResponse> getForgotPassword(@Query("username") String username);

    @POST(MYURL.RESET_PASS_API)
    Observable<ForResetResponse> getResetPassword(@Query("customer_id") String cust_id,
                                                  @Query("otp") String otp,@Query("password") String password);

    @GET(MYURL.SUB_CATEGORY_API)
    Observable<SubCategoryDetails> getSubcategoryDetails(@Query("category_id") String category_id);
}
