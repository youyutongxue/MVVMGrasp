package com.virgil.mvvmgrasp.home.model;

/**
 * Created by virgil on 2017/2/13 16:58.
 */

public class HomeBean {
    /**
     * code : 200
     * data : {"candidates":[{"editable":true,"id":10,"name":"送女票","url":null},{"editable":true,"id":129,"name":"海淘","url":null},{"editable":true,"id":125,"name":"创意生活","url":null},{"editable":true,"id":26,"name":"送基友","url":null},{"editable":true,"id":6,"name":"送爸妈","url":null},{"editable":true,"id":17,"name":"送同事","url":null},{"editable":true,"id":24,"name":"送宝贝","url":null},{"editable":true,"id":127,"name":"设计感","url":null},{"editable":true,"id":14,"name":"文艺风","url":null},{"editable":true,"id":126,"name":"奇葩搞怪","url":null},{"editable":true,"id":28,"name":"科技范","url":null},{"editable":true,"id":11,"name":"萌萌哒","url":null}],"channels":[{"editable":false,"id":101,"name":"精选"},{"editable":true,"id":10,"name":"送女票","url":null},{"editable":true,"id":129,"name":"海淘","url":null},{"editable":true,"id":125,"name":"创意生活","url":null},{"editable":true,"id":26,"name":"送基友","url":null},{"editable":true,"id":6,"name":"送爸妈","url":null},{"editable":true,"id":17,"name":"送同事","url":null},{"editable":true,"id":24,"name":"送宝贝","url":null},{"editable":true,"id":127,"name":"设计感","url":null},{"editable":true,"id":14,"name":"文艺风","url":null},{"editable":true,"id":126,"name":"奇葩搞怪","url":null},{"editable":true,"id":28,"name":"科技范","url":null},{"editable":true,"id":11,"name":"萌萌哒","url":null}]}
     * message : OK
     */

    private int code;
    private HomeBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HomeBean getData() {
        return data;
    }

    public void setData(HomeBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
