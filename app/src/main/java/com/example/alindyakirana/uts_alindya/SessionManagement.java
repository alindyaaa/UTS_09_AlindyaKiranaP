package com.example.alindyakirana.uts_alindya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import java.util.HashMap;

public class SessionManagement {
    //Share preference
    private SharedPreferences mSharedPreference;

    //Editor for shared preference
    private SharedPreferences.Editor mEditor;

    //context
    private Context mContext;

    //shared pref mode
    int PRIVATE_MODE;

    //shared pref name
    private static final String PREF_NAME = "SharedPrefLatihan";

    //shared preferences keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL ="Email";
    public static final String KEY_PASSWORD = "email";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor= mSharedPreference.edit();

    }

    public void createLoginSession(String email, String password){
        //storing login value as TRUE
        mEditor.putBoolean(IS_LOGIN, true);

        //storing email
        mEditor.putString(KEY_EMAIL, email);

        //storing password
        mEditor.putString(KEY_PASSWORD, password);
        mEditor.commit();
    }

    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();

        //user email
        user.put(KEY_EMAIL, mSharedPreference.getString(KEY_EMAIL, null));

        //user password
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD, null));

        return user;
    }

    public boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        // check login status
        if (!isLoggedIn()) {
            // user is not logged in redirect to MainActivity
            Intent i = new Intent(mContext, MainActivity.class);

            //Closing all the activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // add new flag to start new activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    public void logoutUser(){
        // clearing all data from shared preferences
        mEditor.clear();
        mEditor.commit();

        // after logout redirect user to loing activity
        Intent i = new Intent(mContext, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
