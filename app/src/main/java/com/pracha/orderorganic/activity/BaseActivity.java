package com.pracha.orderorganic.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;


import com.pracha.orderorganic.R;

import dmax.dialog.SpotsDialog;

/**
 * Created by saif on 20/03/2018.
 */

public class BaseActivity extends AppCompatActivity {


    SpotsDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new SpotsDialog(BaseActivity.this);

    }


    public void setUpToolBar(String title, Boolean showHome) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            TextView titleView = toolbar.findViewById(R.id.toolbar_title);
            titleView.setText(title);
        }
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(showHome);
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setHomeAsUpIndicator(R.mipmap.back);
//                final Drawable upArrow = getResources().getDrawable(android.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//                upArrow.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void setUpToolBar(String title, Boolean showHome, int homeRes) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            TextView titleView = toolbar.findViewById(R.id.toolbar_title);
            titleView.setText(title);
        }
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(showHome);
                actionBar.setHomeAsUpIndicator(R.mipmap.back);
                actionBar.setDisplayShowTitleEnabled(false);


            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

 /*   @Override
    protected void onPause() {
        super.onPause();
        //  if (Build.VERSION.SDK_INT < 26) {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        //}el
    }*/

 /*   @Override
    public void onDestroy() {
        super.onDestroy();

        //   if (Build.VERSION.SDK_INT < 26) {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        //   }

    }*/

    @Override
    public void onResume() {
        super.onResume();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    /**
     * show or dismiss progress
     *
     * @param show show
     */
    public void showProgressIndicator(Boolean show) {
        try {

            //  if (Build.VERSION.SDK_INT < 26) {

            if (dialog != null) {

                if (show) {

                    dialog.show();
                } else {

                    dialog.dismiss();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * show with custom message
     *
     * @param show    show
     * @param message message to display
     */
    public void showProgressIndicator(Boolean show, String message) {

        //  if (Build.VERSION.SDK_INT < 26) {

       /* if (progressDialog != null) {
            progressDialog.setMessage(message);
            showProgressIndicator(show);
        }*/
        //  }
    }

    /**
     * show with cancelable
     *
     * @param show       show
     * @param cancelable cancelable
     */
    public void showProgressIndicator(Boolean show, Boolean cancelable) {

        // if (Build.VERSION.SDK_INT < 26) {
      /*  if (progressDialog != null) {
            progressDialog.setCancelable(cancelable);
            showProgressIndicator(show);
        }*/

        // }
    }

    /**
     * show with custom message and cancelable
     *
     * @param show       show
     * @param message    message
     * @param cancelable cancelable
     */
    public void showProgressIndicator(Boolean show, String message, Boolean cancelable) {

        // if (Build.VERSION.SDK_INT < 26) {
/*
        if (progressDialog != null) {
            progressDialog.setCancelable(cancelable);
            showProgressIndicator(show, message);
        }*/
        // }
    }
}

