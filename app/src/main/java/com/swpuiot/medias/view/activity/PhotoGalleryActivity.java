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
import com.swpuiot.medias.presenter.photogallerypresenter.PhotoGalleryPresenter;
import com.swpuiot.medias.recycleviewadapter.photogallery.PhotoGalleryRecycleViewAdapter;

public class PhotoGalleryActivity extends AppCompatActivity implements PhotoGalleryHolder.view {
    private RecyclerView mRecyclerView;
    private PhotoGalleryHolder.presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_app_compay);
        inite();
        mPresenter.setRecycViewAdapter();

    }

    public void inite() {
        setSupportActionBar((Toolbar) findViewById(R.id.tb_photogallery));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.rc_PhotoGallery);
        mGridLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPresenter = new PhotoGalleryPresenter(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setRecycViewAdapter(PhotoGalleryRecycleViewAdapter adapter) {
        if (adapter != null) {
            mRecyclerView.setAdapter(adapter);
        }
    }
}
