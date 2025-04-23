package com.gshoaib998.model;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ObjectBox.init(this);
    }
}
