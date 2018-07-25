package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.home.Recentlyviewed;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.MyViewHolder> {

    private Activity activity;
    private List<Recentlyviewed> recentlyviewedList;
    private String category_image_path;
    private int size;

    public RecentlyViewedAdapter(Activity activity, List<Recentlyviewed> recentlyviewedList, String category_image_path, int size) {
        this.activity = activity;
        this.recentlyviewedList = recentlyviewedList;
        this.category_image_path = category_image_path;
        this.size = size;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Recentlyviewed recentlyviewed = recentlyviewedList.get(position);
        try {
            int MAX_WIDTH = getScreenWidth()/2;
            holder.price_layout.setVisibility(View.VISIBLE);
            holder.tv_title.setText(recentlyviewed.getItemName());
            holder.tvOffPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvOffPrice.setText(activity.getString(R.string.Rs)+recentlyviewed.getItemCost());
            holder.tvPrice.setText(activity.getString(R.string.Rs)+recentlyviewed.getSpecialPrice());
            //removing strike through
//            tv.setPaintFlags(tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            holder.tv_discount.setText("Min " + recentlyviewed.getOffers()+"% Off");
            holder.tv_discount.setTextColor(Color.parseColor("#36DD31"));
            if(recentlyviewed.getItemImage()!=null){
                Glide.with(activity)
                        .load(category_image_path+recentlyviewed.getItemImage())
                        .placeholder(R.drawable.background)
                        .into(holder.item_image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getScreenWidth() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }


    @Override
    public int getItemCount() {
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemImage)
        ImageView item_image;
        @BindView(R.id.tvTitle)
        TextView tv_title;
        @BindView(R.id.tvDiscount)
        TextView tv_discount;
        @BindView(R.id.price_layout)
        RelativeLayout price_layout;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvOffPrice)
        TextView tvOffPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
