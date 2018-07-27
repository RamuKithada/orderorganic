package com.pracha.orderorganic.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.adapters.CategoryWiseProductsAdapter;
import com.pracha.orderorganic.adapters.DealsOfDayAdapter;
import com.pracha.orderorganic.adapters.HomeMainAdapter;
import com.pracha.orderorganic.adapters.OffersForYouAdapter;
import com.pracha.orderorganic.adapters.ProductsListAdapter;
import com.pracha.orderorganic.adapters.RecentlyViewedAdapter;
import com.pracha.orderorganic.adapters.SeasonSaleAdapter;
import com.pracha.orderorganic.adapters.TopOfferAdapter;
import com.pracha.orderorganic.adapters.TrendingProductsAdapter;
import com.pracha.orderorganic.database.MyApplication;
import com.pracha.orderorganic.models.models.home.HomePageDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeeMoreActivity extends BaseActivity {

    @BindView(R.id.see_more_recycler)
    RecyclerView see_more_recycler;
    String imagepath;
    int size;
    String list_type;
    HomePageDetails homePageDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("onCreate","onCreateCall");
        setContentView(R.layout.activity_see_more);
        ButterKnife.bind(this);
        see_more_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        MyApplication myApplication = MyApplication.get(getApplicationContext());
        homePageDetails = myApplication.getHomePageDetails();
        list_type = getIntent().getStringExtra("list_type");
        imagepath = getIntent().getStringExtra("imagepath");
        size = getIntent().getIntExtra("size", 0);
        switch (list_type) {
            case HomeMainAdapter.TOP_OFFERS:
                setUpToolBar("Top Offers", true);
                see_more_recycler.setAdapter(new TopOfferAdapter(this, homePageDetails.getTopoffer(), imagepath, size));
                Log.e(HomeMainAdapter.TOP_OFFERS, "" + size);
                break;
            case HomeMainAdapter.TRENDING_PRODUCTS:
                setUpToolBar("Trending Products", true);
                see_more_recycler.setAdapter(new TrendingProductsAdapter(this, homePageDetails.getTrendingproducts(), imagepath, size));
                Log.e(HomeMainAdapter.TRENDING_PRODUCTS, "" + size);
                break;
            case HomeMainAdapter.OFFERS_FOR_YOU:
                setUpToolBar("Offer For You", true);
                see_more_recycler.setAdapter(new OffersForYouAdapter(this, homePageDetails.getOffersforyou(), imagepath, size));
                Log.e(HomeMainAdapter.OFFERS_FOR_YOU, "" + size);
                break;
            case HomeMainAdapter.DEALS_OF_THE_DAY:
                setUpToolBar("Deals Of The Day", true);
                see_more_recycler.setAdapter(new DealsOfDayAdapter(this, homePageDetails.getDealsoftheday(), imagepath, size));
                Log.e(HomeMainAdapter.DEALS_OF_THE_DAY, "" + size);
                break;
            case HomeMainAdapter.SEASON_SALE:
                setUpToolBar("Season Sales", true);
                Log.e(HomeMainAdapter.SEASON_SALE, "" + size);
                see_more_recycler.setAdapter(new SeasonSaleAdapter(this, homePageDetails.getSeasonsales(), imagepath, size));
                break;
            case HomeMainAdapter.RECENTLY_VIEWED:
                setUpToolBar("Recently Viewed", true);
                see_more_recycler.setAdapter(new RecentlyViewedAdapter(this, homePageDetails.getRecentlyviewed(), imagepath, size));
                Log.e(HomeMainAdapter.RECENTLY_VIEWED, "" + size);
                break;
            case CategoryWiseProductsAdapter.CATEGORY_WISE_PRODUCT_LIST:
                String category_name = getIntent().getStringExtra("category_name");
                int position = getIntent().getIntExtra("position", 0);
//                productListList = getIntent().getParcelableArrayListExtra(CategoryWiseProductsAdapter.CATEGORY_WISE_PRODUCT_LIST);
                setUpToolBar(category_name, true);
                Log.e(category_name, "" + homePageDetails.getCategorywiseproductlist().get(position).getPlist().size() + "position" + position);
                see_more_recycler.setAdapter(new ProductsListAdapter(this, homePageDetails.getCategorywiseproductlist().get(position).getPlist(), imagepath, size));
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("onResume","onResumeCall");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart","onStartCall");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPauses","onPauseCall");
    }
}
