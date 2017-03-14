package com.swpuiot.medias.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.beatboxactivitypresenter.BeatBoxHolder;
import com.swpuiot.medias.presenter.beatboxactivitypresenter.BeatBoxPresenter;
import com.swpuiot.medias.recycleviewadapter.RecycleViewAdapter;

public class BeatBoxActivity extends AppCompatActivity implements BeatBoxHolder.view{
    private RecyclerView mRecyclerView;
    private BeatBoxHolder.presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_beat_box);
        inite();
        mPresenter.setRecycViewAdapter();
    }

    public void inite() {
        setSupportActionBar((Toolbar) findViewById(R.id.tb_beatbox));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPresenter=new BeatBoxPresenter(this);
        mGridLayoutManager=new GridLayoutManager(this,4);
        mRecyclerView= (RecyclerView) findViewById(R.id.rc_beatbox);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setRecycViewAdapter(RecycleViewAdapter recycViewAdapter) {
        if (recycViewAdapter!=null){
            mRecyclerView.setAdapter(recycViewAdapter);
        }
    }
}
