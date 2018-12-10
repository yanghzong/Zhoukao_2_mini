package com.bway.zhoukao_2_mini;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bway.zhoukao_2_mini.adapter.BannerAdapter;
import com.bway.zhoukao_2_mini.adapter.ShowAdapter;
import com.bway.zhoukao_2_mini.bean.BannerBean;
import com.bway.zhoukao_2_mini.bean.ShowBean;
import com.bway.zhoukao_2_mini.inter.ICallBack;
import com.bway.zhoukao_2_mini.utils.HttpUtils;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BannerBean.DataBean> bannerlist;
    private ViewPager vpBanner;
    private List<ShowBean.NewslistBean> showlist;
    private ShowAdapter showAdapter;
    private RecyclerView xrvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();



        bannerlist = new ArrayList<>();
        showlist = new ArrayList<>();

    }




    private void initData() {
        HttpUtils.getInstance().doget(new ICallBack() {


            private BannerAdapter bannerAdapter;

            @Override
            public void onSuccess(Object obj) {
                bannerAdapter = new BannerAdapter(MainActivity.this, (List<BannerBean.DataBean>) obj);
                vpBanner.setAdapter(bannerAdapter);
                showAdapter = new ShowAdapter(MainActivity.this, (List<ShowBean.NewslistBean>) obj);
                xrvShow.setAdapter(showAdapter);
                xrvShow.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));



            }

            @Override
            public void onFailed(Exception e) {

            }
        });

    }

    private void initView() {
        vpBanner = findViewById(R.id.vp_banner);
        xrvShow = findViewById(R.id.xrv_show);

    }
}
