package com.virgil.mvvmgrasp.home.model;

import android.os.Bundle;
import android.util.Log;

import com.kelin.mvvmlight.command.ReplyCommand;
import com.virgil.mvvmgrasp.base.App;
import com.virgil.mvvmgrasp.details.view.DetailsActivity;
import com.virgil.mvvmgrasp.utils.NavigateUtils;

import java.util.List;

/**
 * Created by virgil on 2017/2/13 16:58.
 */

public class HomeBean {

    /**
     * code : 200
     * data : {"candidates":[{"editable":true,"id":10,"name":"送女票","url":""},{"editable":true,"id":125,"name":"创意生活","url":""},{"editable":true,"id":26,"name":"送基友","url":""},{"editable":true,"id":6,"name":"送爸妈","url":""},{"editable":true,"id":127,"name":"设计感","url":""},{"editable":true,"id":14,"name":"文艺风","url":""},{"editable":true,"id":126,"name":"奇葩搞怪","url":""},{"editable":true,"id":28,"name":"科技范","url":""},{"editable":true,"id":121,"name":"数码","url":""},{"editable":true,"id":124,"name":"爱读书","url":""}],"channels":[{"editable":false,"id":101,"name":"精选"},{"editable":true,"id":10,"name":"送女票","url":""},{"editable":true,"id":125,"name":"创意生活","url":""},{"editable":true,"id":26,"name":"送基友","url":""},{"editable":true,"id":6,"name":"送爸妈","url":""},{"editable":true,"id":127,"name":"设计感","url":""},{"editable":true,"id":14,"name":"文艺风","url":""},{"editable":true,"id":126,"name":"奇葩搞怪","url":""},{"editable":true,"id":28,"name":"科技范","url":""},{"editable":true,"id":121,"name":"数码","url":""},{"editable":true,"id":124,"name":"爱读书","url":""}]}
     * message : OK
     */

    public int code;
    public DataBean data;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * editable : true
         * id : 10
         * name : 送女票
         * url :
         */

        public List<CandidatesBean> candidates;
        /**
         * editable : false
         * id : 101
         * name : 精选
         */

        public List<ChannelsBean> channels;

        public List<CandidatesBean> getCandidates() {
            return candidates;
        }

        public void setCandidates(List<CandidatesBean> candidates) {
            this.candidates = candidates;
        }

        public List<ChannelsBean> getChannels() {
            return channels;
        }

        public void setChannels(List<ChannelsBean> channels) {
            this.channels = channels;
        }

        public static class CandidatesBean {
            public boolean editable;
            public int id;
            public String name;
            public String url;

            public boolean isEditable() {
                return editable;
            }

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ChannelsBean {
            public boolean editable;
            public int id;
            public String name;

            public boolean isEditable() {
                return editable;
            }

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ReplyCommand clickCommand = new ReplyCommand<HomeBean.DataBean.ChannelsBean>((homeBean) -> {
                Log.i("item", homeBean.name + "s");
                Bundle bundle = new Bundle();
                bundle.putString("name", homeBean.name);
                NavigateUtils.startActivity(App.getAppContext().getCurrentActivity(), DetailsActivity.class, bundle);
            });
        }
    }
}
