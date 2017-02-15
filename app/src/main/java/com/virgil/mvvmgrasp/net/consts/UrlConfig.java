package com.virgil.mvvmgrasp.net.consts;

/**
 * Created by virgil on 2017/2/13 16:52.
 */

public class UrlConfig {
    public static final String BASEURL = "http://api.liwushuo.com/";
    public static final String TEST_URL="https://api.douban.com/";

    public static class Path {
        public static final String TAB = "v2/channels/preset";
        public static final String TOPMOVIE = "v2/movie/top250";
    }

    public static class Key {
        public static final String GENDER = "gender";
        public static final String GENERATION = "generation";

        public static final String START = "start";
        public static final String COUNT = "count";
    }
    public static class DefaultValue {
        public static final String GENDER = "1";
        public static final String GENERATION = "2";

        public static final String START = "0";
        public static final String COUNT = "10";
    }

}
