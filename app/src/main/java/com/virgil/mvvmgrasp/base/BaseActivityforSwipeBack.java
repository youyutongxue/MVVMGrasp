package com.virgil.mvvmgrasp.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

/**
 * Created by 陈有余 on 2017/2/13 13:54.
 */

public abstract class BaseActivityforSwipeBack<T extends ViewDataBinding> extends AppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;//侧滑返回
    protected T mBinding;
    private long mClickTime = 0l;
    private static int EXIT_TIMEOUT = 2500;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建侧滑返回的对象
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
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

    ///////////////////////////////////////////////////////////////////////////
    // SwipeBackActivityBase中的抽象方法
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
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