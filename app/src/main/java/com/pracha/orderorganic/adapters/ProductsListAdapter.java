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
import com.pracha.orderorganic.models.models.home.ProductList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.MyViewHolder> {

    private Activity activity;
    private List<ProductList> productLists;
    private String category_image_path;
    private int size;

    public ProductsListAdapter(Activity activity, List<ProductList> productLists, String category_image_path, int size) {
        this.activity = activity;
        this.productLists = productLists;
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
        ProductList productList = productLists.get(position);
        try {
            int MAX_WIDTH = getScreenWidth()/2;
            holder.price_layout.setVisibility(View.VISIBLE);
            holder.tv_title.setText(productList.getItemName());
            holder.tvOffPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvOffPrice.setText(activity.getString(R.string.Rs)+productList.getItemCost());
            holder.tvPrice.setText(activity.getString(R.string.Rs)+productList.getSpecialPrice());
            //removing strike through
//            tv.setPaintFlags(tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            holder.tv_discount.setText("Min " + productList.getPercentage()+"% Off");
            holder.tv_discount.setTextColor(Color.parseColor("#36DD31"));
            if(productList.getItemImage()!=null){
                Glide.with(activity)
                        .load(category_image_path+productList.getItemImage())
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
