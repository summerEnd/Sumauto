package com.sumauto.support.utils;

import android.graphics.Color;

/**
 * Created by Lincoln on 2015/10/13.
 */
public class ColorUtils
{
    public static int applyAlpha(float alpha,int color){
        return Color.argb((int) (alpha*255),
                Color.red(color),
                Color.green(color),
                Color.blue(color)
                );
    }
}
