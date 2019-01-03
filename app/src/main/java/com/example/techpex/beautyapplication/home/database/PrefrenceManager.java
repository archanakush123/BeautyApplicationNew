package com.example.techpex.beautyapplication.home.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.techpex.beautyapplication.home.constants.GlobalConstant;

public class PrefrenceManager  {

    private static PrefrenceManager mPrefrenceManager;
    private SharedPreferences mSharedPreferences;

    public PrefrenceManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(GlobalConstant.PREFS_USER,Context.MODE_PRIVATE);
    }

    public static synchronized PrefrenceManager getInstance(Context context){
        if(mPrefrenceManager == null){
            mPrefrenceManager = new PrefrenceManager(context);
        }
        return mPrefrenceManager;
    }

    public void savePrefString(String key, String value){
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public void savePrefBoolean(String key, boolean value){
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public String getPrefString(String key){
        return mSharedPreferences.getString(key, "");
    }

    public boolean getPrefBoolean(String key){
        return mSharedPreferences.getBoolean(key, false);
    }
}
