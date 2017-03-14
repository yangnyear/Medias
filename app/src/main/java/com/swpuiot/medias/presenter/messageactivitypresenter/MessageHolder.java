package com.swpuiot.medias.presenter.messageactivitypresenter;

import android.content.IntentFilter;

import com.swpuiot.medias.data.MessageReceiver;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 *
 */
public interface MessageHolder {
    interface view {
        //显示短信拉远文本
        void setAddress(String address);
        //射显示短信内容
        void setContent(String content);
        //动态注册广播接收器
        void mRegisterReceiver(MessageReceiver messageReceiver,IntentFilter receiverFiler);
        //关闭广播接收器
        void mUnRegisterReceiver(MessageReceiver messageReceiver);
    }

    interface presenter {
        //提取短信头
        void acceptMessageAddress();
        //提取段性内容
        void acceptMessageContent();
        //动态注册广播接收器
        void mUnRegisterReceiver();
    }
}
