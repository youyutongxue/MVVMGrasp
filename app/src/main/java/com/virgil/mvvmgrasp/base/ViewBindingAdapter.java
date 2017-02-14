package com.virgil.mvvmgrasp.base;

import android.databinding.BindingAdapter;
import android.view.View;

import com.kelin.mvvmlight.command.ReplyCommand;

/**
 * Created by 陈有余 on 2017/2/14 16:51.
 */

public class ViewBindingAdapter {
    @BindingAdapter({"clickCommand"})
    public static void clickCommand(View view, final ReplyCommand clickCommand) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCommand != null) {
                    clickCommand.execute();
                }
            }
        });
    }

    @BindingAdapter(value = {"clickCommand", "param"})
    public static void clickCommand(View view, final ReplyCommand<Object> clickCommand, Object object) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCommand != null) {
                    clickCommand.execute(object);
                }
            }
        });
    }
}
