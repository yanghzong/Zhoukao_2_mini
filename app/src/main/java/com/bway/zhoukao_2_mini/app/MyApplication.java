package com.bway.zhoukao_2_mini.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 择木 on 2018/12/8.
 */

public class MyApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
