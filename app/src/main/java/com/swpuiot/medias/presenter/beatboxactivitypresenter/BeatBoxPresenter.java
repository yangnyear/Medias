package com.swpuiot.medias.presenter.beatboxactivitypresenter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;
import com.swpuiot.medias.data.Resource;
import com.swpuiot.medias.entities.Sound;
import com.swpuiot.medias.recycleviewadapter.beatbox.BeatBoxRecycleViewAdapter;

import java.util.ArrayList;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 * presenter of BeatBoxActivity
 */
public class BeatBoxPresenter implements BeatBoxHolder.presenter,MyItemLongClickListener,MyItemClickListener {
    private Context mContext;
    private BeatBoxHolder.view mView;
    private Resource mResource;
    private ArrayList<Sound> mRecycleViewListEntities;
    private BeatBoxRecycleViewAdapter adapter;

    public BeatBoxPresenter(Context context) {
        mContext = context;
        this.mView= (BeatBoxHolder.view) context;
        mResource=new Resource(mContext);
        mRecycleViewListEntities= mResource.getRecycleViewListEntities();
        adapter=new BeatBoxRecycleViewAdapter(mContext,mRecycleViewListEntities);
    }
    @Override
    public void setRecycViewAdapter() {
        mView.setRecycViewAdapter(adapter);
        adapter.setClickListener(this);
        adapter.setLongClickListener(this);
    }

    @Override
    public void releaseSoundPool() {
        mResource.release();
    }

    @Override
    public void onItemClick(View view, int position) {
       mResource.playSounds(mRecycleViewListEntities.get(position));
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(mContext,"长按",Toast.LENGTH_SHORT).show();
    }
}
