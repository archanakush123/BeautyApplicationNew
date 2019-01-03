package com.example.techpex.beautyapplication.home.adapters;

import android.app.Activity;
import android.content.Context;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.fragments.Blog;
import com.example.techpex.beautyapplication.home.fragments.HelpFragment;

import java.util.ArrayList;


public class ContactsUsPagerAdapter extends FragmentPagerAdapter {

    Context context;
    Activity activity;

    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> fragmentTitleList = new ArrayList<>();
    int fragmentToLoad;

    public ContactsUsPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        this.activity = (Activity) context;

        fragmentList.add(new Blog());
        fragmentTitleList.add(activity.getString(R.string.about_us));
        fragmentList.add(new HelpFragment());
        fragmentTitleList.add(activity.getString(R.string.help));
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0:
                return fragmentTitleList.get(position);
            case 1:
                return fragmentTitleList.get(position);
            case 2:
                return fragmentTitleList.get(position);
            default:
                return null;
        }
    }
}
