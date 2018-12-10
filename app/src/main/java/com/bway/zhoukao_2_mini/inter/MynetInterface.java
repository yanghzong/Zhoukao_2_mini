package com.bway.zhoukao_2_mini.inter;

import com.bway.zhoukao_2_mini.bean.BannerBean;
import com.bway.zhoukao_2_mini.bean.ShowBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 择木 on 2018/12/8.
 */

public interface MynetInterface {
    @GET("banner/json")
    Call<BannerBean> getBanner(@QueryMap Map<String,String> map);

    @GET("nba/")
    Call<ShowBean> getShow(@QueryMap Map<String,String> map1);
}
