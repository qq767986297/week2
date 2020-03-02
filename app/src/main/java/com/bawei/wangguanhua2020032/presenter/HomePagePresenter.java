package com.bawei.wangguanhua2020032.presenter;

import android.util.Log;

import com.bawei.wangguanhua2020032.base.BasePresenter;
import com.bawei.wangguanhua2020032.base.IBaseView;
import com.bawei.wangguanhua2020032.contract.IHomePageContract;
import com.bawei.wangguanhua2020032.model.HomePageModel;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 创建P层,继承BasePresenter,实现契约类中P层接口,
 * 负责M层和V层的交互
 */
public class HomePagePresenter extends BasePresenter implements IHomePageContract.IPresenter {

    private HomePageModel model;

    public HomePagePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void initModel() {
           //实例化M层
        model = new HomePageModel();
    }

    @Override
    public void getListData(String url) {
        //调用M层方法
        model.onGetList(url, new IHomePageContract.ListCallBack() {
            @Override
            public void onSuccess(String str) {
                Log.i("xxx",str);
                //获取方法
                IBaseView view = getView();
                //判断view是否是IView的实例
                if(view instanceof IHomePageContract.IView){
                    IHomePageContract.IView iView= (IHomePageContract.IView) view;
                    //调用成功方法
                    iView.onSuccess(str);

                }
            }

            @Override
            public void onFailure(String str) {
                //获取方法
                IBaseView view = getView();
                //判断view是否是IView的实例
                if(view instanceof IHomePageContract.IView){
                    IHomePageContract.IView iView= (IHomePageContract.IView) view;
                    //调用失败方法
                    iView.onFailure(str);

                }
            }
        });
    }
}
