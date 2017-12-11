package com.example.inventorymaterial.data.prefs;

import android.content.SharedPreferences;

import com.example.inventorymaterial.ui.inventory.InventoryApplication;
import com.example.inventorymaterial.ui.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper,GeneralPreferencesHelper {
    /**
     * 1) Se define todas las Key posibles del fichero preferences
     */


    //2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper() {
        //Si es el fichero por defecto de las preferencias
        this.preferences = (InventoryApplication.getTheContext()).getSharedPreferences(AppConstants.PREF_NAME,0);
        //Si es un fichero con nombre diferente
    }

    public static AppPreferencesHelper getInstance()
    {
        if(instance==null)
        {
            instance=new AppPreferencesHelper();
        }
        return instance;
    }

    /**
     * ID SQLite
     * @return
     */
    public long getCurrentUserId() {
        long id=preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName() {
        String name=preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public String getCurrentUserPassword() {
        String password=preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }

    public boolean getCurrentUserRemember() {
        boolean Remember=preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return Remember;
    }


    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID,id).apply();
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME,name).apply();
    }

    public void setCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD,password).apply();
    }

    public void setCurrentUserRemember(boolean remember) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER,remember).apply();
    }
}
