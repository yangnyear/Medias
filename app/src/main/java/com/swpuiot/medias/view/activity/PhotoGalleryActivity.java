package com.swpuiot.medias.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.photogallerypresenter.PhotoGalleryHolder;

public class PhotoGalleryActivity extends AppCompatActivity implements PhotoGalleryHolder.view{
    private RecyclerView mRecyclerView;
    private PhotoGalleryHolder.presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_app_compay);
        inite();
    }
    public void inite(){
        setSupportActionBar((Toolbar) findViewById(R.id.tb_photogallery));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
