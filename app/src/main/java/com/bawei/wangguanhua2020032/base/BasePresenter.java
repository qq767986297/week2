package com.bawei.wangguanhua2020032.base;

import java.lang.ref.WeakReference;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 建立P层抽象类,建立方法
 */
public abstract class BasePresenter<V extends IBaseView>{
    private WeakReference<V> vWeakReference;

    //构造方法
    public BasePresenter(V v) {
        //获取弱引用
        vWeakReference = new WeakReference<>(v);
        //调用方法
        initModel();
    }
    //创建抽象方法
    public abstract void initModel();
    //创建getView方法
    public V getView(){
        if(vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
    //解除方法
    public void  datachView(){
        if(vWeakReference!=null){
            //清除
            vWeakReference.clear();
            //引用置空
            vWeakReference=null;
        }
    }
}
