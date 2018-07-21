package com.pracha.orderorganic.adapters;

import android.content.Context;
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
import com.pracha.orderorganic.models.home.Banners1;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    private ArrayList<Banners1> banners1ArrayList;
    private LayoutInflater layoutInflater;
    private Context context;

    public BannerAdapter(ArrayList<Banners1> banners1ArrayList, Context context) {
        this.banners1ArrayList = banners1ArrayList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return banners1ArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View bannerImage = layoutInflater.inflate(R.layout.sliding_image,container,false);
        assert bannerImage != null;
        final ImageView imageView = (ImageView) bannerImage
                .findViewById(R.id.image);
        Glide.with(context)
                .load("http://test.shofus.com/assets/appbanners/"+banners1ArrayList.get(position).getImg1())
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
