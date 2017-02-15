package com.virgil.mvvmgrasp.details.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.base.BaseActivityforSwipeBack;
import com.virgil.mvvmgrasp.utils.ToastCustomUtils;

public class DetailsActivity extends BaseActivityforSwipeBack {
    private Context mContext = this;
    private String name = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void setViewModel() {

    }

    @Override
    protected void init() {
        super.init();
        name = getIntent().getExtras().getString("name");
        ToastCustomUtils.showSuccessToast(mContext, name);
    }
}
