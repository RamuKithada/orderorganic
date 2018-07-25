package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.home.Seasonsale;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeasonSaleAdapter extends RecyclerView.Adapter<SeasonSaleAdapter.MyViewHolder> {

    private Activity context;
    private List<Seasonsale> seasonsaleList;
    private String category_image_path;
    private int size;

    public SeasonSaleAdapter(Activity context, List<Seasonsale> seasonsaleList, String category_image_path, int size) {
        this.context = context;
        this.seasonsaleList = seasonsaleList;
        this.category_image_path = category_image_path;
        this.size =size;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Seasonsale seasonsale = seasonsaleList.get(position);
        try {
            int MAX_WIDTH = getScreenWidth()/2;
            holder.tv_title.setText(seasonsale.getCategoryName());
            holder.tv_discount.setText("Min " + seasonsale.getOfferPercentage()+"% Off");
            if(seasonsale.getItemImage()!=null){
                Glide.with(context)
                        .load(category_image_path+seasonsale.getItemImage())
                        .placeholder(R.drawable.background)
                        .into(holder.item_image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }

    private int getScreenWidth() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemImage)
        ImageView item_image;
        @BindView(R.id.tvTitle)
        TextView tv_title;
        @BindView(R.id.tvDiscount)
        TextView tv_discount;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
