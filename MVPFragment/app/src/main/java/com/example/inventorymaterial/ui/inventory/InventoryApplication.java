package com.example.inventorymaterial.ui.inventory;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import com.example.inventorymaterial.data.prefs.AppPreferencesHelper;

/**
 * Created by usuario on 25/10/17.
 */

public class InventoryApplication extends Application {

    private AppPreferencesHelper appPreferencesHelper;

    public InventoryApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper= AppPreferencesHelper.getInstance();
    }
    public AppPreferencesHelper getAppPreferencesHelper()
    {
        return appPreferencesHelper;
    }


    public static Context getTheContext() {
        return ;
    }
}