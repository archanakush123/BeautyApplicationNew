package com.example.techpex.beautyapplication.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.adapters.HomeScreenPagerAdapter;
import com.example.techpex.beautyapplication.home.adapters.HomeScreenRecyclerAdapter;
import com.example.techpex.beautyapplication.home.callbacks.PagerImageClickListner;
import com.example.techpex.beautyapplication.home.callbacks.RecyclerImageClickListner;

import java.util.Timer;
import java.util.TimerTask;

public class HomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,PagerImageClickListner,RecyclerImageClickListner {

    RecyclerView recycler_view;
    HomeScreenRecyclerAdapter homeScreenRecyclerAdapter;
    CardView card_view_pager;
    ViewPager view_pager;
    int currentPage = 0;
    HomeScreenPagerAdapter homeScreenPagerAdapter;
    private ImageView mToggle , img_cart_icon;

    public static final String title[] =  {"Bleach","Bridal","Facial","Hair","MakeUp","Massage","Nails","Threading","Waxing","Hair&chemical"};
    public static final int images[] = {R.drawable.pack1,R.drawable.pack2,R.drawable.pack1,R.drawable.pack2,R.drawable.pack1,R.drawable.pack1,R.drawable.pack2,R.drawable.pack1,R.drawable.pack2,R.drawable.pack1,R.drawable.pack1,R.drawable.pack2,R.drawable.pack1,R.drawable.pack2,R.drawable.pack1};
    public static final int images1[] = {R.drawable.pack1,R.drawable.pack2,R.drawable.pack3,R.drawable.pack4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setLayoutRefs();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setViewPagerTab();
    }

    private void setViewPagerTab() {

        homeScreenPagerAdapter = new HomeScreenPagerAdapter(HomeScreenActivity.this,images1);
        view_pager.setAdapter(homeScreenPagerAdapter);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images1.length) {
                    currentPage = 0;
                }
                view_pager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
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

        switch(item.getItemId()){

            case R.id.nav_login:
                openLoginActivity();
                break;
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_my_appointment:
                openFixAppointmentActivity();
                break;
            default:
                break;
        }
        /*int id = item.getItemId();

        if (id == R.id.nav_login) {
            Intent intent = new Intent(HomeScreenActivity.this,LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_my_appointment) {
            Intent intent = new Intent(HomeScreenActivity.this,FixAppointmentActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_blog) {
            Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_contact_us) {
            Intent intent = new Intent(HomeScreenActivity.this,ContactUs.class);
            intent.putExtra("fragmantToLoad",0);
            startActivity(intent);
        } else if (id == R.id.nav_help) {
            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFixAppointmentActivity() {
        Intent intent = new Intent(HomeScreenActivity.this,FixAppointmentActivity.class);
        startActivity(intent);
    }

    private void openLoginActivity() {
        Intent intent = new Intent(HomeScreenActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void setLayoutRefs() {

        mToggle = findViewById(R.id.img_toggel);
        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        img_cart_icon = findViewById(R.id.img_cart_icon);
        img_cart_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        recycler_view = findViewById(R.id.recycler_view);
        homeScreenRecyclerAdapter = new HomeScreenRecyclerAdapter(HomeScreenActivity.this,images,title);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycler_view.setAdapter(homeScreenRecyclerAdapter);

        card_view_pager = findViewById(R.id.card_view_pager);
        card_view_pager.setOnClickListener(this);

        view_pager = findViewById(R.id.view_pager);
        view_pager.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.view_pager:
                openSchemeGridView();
                break;

           default:
               break;
        }
    }

    private void openSchemeGridView() {

        Intent intent = new Intent(HomeScreenActivity.this,SchemeGridActivity.class);
        startActivity(intent);
    }


    @Override
    public void onPagerImageClick(int selectedImagePosition) {
        Intent intent = new Intent(HomeScreenActivity.this,SchemeGridActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRecyclerImageClick(int selectedImagePosition) {
        Intent intent = new Intent(HomeScreenActivity.this,SchemeDetailListActivity.class);
        startActivity(intent);

    }
}
