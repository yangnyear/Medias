package com.swpuiot.medias.presenter;

import android.content.Context;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 */
public class MainPresenter implements MainHolder.presenter {
    private MainHolder.view mView;
    private Context mContext;


    public MainPresenter(Context context) {
        mContext = context;
        mView = (MainHolder.view) context;

    }

    @Override
    public void sendNotice() {
        mView.sendNotification();
    }

    @Override
    public void sendMyNotice() {
        mView.sendMyNotification();
    }

    @Override
    public void startActivity() {
     mView.startMessageActivity();
    }
}
