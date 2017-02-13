package com.virgil.mvvmgrasp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.base.BaseActivity;
import com.virgil.mvvmgrasp.databinding.ActivityMainBinding;
import com.virgil.mvvmgrasp.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private MainViewModel mainViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setViewModel() {
        mainViewModel = new MainViewModel();
        mBinding.setViewModel(mainViewModel);
    }

    @Override
    protected void init() {
        super.init();
        mainViewModel.loadData();
    }
}
