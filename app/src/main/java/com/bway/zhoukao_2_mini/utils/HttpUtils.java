package com.bway.zhoukao_2_mini.utils;

import android.os.Handler;

import com.bway.zhoukao_2_mini.bean.BannerBean;
import com.bway.zhoukao_2_mini.bean.ShowBean;
import com.bway.zhoukao_2_mini.inter.ICallBack;
import com.bway.zhoukao_2_mini.inter.MynetInterface;
import com.bway.zhoukao_2_mini.inter.Url_API;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 择木 on 2018/12/8.
 */

public class HttpUtils {
    private static HttpUtils instance;

    private Handler handler = new Handler();

    private OkHttpClient client;
    private MynetInterface mynetInterface;

    public HttpUtils() {
        client = new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .build();

    }


    public static HttpUtils getInstance() {
        //单例双重锁
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }



    public void doget(final ICallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Url_API.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mynetInterface = retrofit.create(MynetInterface.class);

        HashMap<String, String> map = new HashMap<>();


        Call<BannerBean> Banner = mynetInterface.getBanner(map);

        Banner.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response1) {
                List<BannerBean.DataBean> data = response1.body().getData();
                if (response1 != null && response1.isSuccess()) {
                    callBack.onSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {

            }
        });


    }
    int i = 10;
    public void doget1(final ICallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Url_API.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mynetInterface = retrofit.create(MynetInterface.class);

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("key", "71e58b5b2f930eaf1f937407acde08fe");
        map1.put("num", i + "");
        i++;

        Call<ShowBean> show = mynetInterface.getShow(map1);

        show.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                List<ShowBean.NewslistBean> newslist = response.body().getNewslist();
                if (response != null && response.isSuccess()) {
                    callBack.onSuccess(newslist);
                }
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

            }
        });







    }
}

