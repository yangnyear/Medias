package com.swpuiot.medias.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.draganddrawactivitypresenter.DragAndDrawHolder;

public class DragAndDrawActivity extends AppCompatActivity implements DragAndDrawHolder.view {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_drag_and_draw);
        inite();
    }
    public void inite() {
        setSupportActionBar((Toolbar) findViewById(R.id.tb_draganddraw));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
