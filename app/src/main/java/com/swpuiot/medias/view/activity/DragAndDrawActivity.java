package com.swpuiot.medias.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.draganddrawactivitypresenter.DragAndDrawHolder;
import com.swpuiot.medias.view.myview.BoxDrawingView;

public class DragAndDrawActivity extends AppCompatActivity implements DragAndDrawHolder.view {
    private BoxDrawingView mBoxDrawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_drag_and_draw);
        inite();
    }
    public void inite() {
//        setSupportActionBar((Toolbar) findViewById(R.id.tb_draganddraw));
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBoxDrawingView= (BoxDrawingView) findViewById(R.id.topbar_text);
    }
}
