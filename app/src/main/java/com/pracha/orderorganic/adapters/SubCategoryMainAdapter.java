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
import com.pracha.orderorganic.models.models.subcategory.SubCategoryDetails;
import com.pracha.orderorganic.utils.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryMainAdapter extends RecyclerView.Adapter<SubCategoryMainAdapter.MyViewHolder> {

    private Activity activity;
    private SubCategoryDetails subCategoryDetails;

    public SubCategoryMainAdapter(Activity activity, SubCategoryDetails subCategoryDetails) {
        this.activity = activity;
        this.subCategoryDetails = subCategoryDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category_main_list_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            String imagepath = subCategoryDetails.getImagepath();
            String sub_category_image_path = subCategoryDetails.getSubcategoryimage();
            if(subCategoryDetails.getSubcategory()!=null) {
                if (subCategoryDetails.getSubcategory().size() > 0) {
                    holder.sub_category_recycler.setHasFixedSize(true);
                    holder.sub_category_recycler.setNestedScrollingEnabled(false);
                    holder.sub_category_recycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                    holder.sub_category_recycler.setAdapter(new SubCategoryAdapter(activity, subCategoryDetails.getSubcategory(), sub_category_image_path));
                }
            }
            if(subCategoryDetails.getMostviewed()!=null) {
                if (subCategoryDetails.getMostviewed().size() > 0) {
                    holder.mostviewed_layout.setVisibility(View.VISIBLE);
                    holder.mostviewed_recycler.setHasFixedSize(true);
                    holder.mostviewed_recycler.setNestedScrollingEnabled(false);
                    holder.mostviewed_recycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                    holder.mostviewed_recycler.setAdapter(new ProductsListAdapter(activity, subCategoryDetails.getMostviewed(),
                            imagepath, subCategoryDetails.getMostviewed().size()));
                }
            }
            if(subCategoryDetails.getRecommended()!=null) {
                if (subCategoryDetails.getRecommended().size() > 0) {
                    holder.recommend_layout.setVisibility(View.VISIBLE);
                    holder.recommend_recycler.setHasFixedSize(true);
                    holder.recommend_recycler.setNestedScrollingEnabled(false);
                    holder.recommend_recycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                    holder.recommend_recycler.setAdapter(new ProductsListAdapter(activity, subCategoryDetails.getRecommended(),
                            imagepath, subCategoryDetails.getRecommended().size()));
                }
            }
            if(subCategoryDetails.getShopbyx()!=null){
                if(subCategoryDetails.getShopbyx().size()>0){
                    holder.shop_by_x_layout.setVisibility(View.VISIBLE);
                    if(subCategoryDetails.getShopbyxlabel()!=null){
                        holder.tvshopbyx_head.setText("Shop By "+subCategoryDetails.getShopbyxlabel());
                    } else {
                        holder.tvshopbyx_head.setVisibility(View.GONE);
                    }
                    holder.shop_by_x_recycler.setHasFixedSize(true);
                    holder.shop_by_x_recycler.setNestedScrollingEnabled(false);
                    holder.shop_by_x_recycler.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
                    holder.shop_by_x_recycler.setAdapter(new ProductsListAdapter(activity,subCategoryDetails.getShopbyx(),
                            imagepath,subCategoryDetails.getShopbyx().size()));
                }
            }
            if(subCategoryDetails.getShopbyy()!=null){
                if(subCategoryDetails.getShopbyy().size()>0){
                    holder.shop_by_y_layout.setVisibility(View.VISIBLE);
                    if(subCategoryDetails.getShopbyylabel()!=null){
                        holder.tvshopbyy_head.setText("Shop By "+subCategoryDetails.getShopbyylabel());
                    } else {
                        holder.tvshopbyy_head.setVisibility(View.GONE);
                    }
                    holder.shop_by_y_recycler.setHasFixedSize(true);
                    holder.shop_by_y_recycler.setNestedScrollingEnabled(false);
                    holder.shop_by_y_recycler.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
                    holder.shop_by_y_recycler.setAdapter(new ProductsListAdapter(activity,subCategoryDetails.getShopbyy(),
                            imagepath,subCategoryDetails.getShopbyy().size()));
                }
            }

            if(subCategoryDetails.getShopbyz()!=null){
                if(subCategoryDetails.getShopbyz().size()>0){
                    holder.shop_by_z_layout.setVisibility(View.VISIBLE);
                    if(subCategoryDetails.getShopbyzlable()!=null){
                        holder.tvshopbyz_head.setText("Shop By "+subCategoryDetails.getShopbyzlable());
                    } else {
                        holder.tvshopbyz_head.setVisibility(View.GONE);
                    }
                    holder.shop_by_z_recycler.setHasFixedSize(true);
                    holder.shop_by_z_recycler.setNestedScrollingEnabled(false);
                    holder.shop_by_z_recycler.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
                    holder.shop_by_z_recycler.setAdapter(new ProductsListAdapter(activity,subCategoryDetails.getShopbyz(),
                            imagepath,subCategoryDetails.getShopbyz().size()));
                }
            }
            if(subCategoryDetails.getTopbrands()!=null){
                if(subCategoryDetails.getTopbrands().size()>0){
                    holder.top_brand_layout.setVisibility(View.VISIBLE);
                    holder.top_brand_recycler.setHasFixedSize(true);
                    holder.top_brand_recycler.setNestedScrollingEnabled(false);
                    holder.top_brand_recycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                    holder.top_brand_recycler.setAdapter(new TopBrandAdapter(activity, subCategoryDetails.getTopbrands(),
                            imagepath));
                }
            }
            if(subCategoryDetails.getSubitems()!=null){
                if(subCategoryDetails.getSubitems().size()>0){
                    holder.sub_items_layout.setVisibility(View.VISIBLE);
                    holder.sub_items_recycler.setHasFixedSize(true);
                    holder.sub_items_recycler.setNestedScrollingEnabled(false);
                    holder.sub_items_recycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                    holder.sub_items_recycler.setAdapter(new SubItemsAdapter(activity, subCategoryDetails.getSubitems(),
                            imagepath));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sub_category_recycler)
        RecyclerView sub_category_recycler;

        @BindView(R.id.banner1_layout)
        RelativeLayout banner1_layout;
        @BindView(R.id.banner1_pager)
        ViewPager viewPager;
        @BindView(R.id.banner1_indicator)
        CirclePageIndicator circlePageIndicator;

        @BindView(R.id.top_brand_layout)
        RelativeLayout top_brand_layout;
        @BindView(R.id.tvtopbrands_head)
        TextView tvtopbrands_head;
        @BindView(R.id.top_brand_recycler)
        RecyclerView top_brand_recycler;

        @BindView(R.id.banner2_layout)
        RelativeLayout banner2_layout;
        @BindView(R.id.banner2_pager)
        ViewPager banner2_pager;
        @BindView(R.id.banner2_indicator)
        CirclePageIndicator banner2_indicator;

        @BindView(R.id.shop_by_price_layout)
        RelativeLayout shop_by_price_layout;
        @BindView(R.id.tvshopbyprice_head)
        TextView tvshopbyprice_head;
        @BindView(R.id.shop_by_price_recycler)
        RecyclerView shop_by_price_recycler;

        @BindView(R.id.shop_by_x_layout)
        RelativeLayout shop_by_x_layout;
        @BindView(R.id.tvshopbyx_head)
        TextView tvshopbyx_head;
        @BindView(R.id.shop_by_x_recycler)
        RecyclerView shop_by_x_recycler;

        @BindView(R.id.banner3_layout)
        RelativeLayout banner3_layout;
        @BindView(R.id.banner3_pager)
        ViewPager banner3_pager;
        @BindView(R.id.banner3_indicator)
        CirclePageIndicator banner3_indicator;

        @BindView(R.id.sub_items_layout)
        RelativeLayout sub_items_layout;
        @BindView(R.id.tvsub_items_head)
        TextView tvsub_items_head;
        @BindView(R.id.sub_items_recycler)
        RecyclerView sub_items_recycler;

        @BindView(R.id.shop_by_y_layout)
        RelativeLayout shop_by_y_layout;
        @BindView(R.id.tvshopbyy_head)
        TextView tvshopbyy_head;
        @BindView(R.id.shop_by_y_recycler)
        RecyclerView shop_by_y_recycler;

        @BindView(R.id.shop_by_z_layout)
        RelativeLayout shop_by_z_layout;
        @BindView(R.id.tvshopbyz_head)
        TextView tvshopbyz_head;
        @BindView(R.id.shop_by_z_recycler)
        RecyclerView shop_by_z_recycler;

        @BindView(R.id.banner4_layout)
        RelativeLayout banner4_layout;
        @BindView(R.id.banner4_pager)
        ViewPager banner4_pager;
        @BindView(R.id.banner4_indicator)
        CirclePageIndicator banner4_indicator;

        @BindView(R.id.mostviewed_layout)
        RelativeLayout mostviewed_layout;
        @BindView(R.id.tvmostviewed_head)
        TextView tvmostviewed_head;
        @BindView(R.id.mostviewed_recycler)
        RecyclerView mostviewed_recycler;

        @BindView(R.id.recommend_layout)
        RelativeLayout recommend_layout;
        @BindView(R.id.tvrecommend_head)
        TextView tvrecommend_head;
        @BindView(R.id.recommend_recycler)
        RecyclerView recommend_recycler;

        @BindView(R.id.banner5_layout)
        RelativeLayout banner5_layout;
        @BindView(R.id.banner5_pager)
        ViewPager banner5_pager;
        @BindView(R.id.banner5_indicator)
        CirclePageIndicator banner5_indicator;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
