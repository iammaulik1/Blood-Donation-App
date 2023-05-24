package com.stepup.blooddonationapp2.Util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;

import java.io.File;

public class Method {
    public static Activity activity;
    public static boolean share = false, onBackPress = false, allowPermitionExternalStorage = false,slider=false,loginBack=false;
    public static Bitmap mbitmap;
    private static File file;
    private String filename;


    public static Typeface scriptable;

    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    private final String myPreference = "login";

    public Method(Activity activity) {
        this.activity = activity;
        scriptable = Typeface.createFromAsset(activity.getAssets(), "fonts/montserrat_bold.ttf");
        pref = activity.getSharedPreferences(myPreference, 0); // 0 - for private mode
        editor = pref.edit();

    }

}
