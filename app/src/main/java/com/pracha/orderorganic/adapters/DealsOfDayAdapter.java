package com.pracha.orderorganic.adapters;

import android.app.Activity;
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
import com.pracha.orderorganic.models.models.home.Dealsoftheday;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DealsOfDayAdapter extends RecyclerView.Adapter<DealsOfDayAdapter.MyViewHolder> {

    private Activity context;
    private List<Dealsoftheday> dealsofthedayList;
    private String category_image_path;
    private int size;

    public DealsOfDayAdapter(Activity context, List<Dealsoftheday> dealsofthedayList, String category_image_path, int size) {
        this.context = context;
        this.dealsofthedayList = dealsofthedayList;
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
        Dealsoftheday dealsoftheday = dealsofthedayList.get(position);
        try {
            int MAX_WIDTH = getScreenWidth()/2;
            holder.tv_title.setText(dealsoftheday.getCategoryName());
            holder.tv_discount.setText("Min " + dealsoftheday.getOffers()+"% Off");
            if(dealsoftheday.getItemImage()!=null){
                Glide.with(context)
                        .load(category_image_path+dealsoftheday.getItemImage())
                        .override(MAX_WIDTH,MAX_WIDTH)
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


    private int getScreenWidth() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }
}
