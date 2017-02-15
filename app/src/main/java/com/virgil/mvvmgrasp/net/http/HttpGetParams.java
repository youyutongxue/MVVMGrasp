package com.virgil.mvvmgrasp.net.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by virgil on 2017/2/14 10:51.
 */

public class HttpGetParams {

    public static Map<String, String> paramHome(String gender, String generation) {
        Map<String, String> map = new HashMap<>();
        map.put("gender", gender);
        map.put("generation", generation);
        return map;
    }
}
