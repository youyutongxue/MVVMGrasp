package com.virgil.mvvmgrasp.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

/**
 * Created by 陈有余 on 2017/2/13 13:54.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T mBinding;
    private long mClickTime = 0l;
    private static int EXIT_TIMEOUT = 2500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppContext().setCurrentActivity(this);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        App.getAppContext().setCurrentBinding(mBinding);
        setViewModel();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getAppContext().setCurrentBinding(mBinding);
        App.getAppContext().setCurrentActivity(this);
    }

    /**
     * 该抽象方法就是 onCreate中需要的layoutID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 绑定ViewModel
     */
    protected abstract void setViewModel();

    /**
     * 初始化view及data
     */
    protected void init() {
    }
}