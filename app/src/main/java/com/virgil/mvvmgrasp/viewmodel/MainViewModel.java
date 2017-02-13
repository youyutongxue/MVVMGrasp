package com.virgil.mvvmgrasp.viewmodel;

import android.app.Activity;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.kelin.mvvmlight.command.ReplyCommand;

/**
 * Created by 陈有余 on 2017/2/13 10:34.
 */

public class MainViewModel {
    //context
    private Activity context;
    //数据绑定（data field）
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();
    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();
    //true的时候弹出Dialog，false的时候关掉dialog
    public final ObservableBoolean isShowTextView = new ObservableBoolean();

    // 一个变量包含了所有关于View Style 相关的字段
    public final ViewStyle viewStyle = new ViewStyle();

    //命令绑定（command）
    public final ReplyCommand clickCommand = new ReplyCommand<>(() -> {
        title.set("娱乐新闻");
    });

    public final ReplyCommand isShowTextCommand = new ReplyCommand<>(() -> {
        if (isShowTextView.get() == true){
            isShowTextView.set(false);
        }else{
            isShowTextView.set(true);
        }
        Log.i("isShowTextView",isShowTextView.get()+"");
    });

    //Child ViewModel
    //public final ObservableList<NewItemViewModel> itemViewModel = new ObservableArrayList<>();

    /**
     * ViewStyle 关于控件的一些属性和业务数据无关的Style 可以做一个包裹，这样代码比较美观，
     * ViewModel 页面也不会有太多的字段。
     */
    public static class ViewStyle {
        public final ObservableBoolean isRefreshing = new ObservableBoolean(true);
        public final ObservableBoolean progressRefreshing = new ObservableBoolean(true);
    }

    public void loadData() {
        //这里进行网络访问。。。、

        //我们简单的模拟网络访问获取数据后给绑定数据赋值。。。
        title.set("体育新闻");
        name.set("autozi");
        address.set("北京");
        isShowTextView.set(false);
    }
}
