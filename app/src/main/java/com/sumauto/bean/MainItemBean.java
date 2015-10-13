package com.sumauto.bean;

import android.app.Activity;

/**
 * Created by Lincoln on 2015/10/13.
 */
public class MainItemBean
{
    public final String name;
    public final Class<? extends Activity> activity;

    public MainItemBean(Class<? extends Activity> activity)
    {
        this(activity.getSimpleName(),activity);
    }

    public MainItemBean(String name, Class<? extends Activity> activity)
    {
        this.name = name;
        this.activity = activity;
    }
}
