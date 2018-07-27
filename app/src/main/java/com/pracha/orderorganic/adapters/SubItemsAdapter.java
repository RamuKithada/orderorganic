package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.subcategory.Subitem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubItemsAdapter extends RecyclerView.Adapter<SubItemsAdapter.MyViewHolder> {

    private Activity activity;
    private List<Subitem> subitemList;
    private String imagepath;

    public SubItemsAdapter(Activity activity, List<Subitem> subitemList, String imagepath) {
        this.activity = activity;
        this.subitemList = subitemList;
        this.imagepath = imagepath;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Subitem subitem = subitemList.get(position);
        try {
            holder.tv_title.setText(subitem.getSubitemName());
            holder.tv_discount.setVisibility(View.GONE);
            if (subitem.getImage() != null) {
                Glide.with(activity)
                        .load(imagepath + subitem.getImage())
                        .placeholder(R.drawable.background)
                        .into(holder.item_image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return subitemList.size();
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
            ButterKnife.bind(this,itemView);
        }
    }
}
