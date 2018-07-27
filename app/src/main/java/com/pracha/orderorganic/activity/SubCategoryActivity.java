package com.pracha.orderorganic.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.adapters.SubCategoryMainAdapter;
import com.pracha.orderorganic.models.models.subcategory.SubCategoryDetails;
import com.pracha.orderorganic.presenters.SubCategoryDetailsPresenter;
import com.pracha.orderorganic.utils.ConnectionDetector;
import com.pracha.orderorganic.utils.Constants;
import com.pracha.orderorganic.utils.Utilities;
import com.pracha.orderorganic.views.SubCategoryView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryActivity extends BaseActivity implements SubCategoryView{

    SubCategoryDetailsPresenter subCategoryDetailsPresenter;
    @BindView(R.id.main_sub_category_recycler)
    RecyclerView main_sub_category_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        ButterKnife.bind(this);
        subCategoryDetailsPresenter = new SubCategoryDetailsPresenter();
        subCategoryDetailsPresenter.attachView(this);
        if(getIntent()!=null) {
            String cat_id = getIntent().getStringExtra("cat_id");
            String cat_name = getIntent().getStringExtra("cat_name");
            setUpToolBar(cat_name,true);
            Log.e("cat_id",cat_id);
            if (ConnectionDetector.isConnectedToInternet((this))) {
                showProgressIndicator(true);
                subCategoryDetailsPresenter.getSubCategoryDetails(cat_id);
            } else {
                Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, this);
            }
        }

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId),SubCategoryActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message,SubCategoryActivity.this);
    }

    @Override
    public void getSubCategoryDetails(final SubCategoryDetails subCategoryDetails) {
        if(subCategoryDetails.getStatus()>0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    main_sub_category_recycler.setNestedScrollingEnabled(false);
                    main_sub_category_recycler.setLayoutManager(new LinearLayoutManager(SubCategoryActivity.this));
                    main_sub_category_recycler.setAdapter(new SubCategoryMainAdapter(SubCategoryActivity.this,subCategoryDetails));
                }
            }).run();
        }
    }
}
