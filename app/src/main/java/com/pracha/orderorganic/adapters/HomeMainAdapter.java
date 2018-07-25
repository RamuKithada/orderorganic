package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.home.Banners1;
import com.pracha.orderorganic.models.models.home.HomePageDetails;
import com.pracha.orderorganic.utils.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMainAdapter extends RecyclerView.Adapter<HomeMainAdapter.MyViewHolder> {

    private Activity context;
    private HomePageDetails homePageDetails;

    public HomeMainAdapter(Activity context, HomePageDetails homePageDetails) {
        this.context = context;
        this.homePageDetails = homePageDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (homePageDetails.getBanners1().size() > 0) {
            String banner1_image_path = homePageDetails.getBanners1path();
            holder.viewPager.setAdapter(new BannerAdapter(homePageDetails.getBanners1(), context,banner1_image_path));
            holder.circlePageIndicator.setViewPager(holder.viewPager);
        }
        if (homePageDetails.getCategorylist().size() > 0) {
            String category_image_path = homePageDetails.getCategoryimage();
            holder.category_recycler.setHasFixedSize(true);
            holder.category_recycler.setNestedScrollingEnabled(false);
            holder.category_recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.category_recycler.setAdapter(new CategoryListAdapter(context, homePageDetails.getCategorylist(), category_image_path));
        }
        int top_list_size = homePageDetails.getTopoffer().size();
        if (top_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.top_offers_layout.setVisibility(View.VISIBLE);
            holder.top_offer_recycler.setHasFixedSize(true);
            holder.top_offer_recycler.setNestedScrollingEnabled(false);
            holder.top_offer_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.top_offer_recycler.setAdapter(new TopOfferAdapter(context, homePageDetails.getTopoffer(), category_image_path, 4));
        } else if (top_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.top_offers_layout.setVisibility(View.VISIBLE);
            holder.top_offer_recycler.setHasFixedSize(true);
            holder.top_offer_recycler.setNestedScrollingEnabled(false);
            holder.top_offer_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.top_offer_recycler.setAdapter(new TopOfferAdapter(context, homePageDetails.getTopoffer(), category_image_path, top_list_size));
        }
        int trend_list_size = homePageDetails.getTrendingproducts().size();
        if (trend_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.trend_offers_layout.setVisibility(View.VISIBLE);
            holder.trend_offer_recycler.setHasFixedSize(true);
            holder.trend_offer_recycler.setNestedScrollingEnabled(false);
            holder.trend_offer_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.trend_offer_recycler.setAdapter(new TrendingProductsAdapter(context, homePageDetails.getTrendingproducts(), category_image_path, 4));
        } else if (trend_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.trend_offers_layout.setVisibility(View.VISIBLE);
            holder.trend_offer_recycler.setHasFixedSize(true);
            holder.trend_offer_recycler.setNestedScrollingEnabled(false);
            holder.trend_offer_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.trend_offer_recycler.setAdapter(new TrendingProductsAdapter(context, homePageDetails.getTrendingproducts(), category_image_path, trend_list_size));
        }
        int offer_you_list_size = homePageDetails.getOffersforyou().size();
        if (offer_you_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.offers_for_you_layout.setVisibility(View.VISIBLE);
            holder.offers_for_you_recycler.setHasFixedSize(true);
            holder.offers_for_you_recycler.setNestedScrollingEnabled(false);
            holder.offers_for_you_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.offers_for_you_recycler.setAdapter(new OffersForYouAdapter(context, homePageDetails.getOffersforyou(), category_image_path, 4));
        } else if (offer_you_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.offers_for_you_layout.setVisibility(View.VISIBLE);
            holder.offers_for_you_recycler.setHasFixedSize(true);
            holder.offers_for_you_recycler.setNestedScrollingEnabled(false);
            holder.offers_for_you_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.offers_for_you_recycler.setAdapter(new OffersForYouAdapter(context, homePageDetails.getOffersforyou(), category_image_path, offer_you_list_size));
        }
        int deals_list_size = homePageDetails.getDealsoftheday().size();
        if (deals_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.deals_of_day_layout.setVisibility(View.VISIBLE);
            holder.deals_of_day_recycler.setHasFixedSize(true);
            holder.deals_of_day_recycler.setNestedScrollingEnabled(false);
            holder.deals_of_day_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.deals_of_day_recycler.setAdapter(new DealsOfDayAdapter(context, homePageDetails.getDealsoftheday(), category_image_path, 4));
        } else if (deals_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.deals_of_day_layout.setVisibility(View.VISIBLE);
            holder.deals_of_day_recycler.setHasFixedSize(true);
            holder.deals_of_day_recycler.setNestedScrollingEnabled(false);
            holder.deals_of_day_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.deals_of_day_recycler.setAdapter(new DealsOfDayAdapter(context, homePageDetails.getDealsoftheday(), category_image_path, deals_list_size));
        }
        int season_list_size = homePageDetails.getSeasonsales().size();
        if (season_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.season_sale_layout.setVisibility(View.VISIBLE);
            holder.season_sale_recycler.setHasFixedSize(true);
            holder.season_sale_recycler.setNestedScrollingEnabled(false);
            holder.season_sale_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.season_sale_recycler.setAdapter(new SeasonSaleAdapter(context, homePageDetails.getSeasonsales(), category_image_path, 4));
        } else if (season_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.season_sale_layout.setVisibility(View.VISIBLE);
            holder.season_sale_recycler.setHasFixedSize(true);
            holder.season_sale_recycler.setNestedScrollingEnabled(false);
            holder.season_sale_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.season_sale_recycler.setAdapter(new SeasonSaleAdapter(context, homePageDetails.getSeasonsales(), category_image_path, season_list_size));
        }
        int recently_list_size = homePageDetails.getRecentlyviewed().size();
        if (recently_list_size > 4) {
            String category_image_path = homePageDetails.getImagepath();
            holder.recently_viewed_layout.setVisibility(View.VISIBLE);
            holder.recently_viewed_recycler.setHasFixedSize(true);
            holder.recently_viewed_recycler.setNestedScrollingEnabled(false);
            holder.recently_viewed_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.recently_viewed_recycler.setAdapter(new RecentlyViewedAdapter(context, homePageDetails.getRecentlyviewed(), category_image_path, 4));
        } else if (recently_list_size > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.recently_viewed_layout.setVisibility(View.VISIBLE);
            holder.recently_viewed_recycler.setHasFixedSize(true);
            holder.recently_viewed_recycler.setNestedScrollingEnabled(false);
            holder.recently_viewed_recycler.setLayoutManager(new GridLayoutManager(context, 2));
            holder.recently_viewed_recycler.setAdapter(new RecentlyViewedAdapter(context, homePageDetails.getRecentlyviewed(), category_image_path, recently_list_size));
        }
        if (homePageDetails.getCategorywiseproductlist().size() > 0) {
            String category_image_path = homePageDetails.getImagepath();
            holder.category_wise_products_recycler.setHasFixedSize(true);
            holder.category_wise_products_recycler.setNestedScrollingEnabled(false);
            holder.category_wise_products_recycler.setLayoutManager(new LinearLayoutManager(context));
            holder.category_wise_products_recycler.setAdapter(new CategoryWiseProductsAdapter(context, homePageDetails.getCategorywiseproductlist(), category_image_path));
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner1_layout)
        RelativeLayout banner1_layout;
        @BindView(R.id.banner1_pager)
        ViewPager viewPager;
        @BindView(R.id.banner1_indicator)
        CirclePageIndicator circlePageIndicator;

        @BindView(R.id.category_recycler)
        RecyclerView category_recycler;

        @BindView(R.id.top_offers_layout)
        RelativeLayout top_offers_layout;
        @BindView(R.id.tvtop_offer_view_more)
        TextView tvtop_offfer_view_more;
        @BindView(R.id.top_offer_recycler)
        RecyclerView top_offer_recycler;

        @BindView(R.id.banner2_layout)
        RelativeLayout banner2_layout;
        @BindView(R.id.banner2_pager)
        ViewPager banner2_pager;
        @BindView(R.id.banner2_indicator)
        CirclePageIndicator banner2_indicator;

        @BindView(R.id.trend_offers_layout)
        RelativeLayout trend_offers_layout;
        @BindView(R.id.tvtrend_offer_view_more)
        TextView tvtrend_offer_view_more;
        @BindView(R.id.trend_offer_recycler)
        RecyclerView trend_offer_recycler;

        @BindView(R.id.offers_for_you_layout)
        RelativeLayout offers_for_you_layout;
        @BindView(R.id.tvoffer_you_view_more)
        TextView tvoffer_you_view_more;
        @BindView(R.id.offers_for_you_recycler)
        RecyclerView offers_for_you_recycler;

        @BindView(R.id.banner3_layout)
        RelativeLayout banner3_layout;
        @BindView(R.id.banner3_pager)
        ViewPager banner3_pager;
        @BindView(R.id.banner3_indicator)
        CirclePageIndicator banner3_indicator;

        @BindView(R.id.deals_of_day_layout)
        RelativeLayout deals_of_day_layout;
        @BindView(R.id.tvdeals_of_day_view_more)
        TextView tvdeals_of_day_view_more;
        @BindView(R.id.deals_of_day_recycler)
        RecyclerView deals_of_day_recycler;

        @BindView(R.id.season_sale_layout)
        RelativeLayout season_sale_layout;
        @BindView(R.id.tvseason_sale_view_more)
        TextView tvseason_sale_view_more;
        @BindView(R.id.season_sale_recycler)
        RecyclerView season_sale_recycler;

        @BindView(R.id.banner4_layout)
        RelativeLayout banner4_layout;
        @BindView(R.id.banner4_pager)
        ViewPager banner4_pager;
        @BindView(R.id.banner4_indicator)
        CirclePageIndicator banner4_indicator;

        @BindView(R.id.recently_viewed_layout)
        RelativeLayout recently_viewed_layout;
        @BindView(R.id.tvrecently_viewed_view_more)
        TextView tvrecently_viewed_view_more;
        @BindView(R.id.recently_viewed_recycler)
        RecyclerView recently_viewed_recycler;

        @BindView(R.id.category_wise_products_recycler)
        RecyclerView category_wise_products_recycler;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
