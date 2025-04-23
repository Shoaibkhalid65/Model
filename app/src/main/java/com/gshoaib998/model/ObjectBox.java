package com.gshoaib998.model;

import android.content.Context;

import io.objectbox.BoxStore;

public class ObjectBox {
    static BoxStore boxStore;

    public static void init(Context context){
        boxStore=MyObjectBox.builder().androidContext(context).build();
    }
    public static BoxStore getBox() {
        return boxStore;
    }
}
