package com.bawei.wangguanhua2020032.model;

import android.util.Log;

import com.bawei.wangguanhua2020032.contract.IHomePageContract;
import com.bawei.wangguanhua2020032.utils.VolleyUtils;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 关联网络工具类
 */
public class HomePageModel implements IHomePageContract.IModel {
    @Override
    public void onGetList(String url, final IHomePageContract.ListCallBack listCallBack) {
        //调用网络工具类的方法
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                listCallBack.onSuccess(json);
                Log.i("xxx",json);
            }

            @Override
            public void onFailure(String msg) {
                listCallBack.onFailure(msg);
                Log.i("xxx",msg);
            }
        });
    }
}
