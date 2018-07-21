package com.pracha.orderorganic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pracha.orderorganic.R;

public class CartActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setUpToolBar("Checkout",true);
    }
}
