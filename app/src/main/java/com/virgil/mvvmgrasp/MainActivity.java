package com.virgil.mvvmgrasp;

import com.virgil.mvvmgrasp.base.BaseActivity;
import com.virgil.mvvmgrasp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    //private MainViewModel mainViewModel;
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
