package com.bawei.wangguanhua2020032.base;

import android.app.Application;
import android.content.Context;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 */
public class App extends Application {
    private static Context context;
    //获取全局上下文
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    //创建一个静态方法调用全局上下文
    public static Context getAppContext(){
        return context;
    }
}
