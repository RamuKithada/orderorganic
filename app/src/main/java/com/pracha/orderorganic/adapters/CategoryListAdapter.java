package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.pracha.orderorganic.activity.SubCategoryActivity;
import com.pracha.orderorganic.models.models.home.Categorylist;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {

    private Activity context;
    private List<Categorylist> categorylists;
    private String category_image_path;

    public CategoryListAdapter(Activity context, List<Categorylist> categorylists, String category_image_path) {
        this.context = context;
        this.categorylists = categorylists;
        this.category_image_path = category_image_path;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Categorylist categorylist = categorylists.get(position);
        try {
            holder.item_title.setText(categorylist.getCategoryName());
            if (categorylist.getCategoryImage() != null) {
                Glide.with(context)
                        .load(category_image_path + categorylist.getCategoryImage())
                        .placeholder(R.drawable.background)
                        .into(holder.item_image);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SubCategoryActivity.class);
                    String cat_id = categorylist.getCategoryId();
                    intent.putExtra("cat_id",cat_id);
                    intent.putExtra("cat_name",categorylist.getCategoryName());
                    context.startActivity(intent);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("categoryerror", "" + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return categorylists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemImage)
        ImageView item_image;
        @BindView(R.id.tvTitle)
        TextView item_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
