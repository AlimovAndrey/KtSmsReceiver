package com.dev.kt.ktsmsreceiver;

import android.app.Application;
import android.content.Context;

/**
 * Created by Андрей on 20.03.2017.
 */

public class App extends Application {

    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
