package com.bawei.wangguanhua2020032.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangguanhua2020032.base.App;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 网络工具类,单例模式,网络判断,get请求
 */
public class VolleyUtils {

    private final RequestQueue queue;

    //创建构造方法
    public VolleyUtils() {
        queue = Volley.newRequestQueue(App.getAppContext());
    }
    //单例模式
    private static class SingleInstance{
        private static final VolleyUtils INSTANCE=new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return SingleInstance.INSTANCE;
    }
    //⑥　封装网络状态判断方法，可以判断有网无网。
    public boolean isNetWork(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if(info!=null){
            return true;
        }else {
            return false;
        }
    }
    //get请求方法
    public void doGet(String path, final ICallBack iCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.onFailure(error.getMessage());
            }
        });
        //添加到队列中
        queue.add(stringRequest);
    }
    //创建接口
    public interface ICallBack{
        void onSuccess(String json);
        void onFailure(String msg);
    }
}
