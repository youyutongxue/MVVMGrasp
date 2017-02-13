package com.virgil.mvvmgrasp.model;

/**
 * Created by 陈有余 on 2017/2/13 10:34.
 */

public class NewsBean {
    public String title;
    public String userName;
    public String time;
    public String address;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
