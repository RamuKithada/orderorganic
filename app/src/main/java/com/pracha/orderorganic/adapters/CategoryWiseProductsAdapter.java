package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.activity.SeeMoreActivity;
import com.pracha.orderorganic.models.models.home.Categorywiseproductlist;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryWiseProductsAdapter extends RecyclerView.Adapter<CategoryWiseProductsAdapter.MyViewHolder> {

    public static final String CATEGORY_WISE_PRODUCT_LIST = "category_wise_product_list";
    private Activity activity;
    private List<Categorywiseproductlist> categorywiseproductlists;
    private String category_image_path;
    private int size;

    public CategoryWiseProductsAdapter(Activity activity, List<Categorywiseproductlist> categorywiseproductlists, String category_image_path) {
        this.activity = activity;
        this.categorywiseproductlists = categorywiseproductlists;
        this.category_image_path = category_image_path;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_wise_products_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Categorywiseproductlist categorywiseproductlist = categorywiseproductlists.get(position);
        try {
            final Intent intent = new Intent(activity, SeeMoreActivity.class);
            final String category_name = categorywiseproductlist.getCategoryName();
            holder.tvcategories_wise_products_head.setText(category_name);
            final int product_list_size = categorywiseproductlist.getPlist().size();
            if(product_list_size>4){
                holder.categories_wise_products_layout.setVisibility(View.VISIBLE);
                holder.categories_wise_products_recycler.setHasFixedSize(true);
                holder.categories_wise_products_recycler.setNestedScrollingEnabled(false);
                holder.categories_wise_products_recycler.setLayoutManager(new GridLayoutManager(activity, 2));
                holder.categories_wise_products_recycler.setAdapter(new ProductsListAdapter(activity, categorywiseproductlist.getPlist(), category_image_path, 4));
            }else if(product_list_size>0){
                holder.categories_wise_products_layout.setVisibility(View.VISIBLE);
                holder.categories_wise_products_recycler.setHasFixedSize(true);
                holder.categories_wise_products_recycler.setNestedScrollingEnabled(false);
                holder.categories_wise_products_recycler.setLayoutManager(new GridLayoutManager(activity, 2));
                holder.categories_wise_products_recycler.setAdapter(new ProductsListAdapter(activity, categorywiseproductlist.getPlist(), category_image_path, product_list_size));
            }
            holder.tvcategories_wise_products_view_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(product_list_size>0){
                        intent.putExtra("imagepath", category_image_path);
                        intent.putExtra("size", product_list_size);
                        intent.putExtra("list_type",CATEGORY_WISE_PRODUCT_LIST);
                        intent.putExtra("category_name",category_name);
                        intent.putExtra("position",position);
//                        intent.putParcelableArrayListExtra(CATEGORY_WISE_PRODUCT_LIST, (ArrayList<? extends Parcelable>) categorywiseproductlist.getPlist());
                        Log.e("category_size_adapter",""+product_list_size);
                        activity.startActivity(intent);
                    }else {
                        Toast.makeText(activity,"No more Items Available",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return categorywiseproductlists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.categories_wise_products_layout)
        RelativeLayout categories_wise_products_layout;
        @BindView(R.id.tvcategories_wise_products_view_more)
        TextView tvcategories_wise_products_view_more;
        @BindView(R.id.tvcategories_wise_products_head)
        TextView tvcategories_wise_products_head;
        @BindView(R.id.categories_wise_products_recycler)
        RecyclerView categories_wise_products_recycler;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
