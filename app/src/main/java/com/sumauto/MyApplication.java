package com.sumauto;

import android.app.Application;

import com.sumauto.support.Initializer;

/**
 * Created by Lincoln on 2015/10/13.
 */
public class MyApplication extends Application

{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Initializer.init(this,true);
    }
}
