package com.virgil.mvvmgrasp.home.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.virgil.mvvmgrasp.BR;
import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.home.model.HomeBean;
import com.virgil.mvvmgrasp.net.HttpGetParams;
import com.virgil.mvvmgrasp.net.HttpRequest;
import com.virgil.mvvmgrasp.net.UrlConfig;
import com.virgil.mvvmgrasp.utils.ToastCustomUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.tatarka.bindingcollectionadapter.ItemView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 陈有余 on 2017/2/13 17:00.
 */

public class HomeViewModel {
    private Context mContext;
    public final ObservableList<HomeBean.DataBean.ChannelsBean> totalList = new ObservableArrayList<>();
    public final ItemView itemHomeView = ItemView.of(BR.data, R.layout.item_home);

    public HomeViewModel(Context ctx) {
        this.mContext = ctx;
    }

    public void loadData() {

        HttpRequest.getSingleton().getHomeTabData(UrlConfig.BASEURL
                , HttpGetParams.paramHome(UrlConfig.DefaultValue.GENDER, UrlConfig.DefaultValue.GENERATION),
                new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                if (response.body() != null) {
                    List<HomeBean.DataBean.ChannelsBean> channels = response.body().getData().getChannels();
                    totalList.addAll(channels);
                    ToastCustomUtils.showSuccessToast(mContext, "success");
                }
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                ToastCustomUtils.showErrorToast(mContext, "网络访问失败");
            }
        });
    }
}
