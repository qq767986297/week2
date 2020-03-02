package com.bawei.wangguanhua2020032.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //加载控件
        initView();
        //处理数据
        initData();
        presenter = initPresenter();
    }

    public P getPresenter() {
        return presenter;
    }
    //编写抽象方法
    public abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();
    //创建销毁方法

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.datachView();
            //置空
            presenter=null;
        }
    }
}
