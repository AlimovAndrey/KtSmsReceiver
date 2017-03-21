package com.dev.kt.ktsmsreceiver.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dev.kt.ktsmsreceiver.App;

/**
 * Created by Андрей on 14.03.2017.
 */

public class StoragePref {

    private static final String INIT_HOST = "ftp.kt.ua";
    private static final String INIT_PATH = "SMS/";
    private static final String INIT_LOGIN = "obmen";
    private static final String INIT_PASSWORD = "Ob20091941";

    private static final String MAIN_PREFERENCES = "main_preferences";

    private static final String SMS_SERVICE_STATUS = "sms_service_status";

    private static final String KEY_HOST_NAME = "host_name";
    private static final String KEY_PATH = "path";
    private static final String KEY_LOGIN = "login";
    private static final String KEY_PASSWORD = "password";

    public static boolean isServiceStarted() {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getBoolean(SMS_SERVICE_STATUS, false);
    }

    public static void setServiceStarted(boolean started){
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SMS_SERVICE_STATUS, started);
        editor.apply();
    }

    public static String getHostName() {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getString(KEY_HOST_NAME, INIT_HOST);
    }

    public static void setHostName(String host_name){
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_HOST_NAME, host_name);
        editor.apply();
    }

    public static String getPath() {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getString(KEY_PATH, INIT_PATH);
    }

    public static void setPath(String path){
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_PATH, path);
        editor.apply();
    }

    public static String getLogin() {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getString(KEY_LOGIN, INIT_LOGIN);
    }

    public static void setLogin(String login){
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_LOGIN, login);
        editor.apply();
    }

    public static String getPassword() {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getString(KEY_PASSWORD, INIT_PASSWORD);
    }

    public static void setPassword(String login) {
        SharedPreferences settings = App.getAppContext()
                .getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_PASSWORD, login);
        editor.apply();
    }
}
