package com.virgil.mvvmgrasp.net;

/**
 * Created by 陈有余 on 2017/2/13 16:52.
 */

public class UrlConfig {
    public static final String BASEURL = "http://api.liwushuo.com/";

    public static class Path {
        public static final String TABURL = "v2/channels/preset";
    }

    public static class Key {
        public static final String GENDER = "gender";
        public static final String GENERATION = "generation";
    }
    public static class DefaultValue {
        public static final String GENDER = "1";
        public static final String GENERATION = "2";
    }

}
