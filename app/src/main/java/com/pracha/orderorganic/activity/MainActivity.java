package com.pracha.orderorganic.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.pracha.orderorganic.R;
import com.pracha.orderorganic.fragments.HomeFragment;
import com.pracha.orderorganic.fragments.OffersFragment;
import com.pracha.orderorganic.fragments.ProfileFragment;
import com.pracha.orderorganic.fragments.SearchFragment;
import com.pracha.orderorganic.models.models.sidemenu.ChildModel;
import com.pracha.orderorganic.models.models.sidemenu.HeaderModel;
import com.pracha.orderorganic.models.models.sidemenu.HomeMenuList;
import com.pracha.orderorganic.presenters.MenuListPresenter;
import com.pracha.orderorganic.utils.ConnectionDetector;
import com.pracha.orderorganic.utils.Constants;
import com.pracha.orderorganic.utils.ExpandableNavigationListView;
import com.pracha.orderorganic.utils.Utilities;
import com.pracha.orderorganic.views.MenuListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MenuListView {

    private static int num_pages = 0;
    @BindView(R.id.navigation)
    AHBottomNavigation bottomNavigationView;

    @BindView(R.id.expandable_navigation)
    ExpandableNavigationListView navigationExpandableListView;

    MenuListPresenter menuListPresenter;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        menuListPresenter = new MenuListPresenter();
        menuListPresenter.attachView(this);
        if (ConnectionDetector.isConnectedToInternet(MainActivity.this)) {
            showProgressIndicator(true);
            menuListPresenter.getMenuListDetails();
        } else {
            Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, MainActivity.this);
        }
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.content_frame, new HomeFragment())
                .commit();


        createBottomNavigation();
        createsidemenu();
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationExpandableListView.addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                HeaderModel headerModel = (HeaderModel) parent.getAdapter().getItem(groupPosition);
                if (headerModel.getTitle().equals("Track order")) {
                    showMessage(headerModel.getTitle() + " Clicked");
                } else if (headerModel.getTitle().equals("Account details")) {
                    showMessage(headerModel.getTitle() + " Clicked");
                } else if (headerModel.getTitle().equals("Settings")) {
                    showMessage(headerModel.getTitle() + " Clicked");
                } else if (headerModel.getTitle().equals("Sign out")) {
                    showMessage(headerModel.getTitle() + " Clicked");
                }

                return false;
            }
        });

        /*

        navigationExpandableListView
                .init(this)
                .addHeaderModel(new HeaderModel("Home"))
                .addHeaderModel(new HeaderModel("Cart", R.drawable.cartbackground, false, true, false))
                .addHeaderModel(
                        new HeaderModel("Categories", R.drawable.ic_add_black_24dp, true)
                                .addChildModel(new ChildModel("Men's Fashion"))
                                .addChildModel(new ChildModel("Woman's Fashion"))
                                .addChildModel(new ChildModel("Babies and Family"))
                                .addChildModel(new ChildModel("Health"))
                )
                .addHeaderModel(new HeaderModel("Orders"))
                .addHeaderModel(new HeaderModel("Wishlist"))
                .addHeaderModel(new HeaderModel("Notifications"))
                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        navigationExpandableListView.setSelected(groupPosition);

                        //drawer.closeDrawer(GravityCompat.START);
                        if (id == 0) {
                            //Home Menu

                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 1) {
                            //Cart Menu
                            drawer.closeDrawer(GravityCompat.START);
                        } */
/*else if (id == 2) {
                            //Categories Menu
                            Common.showToast(context, "Categories  Select");
                        }*//*
 else if (id == 3) {
                            //Orders Menu
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 4) {
                            //Wishlist Menu
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 5) {
                            //Notifications Menu
                            drawer.closeDrawer(GravityCompat.START);
                        }
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        navigationExpandableListView.setSelected(groupPosition, childPosition);

                        if (id == 0) {
                        } else if (id == 1) {
                        } else if (id == 2) {
                        } else if (id == 3) {
                        }

                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });
        navigationExpandableListView.expandGroup(2);
*/

    }

    private void createsidemenu() {

    }

    private void createBottomNavigation() {

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.title_home, R.drawable.home, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.title_offers, R.drawable.offers, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.title_cart, R.drawable.cart, R.color.white);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.title_search, R.drawable.search, R.color.white);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.title_profile, R.drawable.user2, R.color.white);

        bottomNavigationView.addItem(item1);
        bottomNavigationView.addItem(item2);
        bottomNavigationView.addItem(item3);
        bottomNavigationView.addItem(item4);
        bottomNavigationView.addItem(item5);

        bottomNavigationView.setDefaultBackgroundColor(Color.parseColor("#333333"));

        bottomNavigationView.setBehaviorTranslationEnabled(true);

        bottomNavigationView.setAccentColor(Color.parseColor("#36dd31"));
        bottomNavigationView.setInactiveColor(Color.parseColor("#ffffff"));

        bottomNavigationView.setForceTint(true);

        bottomNavigationView.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


        bottomNavigationView.setCurrentItem(0);

        bottomNavigationView.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

        AHNotification notification = new AHNotification.Builder()
                .setText("1")
                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                .build();

        bottomNavigationView.setNotification(notification, 2);

        bottomNavigationView.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.content_frame, new HomeFragment())
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.content_frame, new OffersFragment())
                                .commit();
                        break;
                    case 2:
                        /*getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.content_frame, new CartFragment())
                                .commit();*/
                        startActivity(new Intent(MainActivity.this, SigninActivity.class));
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.content_frame, new SearchFragment())
                                .commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.content_frame, new ProfileFragment())
                                .commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId), MainActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message, MainActivity.this);
    }

    @Override
    public void getMenuListDetails(final HomeMenuList homeMenuList) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (homeMenuList.getCategorylist().size() > 0) {
                    navigationExpandableListView.init(MainActivity.this);
                    for (int i = 0; i < homeMenuList.getCategorylist().size(); i++) {
                        List<HeaderModel> headerModelList = new ArrayList<>();
                        List<ChildModel> childModels = new ArrayList<>();
                        if (homeMenuList.getCategorylist().get(i).getSubcategoryList().size() > 0) {
                            int cat_id = Integer.parseInt(homeMenuList.getCategorylist().get(i).getCategoryId());
                            HeaderModel headerModel = new HeaderModel(homeMenuList.getCategorylist().get(i).getCategoryName(),
                                    R.drawable.ic_add_black_24dp, true);
                            headerModel.setCat_id(cat_id);
                            headerModel.setChildModelList(childModels);
                            headerModelList.add(headerModel);
                            for (int j = 0; j < homeMenuList.getCategorylist().get(i).getSubcategoryList().size(); j++) {
                                int sub_cat_id = Integer.parseInt(homeMenuList.getCategorylist().get(i).getSubcategoryList().get(j).getSubcategoryId());
                                ChildModel childModel = new ChildModel(homeMenuList.getCategorylist().get(i).getSubcategoryList().get(j).getSubcategoryName());
                                childModel.setMy_id(sub_cat_id);
                                childModels.add(childModel);
                            }
                        } else {
                            int cat_id = Integer.parseInt(homeMenuList.getCategorylist().get(i).getCategoryId());
                            HeaderModel headerModel = new HeaderModel(homeMenuList.getCategorylist().get(i).getCategoryName());
                            headerModel.setCat_id(cat_id);
                            headerModelList.add(headerModel);
                        }
                        navigationExpandableListView.setListMenu(headerModelList);
                    }
                    navigationExpandableListView.addHeaderModel(new HeaderModel("Track order"))
                            .addHeaderModel(new HeaderModel("Account details"))
                            .addHeaderModel(new HeaderModel("Settings"))
                            .addHeaderModel(new HeaderModel("Sign out"));
                    navigationExpandableListView.build();
                }
                Utilities.showToastLong("Successfull" + homeMenuList.getCategorylist().get(13).getSubcategoryList().size(), MainActivity.this);

            }
        }).run();
    }

/*
    @Override
    public void getHomeDetails(HomePageDetails homePageDetails) {
//        Utilities.showToastLong("Successfull" + homePageDetails.getCategorylist().get(0).getCategoryId(), MainActivity.this);
    }*/
}
