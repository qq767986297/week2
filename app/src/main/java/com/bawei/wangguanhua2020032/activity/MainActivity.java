package com.bawei.wangguanhua2020032.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.wangguanhua2020032.R;
import com.bawei.wangguanhua2020032.adapter.BeanAdapter;
import com.bawei.wangguanhua2020032.adapter.GridAdapter;
import com.bawei.wangguanhua2020032.adapter.VerticalAdapter;
import com.bawei.wangguanhua2020032.base.BaseActivity;
import com.bawei.wangguanhua2020032.base.BasePresenter;
import com.bawei.wangguanhua2020032.bean.Bean;
import com.bawei.wangguanhua2020032.contract.IHomePageContract;
import com.bawei.wangguanhua2020032.presenter.HomePagePresenter;
import com.google.gson.Gson;

import java.util.List;
/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 * 展示布局,实现V层接口
 * 解析数据,展示列表
 */
public class MainActivity extends BaseActivity implements IHomePageContract.IView {


    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private ListView lv;

    @Override
    public BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
    //关联控件
    @Override
    protected void initView() {
        rv1 = findViewById(R.id.rv1);
        rv2 = findViewById(R.id.rv2);
        rv3 = findViewById(R.id.rv3);

    }
    //处理数据
    @Override
    protected void initData() {
        //网络接口
        String path="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
        //获取getPresenter
      //  BasePresenter presenter = getPresenter();
        //判断掉方法
//        if(presenter!=null&&presenter instanceof BasePresenter){
//            Log.i("PPP",path);
//            ((HomePagePresenter)presenter).getListData(path);
//        }
        BasePresenter presenter = getPresenter();
        if(presenter!=null&&presenter instanceof BasePresenter){
            ((HomePagePresenter)presenter).getListData(path);
        }

    }

    @Override
    public void onSuccess(String str) {
        Log.i("xxx",str);
        //gson解析
        Gson gson = new Gson();
        Bean bean = gson.fromJson(str, Bean.class);
        Bean.DataBean data = bean.getData();
        //获取一个列表集合
        List<Bean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        //获取二个列表集合
        final List<Bean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        //获取三个列表集合
        List<Bean.DataBean.GridDataBean> gridData = data.getGridData();
        //设置第一个列表管理器
        LinearLayoutManager manager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv1.setLayoutManager(manager1);
        //创建适配器
        BeanAdapter adapter = new BeanAdapter(this, horizontalListData);
        //设置适配器
        rv1.setAdapter(adapter);
        //设置第二个列表管理器
        LinearLayoutManager manager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv2.setLayoutManager(manager2);
        //创建适配器
        VerticalAdapter adapter1 = new VerticalAdapter(this, verticalListData);
        rv2.setAdapter(adapter1);
        //调用适配器点击事件
        adapter1.onClick(new VerticalAdapter.IClick() {
            @Override
            public void onClick(int position) {
                Bean.DataBean.VerticalListDataBean bean1 = verticalListData.get(position);
                String price = bean1.getPrice();
                //设置条目点击事件，点击吐司商品价格。
                Toast.makeText(MainActivity.this, ""+price, Toast.LENGTH_SHORT).show();
            }
        });
        //设置第三个列表管理器
        GridLayoutManager manager3 = new GridLayoutManager(this, 2);
        rv3.setLayoutManager(manager3);
        GridAdapter adapter2 = new GridAdapter(this, gridData);
        rv3.setAdapter(adapter2);

    }

    @Override
    public void onFailure(String str) {

    }
}
