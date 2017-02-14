package com.virgil.mvvmgrasp.net;

import com.virgil.mvvmgrasp.home.model.HomeBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 陈有余 on 2017/2/13 16:48.
 */

public interface RequestApi {
    //主页面书签
    @GET(UrlConfig.Path.TABURL)
    Call<HomeBean> getHomeTabData(@QueryMap() Map<String, String> params);
}
