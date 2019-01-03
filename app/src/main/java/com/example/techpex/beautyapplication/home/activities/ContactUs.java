package com.example.techpex.beautyapplication.home.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.adapters.ContactsUsPagerAdapter;

public class ContactUs extends AppCompatActivity {

    ViewPager view_pager;
    ContactsUsPagerAdapter contactsUsPagerAdapter;
    int fragmentToLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact_us);
        setLayoutRefrences();
        getIntentDataValues();
        setPager();
    }

    private void setLayoutRefrences() {
        view_pager = findViewById(R.id.view_pager);
    }

    public void getIntentDataValues() {

        if (getIntent() != null) {
            //fragmentToLoad = getIntent().getExtras().getInt("fragmantToLoad");
        }
    }

    public void setPager() {
        contactsUsPagerAdapter = new ContactsUsPagerAdapter(ContactUs.this, getSupportFragmentManager());
        view_pager.setAdapter(contactsUsPagerAdapter);
        view_pager.setCurrentItem(fragmentToLoad, true);
       // txt_title.setText(contactsUsPagerAdapter.getPageTitle(fragmentToLoad));

        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              //  txt_title.setText(contactsUsPagerAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}