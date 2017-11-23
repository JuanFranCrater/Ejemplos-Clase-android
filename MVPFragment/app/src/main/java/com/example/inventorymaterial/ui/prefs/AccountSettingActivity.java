package com.example.inventorymaterial.ui.prefs;

import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.example.inventorymaterial.R;

public class AccountSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
