package com.pracha.orderorganic.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.adapters.TopOfferAdapter;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.home.HomePageDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends BaseFragment {

    @BindView(R.id.offers_recycler)
    RecyclerView offers_recycler;
    private HomePageDetails homePageDetails;

    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offers, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null)
            getActivity().setTitle("Top Offers");
        MyApplication myApplication = MyApplication.get(MyApplication.getContextOfApplication());
        homePageDetails = myApplication.getHomePageDetails();

        offers_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        offers_recycler.setAdapter(new TopOfferAdapter(getActivity(),homePageDetails.getTopoffer(),
                homePageDetails.getImagepath(),homePageDetails.getTopoffer().size()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
