package com.pracha.orderorganic.adapters;

import android.app.Activity;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.models.models.home.Banners;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private List<Banners> bannersArrayList;
    private LayoutInflater layoutInflater;
    private Activity context;
    private String banner1_image_path;

    public BannerAdapter(List<Banners> bannersArrayList, Activity context, String banner1_image_path) {
        this.bannersArrayList = bannersArrayList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.banner1_image_path = banner1_image_path;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return bannersArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View bannerImage = layoutInflater.inflate(R.layout.sliding_image,container,false);
        assert bannerImage != null;
        final ImageView imageView = (ImageView) bannerImage
                .findViewById(R.id.image);
        Glide.with(context)
                .load(banner1_image_path+ bannersArrayList.get(position).getImg1())
                .placeholder(R.drawable.background)
                .into(imageView);
        container.addView(bannerImage,0);
        return bannerImage;
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
