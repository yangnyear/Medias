package com.swpuiot.medias.presenter.mainactivitypresenter;

import android.content.Intent;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 */
public interface MainHolder {
    interface presenter {
        void sendNotice();

        void sendMyNotice();

        void startActivity(Intent intent);

    }

    interface view {
        //发送通知
        void sendNotification();

        void sendMyNotification();

        //界面跳转
        void mStartActivity(Intent intent);
    }
}
