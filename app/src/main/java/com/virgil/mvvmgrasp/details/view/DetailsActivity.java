package com.virgil.mvvmgrasp.details.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.virgil.mvvmgrasp.R;
import com.virgil.mvvmgrasp.utils.ToastCustomUtils;

public class DetailsActivity extends AppCompatActivity {
    private Context mContext = this;
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = getIntent().getExtras().getString("name");
        ToastCustomUtils.showSuccessToast(mContext, name);
    }
}
