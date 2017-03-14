package com.swpuiot.medias.presenter;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 */
public interface MainHolder {
    interface presenter{
        void sendNotice();
        void sendMyNotice();
        void startActivity();
    }
    interface view{
         void sendNotification();
        void sendMyNotification();
        void startMessageActivity();
    }
}
