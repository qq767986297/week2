package com.bawei.wangguanhua2020032.contract;

import com.bawei.wangguanhua2020032.base.IBaseView;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 创建契约类,创建MVP各层的接口
 */
public interface IHomePageContract {
    //V层接口继承IBaseView
    interface IView extends IBaseView {
        //成功和失败两个方法
        void onSuccess(String str);
        void onFailure(String str);
    }
    //P层接口
    interface IPresenter{
        void getListData(String url);
    }
    //M层接口
    interface IModel{
        void onGetList(String url,ListCallBack listCallBack);
    }
    //用于M层接口回调
    interface ListCallBack{
        void onSuccess(String str);
        void onFailure(String str);
    }
}
