package com.virgil.mvvmgrasp.net.http;

import com.virgil.mvvmgrasp.home.model.HomeBean;
import com.virgil.mvvmgrasp.movie.model.TopMovieBean;
import com.virgil.mvvmgrasp.net.consts.UrlConfig;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by virgil on 2017/2/13 16:48.
 */

public interface RequestApi {
    //主页面书签
    @GET(UrlConfig.Path.TAB)
    Observable<HomeBean> getHomeTabData(@QueryMap() Map<String, String> params);

    //TopMovie
    @GET(UrlConfig.Path.TOPMOVIE)
    Observable<TopMovieBean> getTopMovieData(@QueryMap() Map<String, String> params);
}
