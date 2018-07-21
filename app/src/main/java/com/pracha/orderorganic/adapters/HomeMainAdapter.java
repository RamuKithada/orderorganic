package com.pracha.orderorganic.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.home.Banners1;
import com.pracha.orderorganic.models.home.HomePageDetails;
import com.pracha.orderorganic.utils.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMainAdapter extends RecyclerView.Adapter<HomeMainAdapter.MyViewHolder> {

    private Context context;
    private HomePageDetails homePageDetails;

    public HomeMainAdapter(Context context, HomePageDetails homePageDetails) {
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
            holder.viewPager.setAdapter(new BannerAdapter((ArrayList<Banners1>) homePageDetails.getBanners1(), context));
            holder.circlePageIndicator.setViewPager(holder.viewPager);
        }
        if(homePageDetails.getCategorylist().size()>0) {
            String category_image_path = homePageDetails.getCategoryimage();
            holder.category_recycler.setHasFixedSize(true);
            holder.category_recycler.setNestedScrollingEnabled(false);
            holder.category_recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.category_recycler.setAdapter(new CategoryListAdapter(context,homePageDetails.getCategorylist(), category_image_path));
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.category_recycler)
        RecyclerView category_recycler;
        @BindView(R.id.pager)
        ViewPager viewPager;
        @BindView(R.id.indicator)
        CirclePageIndicator circlePageIndicator;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
