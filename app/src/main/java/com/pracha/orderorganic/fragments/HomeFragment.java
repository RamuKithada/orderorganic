package com.pracha.orderorganic.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.adapters.HomeMainAdapter;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.home.HomePageDetails;
import com.pracha.orderorganic.presenters.HomeDetailsPresenter;
import com.pracha.orderorganic.utils.ConnectionDetector;
import com.pracha.orderorganic.utils.Constants;
import com.pracha.orderorganic.utils.Utilities;
import com.pracha.orderorganic.views.HomeDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeDetailsView {

    private static int current_page = 0;
    HomeDetailsPresenter homeDetailsPresenter;
    /*@BindView(R.id.banner1_pager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CirclePageIndicator circlePageIndicator;
*/
    @BindView(R.id.home_main_recycler)
    RecyclerView home_main_recycler;


//    private ArrayList<Banners> banners1ArrayList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("onCreateView", "onCreateViewCall");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("onActivityCreated", "onActivityCreatedCall");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("onViewCreated", "onViewCreated");
        if(getActivity()!=null)
            getActivity().setTitle("Home");
        homeDetailsPresenter = new HomeDetailsPresenter();
        homeDetailsPresenter.attachView(this);

        if (ConnectionDetector.isConnectedToInternet(getActivity())) {
            showProgressIndicator(true);
            homeDetailsPresenter.getHomeDetails();
        } else {
            Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, getActivity());
        }

    }



    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId), getActivity());
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message, getActivity());
    }


    @Override
    public void getHomeDetails(final HomePageDetails homePageDetails) {
    /*    banners1ArrayList = (ArrayList<Banners>) homePageDetails.getBanners();
        viewPager.setAdapter(new BannerAdapter(banners1ArrayList, getActivity()));
        circlePageIndicator.setViewPager(viewPager);*/
        if (homePageDetails.getStatus() > 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MyApplication myApplication;
                    myApplication = MyApplication.get(MyApplication.getContextOfApplication());
                    myApplication.setHomePageDetails(homePageDetails);
                    home_main_recycler.setNestedScrollingEnabled(false);
                    home_main_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                    home_main_recycler.setAdapter(new HomeMainAdapter(getActivity(), homePageDetails));

                }
            }).run();
        }
        /*final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (current_page == banners1ArrayList.size()) {
                    current_page = 0;
                }
                viewPager.setCurrentItem(current_page++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3500, 3500);*/
    }
}
