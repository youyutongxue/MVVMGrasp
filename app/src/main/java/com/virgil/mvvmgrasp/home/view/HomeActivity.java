package com.virgil.mvvmgrasp.home.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;

import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.base.BaseActivity;
import com.virgil.mvvmgrasp.databinding.ActivityHomeBinding;
import com.virgil.mvvmgrasp.home.viewmodel.HomeViewModel;
import com.virgil.mvvmgrasp.widget.recyclerview.decoration.DividerItemDecoration;
import com.virgil.mvvmgrasp.widget.recyclerview.decoration.SpacesItemDecoration;

public class HomeActivity extends BaseActivity<ActivityHomeBinding>{
    private HomeViewModel mHomeViewModel;
    private Context mContext = this;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setViewModel() {
        mHomeViewModel = new HomeViewModel(mContext);
        mBinding.setViewModel(mHomeViewModel);
    }

    @Override
    protected void init() {
        super.init();
        mHomeViewModel.loadData();
        mBinding.homeRv.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));
        mBinding.homeRv.setItemAnimator(new DefaultItemAnimator());
    }
}
