package com.virgil.mvvmgrasp.home.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.virgil.mvvmgrasp.BR;
import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.home.model.HomeBean;
import com.virgil.mvvmgrasp.net.http.HttpGetParams;
import com.virgil.mvvmgrasp.net.http.HttpRequest;
import com.virgil.mvvmgrasp.net.consts.UrlConfig;
import com.virgil.mvvmgrasp.net.subscribers.ProgressSubscriber;
import com.virgil.mvvmgrasp.net.subscribers.SubscriberOnNextListener;
import com.virgil.mvvmgrasp.utils.ToastCustomUtils;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.subjects.Subject;

/**
 * Created by 陈有余 on 2017/2/13 17:00.
 */

public class HomeViewModel {
    private Context mContext;
    private SubscriberOnNextListener getTopMovieOnNext;

    public final ObservableList<HomeBean.DataBean.ChannelsBean> totalList = new ObservableArrayList<>();
    public final ItemView itemHomeView = ItemView.of(BR.data, R.layout.item_home);

    public HomeViewModel(Context ctx) {
        this.mContext = ctx;
        getTopMovieOnNext = new SubscriberOnNextListener<HomeBean>() {
            @Override
            public void onNext(HomeBean subjects) {
                totalList.addAll(subjects.getData().getChannels());
                Log.i("channels", totalList.size() + "");
            }
        };
    }

    public void loadData() {
        HttpRequest.getSingleton().getHomeTabData(HttpGetParams.paramHome(UrlConfig.DefaultValue.GENDER, UrlConfig.DefaultValue.GENERATION),
                new ProgressSubscriber(getTopMovieOnNext, mContext));
    }
}
