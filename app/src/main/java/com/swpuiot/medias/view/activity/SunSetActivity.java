package com.swpuiot.medias.view.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.sunsetpresenter.SunSetHolder;
import com.swpuiot.medias.presenter.sunsetpresenter.SunSetPresenter;

public class SunSetActivity extends AppCompatActivity implements SunSetHolder.View,View.OnClickListener {
    private SunSetHolder.presenter mPresenter;
    private View mSunView;
    private View mSkyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sun_set2);
        inite();
        mSkyView.setOnClickListener(this);
    }

    public void inite() {
        setSupportActionBar((Toolbar) findViewById(R.id.tb_sunset));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPresenter=new SunSetPresenter(this);

        mSkyView = findViewById(R.id.sky);
        mSunView = findViewById(R.id.sun);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startAnimation() {
        float sunVStart = mSunView.getTop();
        float mSunVEnd = mSkyView.getHeight();
        ObjectAnimator heirhtAnimator = ObjectAnimator
                .ofFloat(mSunView, "y", sunVStart, mSunVEnd)
                .setDuration(3000);
        heirhtAnimator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sky:
                mPresenter.startAnimation();
                break;
        }
    }
}
