package com.swpuiot.medias.presenter.sunsetpresenter;

import android.content.Context;

/**
 * Created by 羊荣毅_L on 2017/3/26.
 */
public class SunSetPresenter implements SunSetHolder.presenter {
    private SunSetHolder.View mView;
    private Context mContext;

    public SunSetPresenter(Context context) {
        mContext = context;
        mView= (SunSetHolder.View) context;
    }

    @Override
    public void startAnimation() {
        mView.startAnimation();
    }
}
