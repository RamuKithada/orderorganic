package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.subcategory.Subcategory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private Activity activity;
    private List<Subcategory> subcategoryList;
    private String sub_cate_path;

    public SubCategoryAdapter(Activity activity, List<Subcategory> subcategoryList, String sub_cate_path) {
        this.activity = activity;
        this.subcategoryList = subcategoryList;
        this.sub_cate_path = sub_cate_path;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Subcategory subcategory = subcategoryList.get(position);
        try {
            holder.item_title.setText(subcategory.getSubcategoryName());
            if (subcategory.getSubcategoryImage() != null) {
                Glide.with(activity)
                        .load(sub_cate_path + subcategory.getSubcategoryImage())
                        .placeholder(R.drawable.background)
                        .into(holder.item_image);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("categoryerror", "" + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return subcategoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemImage)
        ImageView item_image;
        @BindView(R.id.tvTitle)
        TextView item_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
