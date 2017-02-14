package com.virgil.mvvmgrasp.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.virgil.mvvmgrasp.home.model.HomeBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 陈有余 on 2017/2/13 16:46.
 */

public class HttpRequest {
    private static volatile HttpRequest singleton;
    private Retrofit mRetrofit;
    private RequestApi mRequestApi;

    private HttpRequest() {

    }

    public static HttpRequest getSingleton() {
        if (singleton == null) {
            synchronized (HttpRequest.class) {
                if (singleton == null) {
                    singleton = new HttpRequest();
                }
            }
        }
        return singleton;
    }

    /**
     * 创建retrofit实例
     *
     * @return
     */
    private Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build();
    }

    /**
     * 创建gson实例,用于retrofit解析返回的结果
     *
     * @return
     */
    private Gson createGson() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        return gson;
    }

    /**
     * 创建网络接口的实例
     *
     * @return
     */
    private RequestApi createRequsetApi() {
        RequestApi iPresent = mRetrofit.create(RequestApi.class);
        return iPresent;
    }

    /**
     * 网络访问获取主页面标签数据的方法
     *
     * @param params
     * @param callback
     */
    public void getHomeTabData(String baseUrl, Map<String, String> params, Callback<HomeBean> callback) {
        mRetrofit = createRetrofit(baseUrl);
        mRequestApi = createRequsetApi();
        Call<HomeBean> call = mRequestApi.getHomeTabData(params);
        call.enqueue(callback);
    }
}
