package com.virgil.mvvmgrasp.net.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.virgil.mvvmgrasp.home.model.HomeBean;
import com.virgil.mvvmgrasp.movie.model.TopMovieBean;
import com.virgil.mvvmgrasp.net.consts.UrlConfig;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by virgil on 2017/2/13 16:46.
 */

public class HttpRequest {
    private static volatile HttpRequest singleton;
    private Retrofit mRetrofit;
    private RequestApi mRequestApi;
    private static final int DEFAULT_TIMEOUT = 5;

    private HttpRequest() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(UrlConfig.BASEURL)
                .build();

        mRequestApi = mRetrofit.create(RequestApi.class);
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
     * 获取首页数据
     *
     * @param params
     * @param subscriber
     */
    public void getHomeTabData(Map<String, String> params, Subscriber<HomeBean> subscriber) {
        printUrl(UrlConfig.BASEURL, UrlConfig.Path.TAB, params);
        mRequestApi.getHomeTabData(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * TopMovie
     *
     * @param params
     * @param subscriber
     */
    public void getTopMovieData(Map<String, String> params, Subscriber<TopMovieBean> subscriber) {
        printUrl(UrlConfig.BASEURL, UrlConfig.Path.TOPMOVIE, params);
        mRequestApi.getTopMovieData(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 打印访问的url
     *
     * @param baseUrl
     * @param path
     * @param params
     */
    public void printUrl(String baseUrl, String path, Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            s.append(entry.getKey() + "=" + entry.getValue());
            s.append("&");
        }
        Log.i("url", baseUrl + path + "?" + s);
    }
}
