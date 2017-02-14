package com.virgil.mvvmgrasp.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 陈有余 on 2017/2/14 17:03.
 */

public class NavigateUtils {
    /**
     * 普通跳转
     *
     * @param activity
     * @param activityClass
     */
    public static void startActivity(Activity activity, Class<? extends Activity> activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, Class<? extends Activity> activityClass, Bundle bundle) {
        Intent intent = new Intent(activity, activityClass);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, Class<? extends Activity> activityClass, Bundle bundle, int flags) {
        Intent intent = new Intent(activity, activityClass);
        intent.putExtras(bundle);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(flags);
        activity.startActivity(intent);
    }
}
